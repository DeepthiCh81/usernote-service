package com.solivar.usernote.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_DATA")
public class UserEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "USER_SEQ_ID")
	private Long userSeqID;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_EMAIL_ADDRESS")
	private String userEmailAddress;
	
	@Column(name = "PASSWORD")
	private String password;
	

}
