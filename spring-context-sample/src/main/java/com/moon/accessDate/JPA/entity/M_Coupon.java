package com.moon.accessDate.JPA.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="M_COUPON", schema="moonschema")
public class M_Coupon {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="DISCOUNT_AMOUNT")
	private BigDecimal discountAmount;
	@Column(name="EXPIRE_DATE")
	private Date expireDate;
	@Column(name="COUPON_TYPE", length=16)
	private Integer couponType;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private M_Order order;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public M_Order getOrder() {
		return order;
	}
	public void setOrder(M_Order order) {
		this.order = order;
	}
}
