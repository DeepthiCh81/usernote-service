package com.solivar.usernote.data.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long userSeqId;
	private String userName;
	private String userEmailAddress;
	private String password;
	private Date createdOn;
	private Date updatedOn;

}
