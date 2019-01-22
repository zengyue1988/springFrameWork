package com.moon.accessDate.JPA.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M_ORDER", schema="moonschema")
public class M_Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer type;
	@Column(name="ORDER_NO", nullable=false, unique=true, length=32, insertable=true, updatable=false)
	private String orderNo;
	@OneToOne
	@JoinColumn(name="CUSTOMER_ID", referencedColumnName="id")
	private M_Customer customer;
	@Column(name="REMARK", nullable=true, length=255)
	private String remark;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<M_Product> productList = new HashSet<M_Product>();
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ORDER_ID", referencedColumnName="id")
	private Set<M_Address> addressList = new HashSet<M_Address>();
	@JsonIgnoreProperties(value= {"order"})
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ORDER_ID")
	private Set<M_Coupon> couponList = new HashSet<M_Coupon>();
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FINAL_ORDER_ID", referencedColumnName="id")
	private M_FinalOrder finalOrder;
	@JsonIgnoreProperties(value= {"orderList"})
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="M_ORDER_AGENT_LIST", joinColumns= {@JoinColumn(name="ORDER_ID", referencedColumnName="id")},inverseJoinColumns= {@JoinColumn(name="AGENT_ID", referencedColumnName="id")})
	private Set<M_Agent> agentList = new HashSet<M_Agent>();
	private Date orderDate;
	private Integer orderStatus;
	private Integer orderType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public M_Customer getCustomer() {
		return customer;
	}
	public void setCustomer(M_Customer customer) {
		this.customer = customer;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<M_Product> getProductList() {
		return productList;
	}
	public void setProductList(Set<M_Product> productList) {
		this.productList = productList;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Set<M_Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Set<M_Address> addressList) {
		this.addressList = addressList;
	}
	public Set<M_Coupon> getCouponList() {
		return couponList;
	}
	public void setCouponList(Set<M_Coupon> couponList) {
		this.couponList = couponList;
	}
	public M_FinalOrder getFinalOrder() {
		return finalOrder;
	}
	public void setFinalOrder(M_FinalOrder finalOrder) {
		this.finalOrder = finalOrder;
	}
	public Set<M_Agent> getAgentList() {
		return agentList;
	}
	public void setAgentList(Set<M_Agent> agentList) {
		this.agentList = agentList;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

}
