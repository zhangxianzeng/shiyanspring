package com.example.shiyanspring.common.aop;

import java.lang.reflect.Method;

import com.example.shiyanspring.common.annotation.CheckParam;
import com.example.shiyanspring.common.annotation.CheckParams;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


/**
 * 参数校验 切面
 * 要求对象参数，使用json格式封装
 * @author yuxue
 * @date 2019-05-11
 */
@Aspect
@Component
public class CheckParamAop {

	@Pointcut("@annotation(com.example.shiyanspring.common.annotation.CheckParam)")
	public void checkParam() {
	}
	
	@Pointcut("@annotation(com.example.shiyanspring.common.annotation.CheckParams)")
	public void checkParams() {
	}

	@Around("checkParam()") // 这里要换成自定义注解的路径
	public Object check1(ProceedingJoinPoint point) throws Throwable {
		Object obj;
		// 参数校验
		String msg = doCheck(point, false);
		if (null != msg) {
			throw new IllegalArgumentException(msg);
		}
		// 通过校验，继续执行原有方法
		obj = point.proceed();
		return obj;
	}
	
	
	@Around("checkParams()") // 这里要换成自定义注解的路径
	public Object check2(ProceedingJoinPoint point) throws Throwable {
		Object obj;
		// 参数校验
		String msg = doCheck(point, true);
		if (null != msg) {
			throw new IllegalArgumentException(msg);
		}
		// 通过校验，继续执行原有方法
		obj = point.proceed();
		return obj;
	}
	

	/**
	 * 参数校验
	 * @param point 切点
	 * @param multi 多参数校验
	 * @return 错误信息
	 */
	private String doCheck(JoinPoint point, boolean multi) {
		Method method = this.getMethod(point);
		String[] paramName = this.getParamName(point);
		Object[] arguments = point.getArgs();	// 获取接口传递的所有参数
		
		Boolean isValid = true;
		String msg = null;
		if(multi) {	// 多个参数校验
			CheckParams annotation = method.getAnnotation(CheckParams.class);	// AOP监听带注解的方法，所以不用判断注解是否为空
			CheckParam[] annos = annotation.value();
			for (CheckParam anno : annos) {
				String argName = anno.argName();
				Object value = this.getParamValue(arguments, paramName, argName);	//参数值
		        isValid = anno.value().fun.apply(value, anno.express());	// 执行判断 // 调用枚举类的 CheckUtil类方法
		        if(!isValid) {	// 只要有一个参数判断不通过，立即返回
		        	msg = anno.msg();
			        if(null == msg || "".equals(msg)) {
			        	msg = argName + ": " + anno.value().msg + " " + anno.express();
			        }
		        	break;
		        }
			}
		} else {	// 单个参数校验
			CheckParam anno = method.getAnnotation(CheckParam.class);		// AOP监听带注解的方法，所以不用判断注解是否为空
			
			String argName = anno.argName();
			Object value = this.getParamValue(arguments, paramName, argName);	//参数值
	        isValid = anno.value().fun.apply(value, anno.express());	// 执行判断 // 调用枚举类的 CheckUtil类方法
	        msg = anno.msg();
	        if(null == msg || "".equals(msg)) {
	        	msg = argName + ": " + anno.value().msg + " " + anno.express();
	        }
		}
        if(isValid) {
        	// log.info("参数校验通过");
        	return null;
        } else {
        	// log.error("参数校验不通过");
        	return msg ;
        }
	}
	

	/**
	 * 获取参数名称
	 * jdk 1.8 特性
	 * @param joinPoint
	 * @return
	 */
	private String[] getParamName(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		String[] strings = methodSignature.getParameterNames();
		return strings;
	}


	/**
	 * 根据参数名称，获取参数值
	 * @param arguments
	 * @param paramName
	 * @param argName
	 * @return
	 */
	private Object getParamValue(Object[] arguments, String[] paramName, String argName) {
		Object value = null;
		String name = argName;
		if(argName.contains(".")) {
			name = argName.split("\\.")[0];
		}
		int index = 0;
		for (String string : paramName) {
			if(string.equals(name)) {
				value = arguments[index];	//基本类型取值	// 不做空判断，如果注解配置的参数名称不存在，则取值为null
				break;
			}
			index++;
		}
		if(argName.contains(".")) {	//从对象中取值
			argName = argName.split("\\.")[1];
			JSONObject jo = (JSONObject) JSONObject.wrap(value);
			// 从实体对象中取值
			try {
				value = jo.get(argName);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return value;
	}


	/**
	 * 获取方法
	 * @param joinPoint ProceedingJoinPoint
	 * @return 方法
	 */
	private Method getMethod(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		if (method.getDeclaringClass().isInterface()) {
			try {
				method = joinPoint
						.getTarget()
						.getClass()
						.getDeclaredMethod(joinPoint.getSignature().getName(),
								method.getParameterTypes());
			} catch (SecurityException | NoSuchMethodException e) {
				// log.error("" + e);
			}
		}
		return method;
	}


}
