package com.benayed.mailing.servers.utils;

import org.springframework.stereotype.Component;

import com.benayed.mailing.servers.dto.MTADto;
import com.benayed.mailing.servers.dto.ServerDto;
import com.benayed.mailing.servers.entity.MTAEntity;
import com.benayed.mailing.servers.entity.ServerEntity;

@Component
public class DataMapper {

	public ServerDto toDto(ServerEntity entity) {
		return ServerDto.builder()
		.id(entity.getId())
		.name(entity.getName())
		.provider(entity.getProvider()).build();
	}
	
	public MTADto toDto (MTAEntity entity) {
		return MTADto.builder()
		.id(entity.getId())
		.name(entity.getName())    
		.dns(entity.getDns())     
		.ip(entity.getIp())      
		.port(entity.getPort())      
		.username(entity.getUsername())
		.password(entity.getPassword()).build();
	}
}
