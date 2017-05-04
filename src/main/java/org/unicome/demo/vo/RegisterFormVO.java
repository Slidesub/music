package org.unicome.demo.vo;

import java.io.Serializable;

public class RegisterFormVO implements Serializable{

	private static final long serialVersionUID = -3847612029439973855L;
	public String phone;
    public String code;

    public RegisterFormVO() {
    }

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
}
