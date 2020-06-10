package com.benayed.mailing.servers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benayed.mailing.servers.service.ServerService;
import com.benayed.mailling.servers.dto.ServerDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class ServersController {
	
	private ServerService serverService;
	
	public ServersController(ServerService serverService) {
		this.serverService = serverService;
	}
	
	@Operation(summary = "health check opertation")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "404", description = "Book not found", 
			    content = @Content) })
	@GetMapping(path = "/hello")
	public String hello() {
		return "Hello world";
	}
	
	@Operation(summary = "Get all servers available")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found the book", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = ServerDto.class)) }),
			  @ApiResponse(responseCode = "404", description = "Book not found", 
			    content = @Content) })
	@GetMapping(path = "/servers")
	public ResponseEntity<List<ServerDto>> fetchServers(){
		
		return new ResponseEntity<>(serverService.getAllServers(), serverService.getAllServers().isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

}
