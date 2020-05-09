package com.ecomplify.eventmanagement.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "app_user_identifier")
//@Where(clause="DELETED='N'")
public class UserIdentifier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_user_identifier_id")
	private Long userIdentifierId;
	@Column(name = "user_identifier_text")
	private String userIdentifierText;
	@Column(name = "app_user_id")
	private Long userId;
	@Column(name = "user_identifier_valid_date_from")
	private LocalDateTime identifierValidatedfromDate;
	@Column(name = "user_identifier_valid_date_to")
	private LocalDateTime identifierValidatedtoDate;	
	@Column(name = "deleted")
	private String deleted;
	
	public Long getUserIdentifierId() {
		return userIdentifierId;
	}
	public void setUserIdentifierId(Long userIdentifierId) {
		this.userIdentifierId = userIdentifierId;
	}
	public String getUserIdentifierText() {
		return userIdentifierText;
	}
	public void setUserIdentifierText(String userIdentifierText) {
		this.userIdentifierText = userIdentifierText;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public LocalDateTime getIdentifierValidatedtoDate() {
		return identifierValidatedtoDate;
	}
	public void setIdentifierValidatedtoDate(LocalDateTime identifierValidatedtoDate) {
		this.identifierValidatedtoDate = identifierValidatedtoDate;
	}

	

}
