package com.solivar.usernote.data.dto;

import java.util.Date;

import com.solivar.usernote.data.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
	
	private Long noteSeqId;
	
	private String noteTitle;
	private String noteDescription;
	private Date notedDate;
	private Long userSeqId;
	private Date createdOn;
	private Date updatedOn;
	private UserEntity userEntity;
	
	

}
