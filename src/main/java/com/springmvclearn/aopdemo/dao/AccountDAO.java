package com.springmvclearn.aopdemo.dao;

import com.springmvclearn.aopdemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": ---> DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
