package com.bean;

import io.swagger.annotations.ApiModelProperty;

public class UserDetailBean {

	@ApiModelProperty(required =true)
	private String ls_username;
	@ApiModelProperty(required = true)
	private String ls_userpassword;
	@ApiModelProperty("passed 1st name.")
	private String ls_first_name;
	@ApiModelProperty("passed last name.")
	private String ls_last_name;
	@ApiModelProperty("passed Address name.")
	private String ls_address;
	@ApiModelProperty(required = false)
	private int    li_mobile;

	public String getLs_address() {
		return ls_address;
	}
	public void setLs_address(String ls_address) {
		this.ls_address = ls_address;
	}
	public int getLi_mobile() {
		return li_mobile;
	}
	public void setLi_mobile(int li_mobile) {
		this.li_mobile = li_mobile;
	}
	public String getLs_username() {
		return ls_username;
	}
	public void setLs_username(String ls_username) {
		this.ls_username = ls_username;
	}
	public String getLs_userpassword() {
		return ls_userpassword;
	}
	public void setLs_userpassword(String ls_userpassword) {
		this.ls_userpassword = ls_userpassword;
	}
	public String getLs_first_name() {
		return ls_first_name;
	}
	public void setLs_first_name(String ls_first_name) {
		this.ls_first_name = ls_first_name;
	}
	public String getLs_last_name() {
		return ls_last_name;
	}
	public void setLs_last_name(String ls_last_name) {
		this.ls_last_name = ls_last_name;
	}
}

