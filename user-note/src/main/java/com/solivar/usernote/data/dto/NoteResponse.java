package com.solivar.usernote.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponse {
	
	public Object data;
	public String message;
	public String errorMessage;
	

}
