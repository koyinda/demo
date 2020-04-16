package com.adniyo.CentricGateway.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userindex;

	@Column(name = "fullName", nullable = false)
	private String fullName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "createdate", nullable = false)
	private Date createdate;

	@Column(name = "createdBy", nullable = false)
	private String createdBy;

	/**
	 * @return the userindex
	 */

	public long getUserindex() {
		return userindex;
	}

	/**
	 * @param userindex the userindex to set
	 */
	public void setUserindex(long userindex) {
		this.userindex = userindex;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * @param createdate the createdate to set
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Customer [userindex=" + userindex + ", fullName=" + fullName + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", createdate=" + createdate + ", createdBy=" + createdBy + "]";
	}

}
