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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M_PERMISSION", schema="moonschema")
public class M_Permission {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="PERMISSION_CODE", nullable=false, length=16)
	private String permissionCode;
	@Column(name="PERMISSION_DESCRIPTION", nullable=false, length=96)
	private String permissionDescription;
	@Column(name="PERMISSION_URL", nullable=false, length=96)
	private String permissionUrl;
	@JsonIgnoreProperties(value= {"permissionList"})
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="permissionList", fetch=FetchType.EAGER)
	private Set<M_Role> roleList = new HashSet<M_Role>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<M_Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(Set<M_Role> roleList) {
		this.roleList = roleList;
	}
	public String getPermissionCode() {
		return permissionCode;
	}
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
	public String getPermissionDescription() {
		return permissionDescription;
	}
	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}
	public String getPermissionUrl() {
		return permissionUrl;
	}
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
}
