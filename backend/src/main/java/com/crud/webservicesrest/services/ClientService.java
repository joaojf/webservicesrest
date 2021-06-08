package com.crud.webservicesrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.webservicesrest.dto.ClientDTO;
import com.crud.webservicesrest.entities.Client;
import com.crud.webservicesrest.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repositoryClient;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repositoryClient.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

}
