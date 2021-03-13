package com.benayed.mailing.servers.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ServerDto {

	private Long id;
	private String name;
	private String provider;
	private List<MTADto> mtas; 
}
