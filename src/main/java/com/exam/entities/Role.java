package com.exam.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
import javax.persistence.Table;

//import org.hibernate.annotations.Entity;

//@Entity
@Entity
@Table(name="roles")
public class Role {
	@Id
	private Long roleId;
	private String roleName;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "role")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
