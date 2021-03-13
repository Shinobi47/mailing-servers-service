	package com.benayed.mailing.servers.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benayed.mailing.servers.dto.MTADto;
import com.benayed.mailing.servers.dto.ServerDto;
import com.benayed.mailing.servers.service.ServerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ServersController {
	
	private ServerService serverService;

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
			  @ApiResponse(responseCode = "200", description = "Found the servers", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = ServerDto.class)) }),
			  @ApiResponse(responseCode = "404", description = "servers not found", 
			    content = @Content) })
	@GetMapping(path = "/servers")
	public ResponseEntity<?> fetchServers(){
		
		List<ServerDto> allServers = serverService.getAllServers();
		return allServers.isEmpty() 
				? new ResponseEntity<List<ServerDto>>(allServers, HttpStatus.NOT_FOUND)
						: new ResponseEntity<List<ServerDto>>(allServers, HttpStatus.OK);
	}
	
	@Operation(summary = "Get mtas by ids (comma separated)")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found the mtas", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = MTADto.class)) }),
			  @ApiResponse(responseCode = "404", description = "mtas not found", 
			    content = @Content) })
	@GetMapping(path = "/mtas/{ids}")
	public ResponseEntity<?> getMtas(@PathVariable(value = "ids") String stringMtaIds) {
		List<Long> mtaIds = Arrays.asList(stringMtaIds.split(",")).stream().map(Long::parseLong).collect(Collectors.toList());

		boolean shouldMapCredentials = true;
		List<MTADto> mtas = serverService.getMTAsWithCredentials(mtaIds, shouldMapCredentials);
		return mtas.isEmpty() 
				? new ResponseEntity<List<MTADto>>(HttpStatus.NOT_FOUND) 
						: new ResponseEntity<List<MTADto>>(mtas, HttpStatus.OK);
	}
	
	@Operation(summary = "Get all servers available with their mtas")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found the servers with mtas", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = ServerDto.class)) }),
			  @ApiResponse(responseCode = "404", description = "servers not found", 
			    content = @Content) })
	@GetMapping(path = "/servers/mtas")
	public ResponseEntity<?> fetchServersWithMtas(){
		
		List<ServerDto> serversWithMtas = serverService.getServersWithMtas();
		return serversWithMtas.isEmpty() 
				? new ResponseEntity<List<ServerDto>>(serversWithMtas, HttpStatus.NOT_FOUND)
						: new ResponseEntity<List<ServerDto>>(serversWithMtas, HttpStatus.OK);
	}


}
