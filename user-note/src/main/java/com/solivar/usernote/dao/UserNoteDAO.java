package com.solivar.usernote.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.solivar.usernote.data.entity.NoteEntity;
import com.solivar.usernote.data.entity.UserEntity;
import com.solivar.usernote.data.repository.NoteRepository;
import com.solivar.usernote.data.repository.UserRepository;

@Component
public class UserNoteDAO {
	
	private final UserRepository userRepository;
	
	private final NoteRepository noteRepository;
	
	public UserNoteDAO(UserRepository userRepository, NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
	}
	
	public UserEntity saveuser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	
	public UserEntity getUser(Long userSeqId) {
		return userRepository.findByUserSeqID(userSeqId);
	}
	
	public NoteEntity saveNotes(NoteEntity noteEntity) {
		return noteRepository.save(noteEntity);
	}

	public UserEntity getUserByEmail(String emailAddress) {
		return userRepository.findByUserEmailAddress(emailAddress);
	}
	
	public List<NoteEntity> getNotes(Long userSeqId) {
		return noteRepository.findByUserEntityUserSeqID(userSeqId);
	}
	
	public NoteEntity findByNoteId(Long noteSeqId) {
		return noteRepository.findByNoteSeqId(noteSeqId);
	}
}
