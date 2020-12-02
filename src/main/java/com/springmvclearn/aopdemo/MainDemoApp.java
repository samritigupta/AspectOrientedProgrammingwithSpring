package com.springmvclearn.aopdemo;

import com.springmvclearn.aopdemo.dao.AccountDAO;
import com.springmvclearn.aopdemo.dao.MembershipDAO;
import com.springmvclearn.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO =
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();

		// do it again!
		System.out.println("\nlet's call it again!\n");
		
		// call the business method again
		theAccountDAO.addAccount();

		// call the membership business method
		theMembershipDAO.addAccount();

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
				
		// close the context
		context.close();
	}

}










