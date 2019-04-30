package com.jacklin.myshop.entity;

import lombok.Data;

@Data
public class AdminUser {
    private Integer id;

    private String ausername;

    private String apassword;

    private String vercode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
    
    
    
    
}