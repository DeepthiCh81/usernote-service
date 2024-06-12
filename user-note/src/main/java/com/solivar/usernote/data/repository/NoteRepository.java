package com.solivar.usernote.data.repository;

import org.springframework.stereotype.Repository;

import com.solivar.usernote.data.entity.NoteEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
	
	
	
	List<NoteEntity> findByUserEntityUserSeqID(Long userSeqId);
	
	NoteEntity findByNoteSeqId(Long noteSeqId);

}
