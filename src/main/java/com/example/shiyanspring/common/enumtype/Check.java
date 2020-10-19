package com.example.shiyanspring.common.enumtype;

import java.util.function.BiFunction;

import com.example.shiyanspring.common.util.CheckUtil;




/**
 * 参数校验枚举类
 * 参考 hibernate-validator 的实现方式
 * @author yuxue
 * @date 2019-05-11
 */
public enum Check {

	Null("参数必须为 null", CheckUtil::isNull),

	NotNull("参数必须不为 null", CheckUtil::isNotNull),

	Empty("参数的必须为空", CheckUtil::isEmpty),
	
	NotEmpty("参数必须非空", CheckUtil::isNotEmpty),
	
	True("参数必须为 true", CheckUtil::isTrue),

	False("参数必须为 false", CheckUtil::isFalse),

	Date("参数必须是一个日期 yyyy-MM-dd", CheckUtil::isDate),

	DateTime("参数必须是一个日期时间 yyyy-MM-dd HH:mm:ss", CheckUtil::isDateTime),

	Past("参数必须是一个过去的日期", CheckUtil::isPast),

	Future("参数必须是一个将来的日期", CheckUtil::isFuture),
	
	Today("参数必须今天的日期", CheckUtil::isToday),
	
	Enum("参数必须在枚举中", CheckUtil::inEnum),
	
	Email("参数必须是Email地址", CheckUtil::isEmail),

	Range("参数必须在合适的范围内", CheckUtil::inRange),

	NotIn("参数必须不在指定的范围内", CheckUtil::outRange),
	
	Length("参数长度必须在指定范围内", CheckUtil::inLength),
	
	gt("参数必须大于指定值", CheckUtil::isGreaterThan),
	
	lt("参数必须小于指定值", CheckUtil::isLessThan),
	
	ge("参数必须大于等于指定值", CheckUtil::isGreaterThanEqual),
	
	le("参数必须小于等于指定值", CheckUtil::isLessThanEqual),
	
	ne("参数必须不等于指定值", CheckUtil::isNotEqual),
	
	Equal("参数必须不等于指定值", CheckUtil::isEqual),
	
	Pattern("参数必须符合指定的正则表达式", CheckUtil::isPattern)	;

	public String msg;
	
	/**
	 * BiFunction：接收字段值(Object)和 表达式(String)，返回是否符合规则(Boolean)
	 */
	public BiFunction<Object, String, Boolean> fun;

	Check(String msg, BiFunction<Object, String, Boolean> fun) {
		this.msg = msg;
		this.fun = fun;
	}
}
