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
 * 发票信息
 * @author Administrator
 *
 */
@Entity
@Table(name="invoices")
public class Invoices implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private Integer type;
	private String content;
	@Column(name="store_id")
	private Integer storeId;
	@Column(name="express_fee")
	private Double expressFee;
	@Column(name="apply_date")
	private Date applyDate;
	private Integer status;
	@Column(name="order_id")
	private Integer orderId;
	@Column(name="dealer_id")
	private Integer dealerId;
	private String taxpayer;
	private String bank;
	@Column(name="bank_account")
	private String bankAccount;
	@Column(name="business_license")
	private String businessLicense;
	@Column(name="tax_registration_certificate")
	private String taxRegistrationCertificate;
	private String organization;
	@Column(name="permit_to_establish_an_account")
	private String permitToEstablishAnAccount;
	private String text1;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Double getExpressFee() {
		return expressFee;
	}
	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public String getTaxpayer() {
		return taxpayer;
	}
	public void setTaxpayer(String taxpayer) {
		this.taxpayer = taxpayer;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getTaxRegistrationCertificate() {
		return taxRegistrationCertificate;
	}
	public void setTaxRegistrationCertificate(String taxRegistrationCertificate) {
		this.taxRegistrationCertificate = taxRegistrationCertificate;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPermitToEstablishAnAccount() {
		return permitToEstablishAnAccount;
	}
	public void setPermitToEstablishAnAccount(String permitToEstablishAnAccount) {
		this.permitToEstablishAnAccount = permitToEstablishAnAccount;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	
	
}
