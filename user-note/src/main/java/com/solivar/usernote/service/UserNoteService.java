package com.solivar.usernote.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.solivar.usernote.dao.UserNoteDAO;
import com.solivar.usernote.data.dto.NoteDTO;
import com.solivar.usernote.data.dto.UserDTO;
import com.solivar.usernote.data.entity.NoteEntity;
import com.solivar.usernote.data.entity.UserEntity;

import jakarta.transaction.Transactional;

@Service
public class UserNoteService {
	
	private UserNoteDAO  userNoteDAO;
	private ModelMapper modelMapper;
	
	public UserNoteService(UserNoteDAO userNoteDAO, ModelMapper modelMapper) {
		this.userNoteDAO = userNoteDAO;
		this.modelMapper = modelMapper;
	}
	
	@Transactional
	public UserDTO saveUser(UserDTO userDTO) {
		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		userEntity.setCreatedOn(new Date());
		userEntity.setUpdatedOn(new Date());
		userEntity = userNoteDAO.saveuser(userEntity);
	    userDTO = modelMapper.map(userEntity, UserDTO.class);
		return userDTO;
		
	}
	
	public UserDTO getUser(Long userSeqId) {
		UserEntity userEntity = userNoteDAO.getUser(userSeqId);
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		return userDTO;
	}
	
	@Transactional
	public UserDTO updateUser(UserDTO userDTO, Long userSeqId) throws Exception {
		
		UserEntity userEntity = userNoteDAO.getUser(userSeqId);
		if(userEntity != null) {
			userEntity = modelMapper.map(userDTO, UserEntity.class);
			userEntity.setCreatedOn(new Date());
			userEntity.setUpdatedOn(new Date());
			userEntity = userNoteDAO.saveuser(userEntity);
			userDTO = modelMapper.map(userEntity, UserDTO.class);		
			return userDTO;
		}
		else {
			throw new Exception();
		}
		
	}
	
	@Transactional
	public NoteDTO saveUserNote(NoteDTO noteDTO) throws Exception {
		UserEntity userEntity = userNoteDAO.getUser(noteDTO.getUserSeqId());
		if(userEntity != null) {
			NoteEntity noteEntity = modelMapper.map(noteDTO, NoteEntity.class);
			noteEntity.setCreatedOn(new Date());
			noteEntity.setUpdatedOn(new Date());
			noteEntity.setNotedDate(new Date());
			noteEntity.setUserEntity(userEntity);
			noteEntity = userNoteDAO.saveNotes(noteEntity);
			noteDTO = modelMapper.map(noteEntity, NoteDTO.class);
			return noteDTO;
		} else {
			throw  new Exception();
		}
	}
	
	public List<NoteDTO> getUserNote(String emailAddres) throws Exception {
		UserEntity userEntity = userNoteDAO.getUserByEmail(emailAddres);
		if(userEntity != null) {
			List<NoteEntity> noteEntityList = userNoteDAO.getNotes(userEntity.getUserSeqID());
			List<NoteDTO> noteDtoList = noteEntityList.stream().map(e -> modelMapper.map(e, NoteDTO.class)).toList();
			return noteDtoList;
		} else {
			throw new Exception();
		}
	}
	
	@Transactional
	public NoteDTO updateUserNote(NoteDTO noteDTO, Long noteSeqId) throws Exception {
		UserEntity userEntity = userNoteDAO.getUser(noteDTO.getUserSeqId());
		if(userEntity != null) {
			NoteEntity noteEntity = userNoteDAO.findByNoteId(noteSeqId);
			noteEntity = modelMapper.map(noteDTO, NoteEntity.class);
			noteEntity.setCreatedOn(new Date());
			noteEntity.setUpdatedOn(new Date());
			noteEntity.setNotedDate(new Date());
			userNoteDAO.saveNotes(noteEntity);
			noteDTO = modelMapper.map(noteEntity, NoteDTO.class);
			return noteDTO;
		} else {
			throw  new Exception();
		}
	}
	
	
}