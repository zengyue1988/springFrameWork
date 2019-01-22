package com.moon.accessDate.JPA.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M_PRODUCT", schema="moonschema")
public class M_Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="PRODUCT_NAME", nullable=false, length=32)
	private String productName;
	@Column(name="PRODUCT_PRICE", nullable=false, length=16)
	private BigDecimal productPrice;
	@Column(name="PRODUCT_TYPE", nullable=false, length=16)
	private Integer productType;
	@JsonIgnoreProperties(value= {"product"})
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="DETAILS_ID", referencedColumnName="id", updatable = true)
	private M_ProductDetails productDetails;
	@Version
	private int version;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public M_ProductDetails getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(M_ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
