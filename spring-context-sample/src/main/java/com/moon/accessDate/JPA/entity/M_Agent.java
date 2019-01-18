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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M_AGENT", schema="moonschema")
public class M_Agent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="AGENT_NAME", nullable=false, length=32)
	private String agentName;
	@JsonIgnoreProperties(value= {"agentList"})
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="agentList")
	private Set<M_Order> orderList = new HashSet<M_Order>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<M_Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Set<M_Order> orderList) {
		this.orderList = orderList;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
}
