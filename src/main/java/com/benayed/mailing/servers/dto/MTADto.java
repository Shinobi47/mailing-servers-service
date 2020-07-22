package com.benayed.mailing.servers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MTADto {

	private Long id;
	private String name;
	private String ip;
	private ServerDto server;
}
