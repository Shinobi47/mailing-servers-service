package com.benayed.mailing.servers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "MAILING_MTA")
public class MTAEntity {
	
	@Id
	@Column(name = "MTA_ID")
	private Long id;

	@Column(name = "MTA_NAME")
	private String name;
	
	@Column(name = "MTA_DNS")
	private String dns;
	
	@Column(name = "MTA_IP")
	private String ip;
	
	@Column(name = "MTA_PORT")
	private String port;	
	
	@Column(name = "MTA_USERNAME")
	private String username;
	
	@Column(name = "MTA_PASSWORD")
	private String password;
	
	@ManyToOne
    @JoinColumn(name="MTA_SERVER_ID")
	private ServerEntity server;

}
