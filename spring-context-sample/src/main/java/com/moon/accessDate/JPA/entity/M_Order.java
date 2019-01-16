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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Date orderDate;
	private Integer orderStatus;
	
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

}
