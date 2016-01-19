package com.shirman.ishangchi.rest.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: User 
 * @Description: 
 * @author Shirman
 * @date 2016年1月13日 下午3:10:07 
 * @version V1.0
 */
public class User implements Serializable{
	
	public User(){};
	
	public User(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public User(String username,String password,Integer id){
		this(username, password);
		this.id = id;
	}
	
	private static final long serialVersionUID = -5596960755447031775L;
	private Integer id;
	private String username;
	private String password;
	private Integer role;
	private String mobile;
	private String email;
	private Integer address;
	private Integer age;
	private String idCard;
	private Integer status;
	private List<String> roles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAddress() {
		return address;
	}
	public void setAddress(Integer address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
