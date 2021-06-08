package com.crud.webservicesrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.webservicesrest.entities.Client;
import com.crud.webservicesrest.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repositoryClient;
	
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return repositoryClient.findAll();
	}

}
