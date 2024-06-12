package com.solivar.usernote.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solivar.usernote.data.dto.NoteDTO;
import com.solivar.usernote.data.dto.NoteResponse;
import com.solivar.usernote.data.dto.UserDTO;
import com.solivar.usernote.data.entity.NoteEntity;
import com.solivar.usernote.data.entity.UserEntity;
import com.solivar.usernote.service.UserNoteService;

@RestController
@RequestMapping("/api")
public class UserNoteController {
	
	private UserNoteService userNoteService;
	
	public UserNoteController(UserNoteService userNoteService) {
		this.userNoteService = userNoteService;
	}
	
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<NoteResponse> saveUser(@RequestBody UserDTO userDTO) {
		NoteResponse noteResponse = new NoteResponse();
		try {
			userDTO = userNoteService.saveUser(userDTO);
			noteResponse.setData(userDTO);
			noteResponse.setMessage("Saved Successfully");
		} catch (Exception e) {
			noteResponse.setErrorMessage("Unable to save the data");
		}
		
		return ResponseEntity.ok(noteResponse);
		
	}
	
	@GetMapping("/getUser,{userSeqId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable(name = "userSeqId") Long userSeqId) {
		UserDTO userDTO = userNoteService.getUser(userSeqId);
		return ResponseEntity.ok(userDTO);
		
	}

	@PutMapping("/updateUser,{userSeqId}")
	public ResponseEntity<NoteResponse> updateUser(@RequestBody UserDTO userDTO, @PathVariable(name = "userSeqId") Long userSeqId) throws Exception {
		NoteResponse noteResponse = new NoteResponse();
		try {
			userDTO = userNoteService.updateUser(userDTO, userSeqId);
			noteResponse.setData(userDTO);
			noteResponse.setMessage("Update Successfully");
		}
		catch (Exception e) {
			noteResponse.setErrorMessage("Unable to update data");
		}
		
		return ResponseEntity.ok(noteResponse);
	}
	
	@PostMapping("/saveUserNote") 
	public ResponseEntity<NoteResponse> saveUserNote(@RequestBody NoteDTO noteDTO) throws Exception {
		NoteResponse noteResponse = new NoteResponse();
		try {
			noteDTO = userNoteService.saveUserNote(noteDTO);
			noteResponse.setData(noteDTO);
			noteResponse.setMessage("Saved Successfully");
		} catch (Exception e) {
			noteResponse.setErrorMessage("Unable to save data");
		}
		return ResponseEntity.ok(noteResponse);
	}
	
	
	@PutMapping("/updateUserNote,{noteSeqId}") 
	public ResponseEntity<NoteResponse> updateUserNote(@RequestBody NoteDTO noteDTO, @PathVariable(name = "noteSeqId") Long noteSeqId) throws Exception {
		NoteResponse noteResponse = new NoteResponse();
		try {
			noteDTO = userNoteService.updateUserNote(noteDTO, noteSeqId);
			noteResponse.setData(noteDTO);
			noteResponse.setMessage("Update Successfully");
		} catch (Exception e) {
			noteResponse.setErrorMessage("Unable to update data");
		}
		
		return ResponseEntity.ok(noteResponse);
	}
	
	@GetMapping("/getUserNote/{emailAddress}") 
	public ResponseEntity<List<NoteDTO>> getUserNote(@PathVariable (name = "emailAddress") String emailAddress ) throws Exception {
		List<NoteDTO> noteDTO = userNoteService.getUserNote(emailAddress);
		return ResponseEntity.ok(noteDTO);
		
	
	}

}
