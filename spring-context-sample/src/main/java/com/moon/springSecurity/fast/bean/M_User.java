package com.moon.springSecurity.fast.bean;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M_USER", schema="moonschema")
public class M_User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="USERNAME", nullable=false, length=16)
	private String username;
	@Column(name="PASSWORD", nullable=false, length=96)
	private String password;
	@JsonIgnoreProperties(value= {"userList"})
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="M_USER_ROLE_LIST", 
	joinColumns= {@JoinColumn(name="USER_ID", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="ROLE_ID", referencedColumnName="id")})
	private Set<M_Role> roleList = new HashSet<M_Role>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<M_Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(Set<M_Role> roleList) {
		this.roleList = roleList;
	}
}
