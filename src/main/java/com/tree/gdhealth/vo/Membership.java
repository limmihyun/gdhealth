package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class Membership {
	private int membershipNo;
	private String membershipName;
	private String membershipMonth;
	private String membershipPrice;
	private String createdate;
	private String updatedate;
	private String active;
}
