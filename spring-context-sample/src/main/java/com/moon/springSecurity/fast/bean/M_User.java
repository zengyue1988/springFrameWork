package com.moon.springSecurity.fast.bean;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M_USER", schema="moonschema")
public class M_User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Column(name = "ACCOUNTNON_EXPIRED")
	private int accoutNonExpired;
	@Column(name = "ACCOUNTNON_LOCKED")
	private int accountNonLocked;
	@Column(name = "CREDENTIALSNON_EXPIRED")
	private int credentialsNonExpired;
	@Column(name = "ENABLED")
	private int enabled;
	
	public M_User(String username, String password, int accoutNonExpired, int accountNonLocked,
			int credentialsNonExpired, int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.accoutNonExpired = accoutNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	public M_User() {
		super();
	}
	public M_User(Integer id, String username, String password, Set<M_Role> roleList, int accoutNonExpired,
			int accountNonLocked, int credentialsNonExpired, int enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleList = roleList;
		this.accoutNonExpired = accoutNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		StringBuilder roles = new StringBuilder();
		Iterator<M_Role> iroles = roleList.iterator();
		while(iroles.hasNext()) {
			roles.append(iroles.next().getRoleCode()).append(",");
		}
		if (roleList.size() > 0)
			return AuthorityUtils.commaSeparatedStringToAuthorityList(roles.substring(roles.length()-1));
		else
			return AuthorityUtils.NO_AUTHORITIES;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return accoutNonExpired==0;
	}
	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked==0;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired==0;
	}
	@Override
	public boolean isEnabled() {
		return enabled==0;
	}
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
	public int getAccoutNonExpired() {
		return accoutNonExpired;
	}
	public void setAccoutNonExpired(int accoutNonExpired) {
		this.accoutNonExpired = accoutNonExpired;
	}
	public int getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(int accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public int getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(int credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
