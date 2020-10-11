package com.benayed.mailing.servers.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.benayed.mailing.servers.dto.MTADto;
import com.benayed.mailing.servers.dto.ServerDto;
import com.benayed.mailing.servers.repository.MTARepository;
import com.benayed.mailing.servers.repository.ServerRepository;
import com.benayed.mailing.servers.utils.DataMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServerService {

	private ServerRepository serverRepository;
	private MTARepository mtaRepository;
	private DataMapper dataMapper;
	
	public List<ServerDto> getAllServers(){
		return serverRepository.findAll().stream().map(dataMapper::toDto).collect(Collectors.toList());
	}
	
	public List<MTADto> getMTAs(List<Long> mtaIds) {
		return mtaRepository.findByIdIn(mtaIds).stream().map(dataMapper::toDto).collect(Collectors.toList());
	}
	
}
