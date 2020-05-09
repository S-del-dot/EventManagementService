package com.ecomplify.eventmanagement.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "app_event")
//@Where(clause="DELETED='N'")
public class AppEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_event_id")
	private Long appeventid;
	@Column(name = "app_user_id")
	private Long appuserid;
	@Column(name = "event_name")
	private String eventname;
	@Column(name = "event_description")
	private String eventdescription;
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

    public Long getAppeventid() {
		return appeventid;
	}

	public void setAppeventid(Long appeventid) {
		this.appeventid = appeventid;
	}

	public Long getAppuserid() {
		return appuserid;
	}

	public void setAppuserid(Long appuserid) {
		this.appuserid = appuserid;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventdescription() {
		return eventdescription;
	}

	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
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

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}



}
	