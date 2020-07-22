package com.benayed.mailing.servers.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.benayed.mailing.servers.dto.ServerDto;
import com.benayed.mailing.servers.repository.ServerRepository;

@Service
public class ServerService {

	private ServerRepository serverRepository;
	
	public ServerService(ServerRepository serverRepository) {
		this.serverRepository = serverRepository;
	}
	
	public List<ServerDto> getAllServers(){
		return serverRepository.findAll().stream().map(serverEntity -> ServerDto.builder().id(serverEntity.getId()).name(serverEntity.getName()).provider(serverEntity.getProvider()).build()).collect(Collectors.toList());
	}
	
}
