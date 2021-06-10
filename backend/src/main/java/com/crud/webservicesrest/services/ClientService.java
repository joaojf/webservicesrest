package com.crud.webservicesrest.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.webservicesrest.dto.ClientDTO;
import com.crud.webservicesrest.entities.Client;
import com.crud.webservicesrest.repositories.ClientRepository;
import com.crud.webservicesrest.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repositoryClient;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repositoryClient.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repositoryClient.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Client not found"));
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

	@Transactional
	public ClientDTO update(Long id, ClientDTO clientDTO) {
		try {
			Client client = repositoryClient.getOne(id);
			client.setName(clientDTO.getName());
			client.setBirhtDate(clientDTO.getBirhtDate());
			client.setCpf(clientDTO.getCpf());
			client.setIncome(clientDTO.getIncome());
			client.setChildren(clientDTO.getChildren());
			client = repositoryClient.save(client);
			return new ClientDTO(client);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repositoryClient.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

}
