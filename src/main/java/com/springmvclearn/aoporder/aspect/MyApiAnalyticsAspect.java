package com.springmvclearn.aoporder.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
how to contol the ordering of Pointcut expression??
 */
@Aspect
@Component
@Order(123)   // if order is same for 2 aspect then its undefined and random.
public class MyApiAnalyticsAspect {

	@Before("com.springmvclearn.aoporder.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");		
	}

}
