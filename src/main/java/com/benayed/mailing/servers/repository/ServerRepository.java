package com.benayed.mailing.servers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benayed.mailing.servers.entity.ServerEntity;

@Repository
public interface ServerRepository extends JpaRepository<ServerEntity, Long>{
	
	public List<ServerEntity> findAll();

}
