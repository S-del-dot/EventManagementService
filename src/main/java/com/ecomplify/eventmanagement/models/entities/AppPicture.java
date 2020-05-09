package com.ecomplify.eventmanagement.models.entities;


import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "app_picture")
//@Where(clause="DELETED='N'")
public class AppPicture {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_picture_id")
	private Long apppictureid;
	@Column(name = "app_event_id")
	private Long appeventid;

	public Long getAppeventid() {
		return appeventid;
	}

	public void setAppeventid(Long appeventid) {
		this.appeventid = appeventid;
	}

	@Column(name = "picture_size")
	private Long picturesize;
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
	@Column(name = "image_url")
	private String image_url;

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	@Column(name = "image_name")
	private String imagename;

	public void setApppictureid(Long apppictureid) {
		this.apppictureid = apppictureid;
	}

	public void setPicturesize(Long picturesize) {
		this.picturesize = picturesize;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	public void setModifiedon(LocalDateTime modifiedon) {
		this.modifiedon = modifiedon;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Long getApppictureid() {
		return apppictureid;
	}

	public Long getPicturesize() {
		return picturesize;
	}

	public String getCreatedby() {
		return createdby;
	}

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public String getModifyby() {
		return modifyby;
	}

	public LocalDateTime getModifiedon() {
		return modifiedon;
	}

	public String getDeleted() {
		return deleted;
	}

	public String getImage_url() {
		return image_url;
	}

}

