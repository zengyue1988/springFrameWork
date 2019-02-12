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
@Table(name="M_ROLE", schema="moonschema")
public class M_Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="ROLE_NAME", nullable=false, length=16)
	private String roleCode;
	@Column(name="ROLE_DESCRIPTION", nullable=false, length=96)
	private String roleDescription;
	@JsonIgnoreProperties(value= {"roleList"})
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="roleList", fetch=FetchType.EAGER)
	private Set<M_User> userList = new HashSet<M_User>();
	@JsonIgnoreProperties(value= {"roleList"})
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="M_ROLE_PERMISSION_LIST", 
	joinColumns= {@JoinColumn(name="ROLE_ID", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="PERMISSION_ID", referencedColumnName="id")})
	private Set<M_Permission> permissionList = new HashSet<M_Permission>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public Set<M_User> getUserList() {
		return userList;
	}
	public void setUserList(Set<M_User> userList) {
		this.userList = userList;
	}
	public Set<M_Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(Set<M_Permission> permissionList) {
		this.permissionList = permissionList;
	}
}
