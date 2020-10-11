package com.benayed.mailing.servers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benayed.mailing.servers.entity.MTAEntity;

@Repository
public interface MTARepository extends JpaRepository<MTAEntity, Long>{
	
	public List<MTAEntity> findByIdIn(List<Long> mtaIds);

}
