package com.app.entity;

import java.io.Serializable;
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
 * 管理员表
 * @author Administrator
 *
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="job_number")
	private String jobNumber;
	/**
	 * 登陆账号信息
	 * 使用手机号码和密码登陆
	 */
	private String phone;
	private String pwd;
	/**
	 * 姓名
	 */
	private String name;
	private Integer role;
	@ManyToMany(targetEntity=Store.class,fetch=FetchType.LAZY)
	@JoinTable(joinColumns={@JoinColumn(name="emplpoyee_id")},
				inverseJoinColumns={@JoinColumn(name="store_id")},
				name="store_sale")
	private Set<Store> store ;
	
	@ManyToMany(targetEntity=Area.class,fetch=FetchType.LAZY)
	@JoinTable(joinColumns={@JoinColumn(name="emplpoyee_id")},
				inverseJoinColumns={@JoinColumn(name="area_id")},
				name="area_sale")
	private Set<Area> area ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Set<Store> getStore() {
		return store;
	}
	public void setStore(Set<Store> store) {
		this.store = store;
	}
	public Set<Area> getArea() {
		return area;
	}
	public void setArea(Set<Area> area) {
		this.area = area;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
