package com.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 经销商
 * @author Administrator
 *
 */
@Entity
@Table(name="dealer")
public class Dealer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String linkman;
	private String phone;
	private String address;
	@Column(name="regist_date")
	private Date registeDate;
	@Column(name="business_license")
	private String businessLicense;
	private Integer status ;
	private String organization;
	@Column(name="brand_proxy")
	private String brandProxy;
	private Integer device;
	private String text1;
	private String text2;
	private String text3;
	@ManyToMany(targetEntity=Area.class,fetch=FetchType.LAZY)
	@JoinTable(joinColumns={@JoinColumn(name="dealer_id")},
				inverseJoinColumns={@JoinColumn(name="area_id")},
				name="dealer_area")
	private Set<Area> area ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegisteDate() {
		return registeDate;
	}
	public void setRegisteDate(Date registeDate) {
		this.registeDate = registeDate;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getBrandProxy() {
		return brandProxy;
	}
	public void setBrandProxy(String brandProxy) {
		this.brandProxy = brandProxy;
	}
	public Integer getDevice() {
		return device;
	}
	public void setDevice(Integer device) {
		this.device = device;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getText3() {
		return text3;
	}
	public void setText3(String text3) {
		this.text3 = text3;
	}
	public Set<Area> getArea() {
		return area;
	}
	public void setArea(Set<Area> area) {
		this.area = area;
	}
	
	
	
}
