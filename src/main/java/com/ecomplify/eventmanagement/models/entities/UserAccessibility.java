package com.ecomplify.eventmanagement.models.entities;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "app_user_accessibility")
//@Where(clause="DELETED='N'")
public class UserAccessibility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_user_accessibility_id")
	private Long accessibilityid;
	@Column(name = "type_of_access")
	private String typeofaccess;
	@Column(name = "app_user_id")
	private Long appuserid;
	@Column(name = "created_by")
	private String createdby;
	@Column(name = "created_on")
	private LocalDateTime createdon;
	@Column(name = "last_modify_by")
	private String modifyby;
	@Column(name = "last_modify_on")
	private LocalDateTime modifiedon;
	@Column(name = "deleted")
	private String deleted;


	public Long getAccessibilityid() {
		return accessibilityid;
	}

	public void setAccessibilityid(Long accessibilityid) {
		this.accessibilityid = accessibilityid;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getTypeofaccess() {
		return typeofaccess;
	}

	public void setTypeofaccess(String typeofaccess) {
		this.typeofaccess = typeofaccess;
	}


	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	public String getModifyby() {
		return modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	public LocalDateTime getModifiedon() {
		return modifiedon;
	}

	public void setModifiedon(LocalDateTime modifiedon) {
		this.modifiedon = modifiedon;
	}

	public Long getAppuserid() {
		return appuserid;
	}

	public void setAppuserid(Long appuserid) {
		this.appuserid = appuserid;
	}
}
	