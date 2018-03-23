package com.example.demo.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Table(name = "User")
@Entity
public class User 
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String fullname;
	String gender;
	String mobile;
	String address;
	String email;
	String username;
	String password;
	String confirmpassword;
	@CreationTimestamp
	 Date createdTime;

	@UpdateTimestamp
	 Date updatedTime;
	public User() 
	{
		super();
	}
	
	public User(int id, String fullname,String gender, String mobile, String address, String email,
			String username, String password, String confirmpassword, Date createdTime, Date updatedTime) 
	{
		super();
		this.id = id;
		this.fullname = fullname;
		//this.lastname = lastname;
		this.gender = gender;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/*public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}*/
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() 
	{
		return "User [id=" + id + ", fullname=" + fullname + ", gender=" + gender + ", mobile=" + mobile + ", address="
				+ address + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + "]";
	}

	
	
}
