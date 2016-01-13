package com.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 门店信息
 * @author Administrator
 *
 */
@Entity
@Table(name="store")
public class Store implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(name="user_name")
	private String userName;
	private String linkman;
	@Column(name="introducer_phone")
	private String introducerPhone;
	@Column(name="regist_date")
	private Date registDate;
	@Column(name="update_date")
	private Date updateDate;
	@Column(name="business_hours")
	private String buinessHours;
	private Integer status ;
	private String logo;
	private String address;
	private Double longitude;
	private Double latitude;
	private Integer staff_number;
	@Column(name="planting_duration")
	private Integer plantingDuration;
	private Double covering;
	private Integer imgs;
	@Column(name="business_license")
	private String businessLicense;
	private String email;
	private Integer device;
	@Column(name="area_id")
	private Integer areaId;
	private String text1;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getIntroducerPhone() {
		return introducerPhone;
	}
	public void setIntroducerPhone(String introducerPhone) {
		this.introducerPhone = introducerPhone;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getBuinessHours() {
		return buinessHours;
	}
	public void setBuinessHours(String buinessHours) {
		this.buinessHours = buinessHours;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Integer getStaff_number() {
		return staff_number;
	}
	public void setStaff_number(Integer staff_number) {
		this.staff_number = staff_number;
	}
	public Integer getPlantingDuration() {
		return plantingDuration;
	}
	public void setPlantingDuration(Integer plantingDuration) {
		this.plantingDuration = plantingDuration;
	}
	public Double getCovering() {
		return covering;
	}
	public void setCovering(Double covering) {
		this.covering = covering;
	}
	public Integer getImgs() {
		return imgs;
	}
	public void setImgs(Integer imgs) {
		this.imgs = imgs;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getDevice() {
		return device;
	}
	public void setDevice(Integer device) {
		this.device = device;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	
	
}
