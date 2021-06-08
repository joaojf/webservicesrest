package com.crud.webservicesrest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.webservicesrest.entities.Client;
import com.crud.webservicesrest.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
//	Parei na parte de instanciar o obj aula 01-09 e 01-21 dados de auditoria
	
	@Autowired
	private ClientService serviceClient;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = serviceClient.findAll();
		return ResponseEntity.ok().body(list);
	}

}
