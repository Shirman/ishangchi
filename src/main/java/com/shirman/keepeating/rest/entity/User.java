package com.shirman.keepeating.rest.entity;

public class User {
	
	private String name; //姓名
	private int age; //年龄
	private Integer tel; //电话
	private double tall; //身高
	private Double weight; //体重
	private Long id; //id
	private long idCardNumber; //身份证号码
	private String password; //密码
	private boolean man; //是男人
	private Boolean woman; //是女人
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public double getTall() {
		return tall;
	}
	public void setTall(double tall) {
		this.tall = tall;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getIdCardNumber() {
		return idCardNumber;
	}
	public void setIdCardNumber(long idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public boolean isMan() {
		return man;
	}
	public void setMan(Boolean man) {
		this.man = man;
	}
	public Boolean getWoman() {
		return woman;
	}
	public void setWoman(Boolean woman) {
		this.woman = woman;
	}
}
