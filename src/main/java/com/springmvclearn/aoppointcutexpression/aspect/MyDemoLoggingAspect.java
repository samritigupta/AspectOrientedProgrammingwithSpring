package com.springmvclearn.aoppointcutexpression.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// want to use same expression can create on pointcut and reuse it anywhere.
	@Pointcut("execution(* com.springmvclearn.aoppointcutexpression.dao.*.*(..))")
	private void forDaoPackage() {}

	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}

	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}

	/*
	How to apply multiple point cuts to single advice?
	 */
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {		
		System.out.println("\n=====>>> Executing @Before advice on method");		
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");		
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdviceCombinedPointCut() {
		System.out.println("\n=====>>> Executing @Before advice on getter and setter");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalyticsCombinedPointCut() {
		System.out.println("\n=====>>> Performing API analytics on getter and setter");
	}

	
}










