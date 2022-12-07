package com.hotel.vo;

public class hotelVO {
	String name,id,pass,email,lev,phone;
	// 관리자랑 일반회원 구분할 lev 추가

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "hotelVO [name=" + name + ", id=" + id + ", pass=" + pass + ", email=" + email + ", lev=" + lev
				+ ", phone=" + phone + "]";
	}
	

}
