package com.tree.gdhealth.customer.signup.vo;

import lombok.Data;

@Data
public class Customer {
	private int customerNo;
	private String customerId;
	private String customerPw;
	private String customerActive;
	private String createdate;
	private String updatedate;
}
