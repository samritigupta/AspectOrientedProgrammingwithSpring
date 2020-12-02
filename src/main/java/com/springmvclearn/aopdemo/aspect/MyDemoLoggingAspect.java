package com.springmvclearn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

	// will be triggered before any addAccount
	@Before("execution(public void addAccount())")   // this is point cut expression (a predicate expression for where advice should be applied.)
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}

	@Before("execution(public void com.springmvclearn.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAccountDAOAdvice() {

		System.out.println("\n=====>>> Executing @Before advice on addAccount() on AccountDAO");

	}

	@Before("execution(public void add*())")
	public void beforeAddAdvice() {

		System.out.println("\n=====>>> Executing @Before advice on add*()");

	}

	// Modifier is optional so for * can remove it
	@Before("execution(void add*())")
	public void beforeAddAdviceAnyModifier() {

		System.out.println("\n=====>>> Executing @Before advice on add*() on any modifier");

	}

	@Before("execution(public void com.springmvclearn.aopdemo.dao.*.*(com.springmvclearn.aopdemo.entity.Account,..))")
	public void beforeOnAnyClassAnyMethodInAbovePackageWithParameterMatchedAdvice() {

		System.out.println("\n=====>>> Executing @Before advice on addAccount(Account) on AccountDAO");

	}

	@Before("execution(public void com.springmvclearn.aopdemo.dao.*.*(..))")
	public void beforeOnAnyClassAnyMethodInAbovePackageWithAnyParameterAdvice() {

		System.out.println("\n=====>>> Executing @Before advice on addAccount() on AccountDAO");

	}
}










