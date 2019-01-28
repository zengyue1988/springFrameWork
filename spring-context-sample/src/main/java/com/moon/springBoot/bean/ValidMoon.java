package com.moon.springBoot.bean;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class ValidMoon {
	
	@NotBlank(message="user name can not be empty")
	@Size(max=12, min=6, message="user name length must be between 6 and 12")
	private String userName;
	@Pattern(regexp = "^[0-9]+$")
	private String password;
	@NotNull(message="age must not be null")
	@Min(value=18)
	@Max(value=70)
	private int age;
	@DecimalMin(value="1800", inclusive=true)
	@DecimalMax(value="5000")
	private Integer salary;
	@Email
	private String eMail;
	@URL
	private String url;
	@Past
	private Date birthday;
	@Future
	private Date accountExpireDate;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getAccountExpireDate() {
		return accountExpireDate;
	}
	public void setAccountExpireDate(Date accountExpireDate) {
		this.accountExpireDate = accountExpireDate;
	}
	
}
