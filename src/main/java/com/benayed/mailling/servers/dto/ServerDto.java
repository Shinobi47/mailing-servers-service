package com.benayed.mailling.servers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ServerDto {

	private Long id;
	private String name;
	private String provider;
}
