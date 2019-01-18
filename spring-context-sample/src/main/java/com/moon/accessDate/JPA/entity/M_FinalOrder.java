package com.moon.accessDate.JPA.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M_FINAL_ORDER", schema="moonschema")
public class M_FinalOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="ORDER_NAME", nullable=false, length=32)
	private String orderName;
	@JsonIgnoreProperties(value= {"finalOrder"})
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="finalOrder")
	private Set<M_Order> orderList = new HashSet<M_Order>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Set<M_Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Set<M_Order> orderList) {
		this.orderList = orderList;
	}
}
