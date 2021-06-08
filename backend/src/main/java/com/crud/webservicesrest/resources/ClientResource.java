package com.crud.webservicesrest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.webservicesrest.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
//	Parei na parte de instanciar o obj aula 01-09 e 01-21 dados de auditoria
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "João Silva", "123456789110", 1000.00, null, 1));
		list.add(new Client(2L, "Maria Silva", "123456789102", 1100.00, null, 2));
		return ResponseEntity.ok().body(list);
	}

}
