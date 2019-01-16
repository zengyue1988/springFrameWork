package com.moon.accessDate.JPA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="M_PRODUCT_DETAILS", schema="moonschema")
public class M_ProductDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="PRODUCT_DESCRIPTION", nullable=false, length=255)
	private String productDescription;
	@OneToOne(mappedBy="productDetails", cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY)
	private M_Product product;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public M_Product getProduct() {
		return product;
	}
	public void setProduct(M_Product product) {
		this.product = product;
	}

}
