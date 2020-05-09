package com.ms.valid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.valid.domain.entity.ClientEntity;
import com.ms.valid.port.ClientRepositoryPort;
import com.ms.valid.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	private ClientRepositoryPort port;
	

	@Autowired
	public ClientServiceImpl(ClientRepositoryPort port) {
		this.port = port;
	}

	@Override
	public List<ClientEntity> FindClients() {
		return port.findAll();
	}

	@Override
	public ClientEntity findByIdClient(Long id) {
		return port.findById(id).get();
	}

	@Override
	public ClientEntity saveClient(ClientEntity clientEntity) {
		return port.save(clientEntity);
	}

}
