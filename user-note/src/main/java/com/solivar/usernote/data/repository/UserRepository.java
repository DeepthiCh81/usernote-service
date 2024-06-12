package com.solivar.usernote.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solivar.usernote.data.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByUserSeqID(Long userSeqId);
	
	UserEntity findByUserEmailAddress(String emailAddress);
	
	

}
