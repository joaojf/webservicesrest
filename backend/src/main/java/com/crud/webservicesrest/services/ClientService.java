package com.crud.webservicesrest.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.webservicesrest.dto.ClientDTO;
import com.crud.webservicesrest.entities.Client;
import com.crud.webservicesrest.repositories.ClientRepository;
import com.crud.webservicesrest.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repositoryClient;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repositoryClient.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repositoryClient.findById(id);
		Client client = obj.orElseThrow(() -> new EntityNotFoundException("Client not found"));
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDTO) {
		Client client = new Client();
		client.setName(clientDTO.getName());
		client.setBirhtDate(clientDTO.getBirhtDate());
		client.setCpf(clientDTO.getCpf());
		client.setIncome(clientDTO.getIncome());
		client.setChildren(clientDTO.getChildren());
		client = repositoryClient.save(client);
		return new ClientDTO(client);
	}

}
