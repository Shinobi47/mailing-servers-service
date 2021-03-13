package com.benayed.mailing.servers.utils;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public ServerDto toDto(ServerEntity entity, boolean shouldMapMtas) {
		ServerDto dto = this.toDto(entity);
		boolean shouldMapCredentials = false;
		
		if(shouldMapMtas) {
			List<MTADto> mtas = entity.getMtas() == null ? null :
				entity.getMtas().stream().map(mtaEnt -> toDto(mtaEnt, shouldMapCredentials)).collect(Collectors.toList());
			dto.setMtas(mtas);
		}
		
		return dto;
	}
	
	public MTADto toDto (MTAEntity entity, boolean shouldMapCredentials) {
		MTADto dto = MTADto.builder()
				.id(entity.getId())
				.name(entity.getName())    
				.dns(entity.getDns())     
				.ip(entity.getIp())      
				.port(entity.getPort()).build();
		
		if(shouldMapCredentials) {
			dto.setUsername(entity.getUsername());
			dto.setPassword(entity.getPassword());
		}
		
		return dto;
	}
	
}
