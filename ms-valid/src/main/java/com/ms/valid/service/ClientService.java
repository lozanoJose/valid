package com.ms.valid.service;

import java.util.List;

import com.ms.valid.domain.entity.ClientEntity;

public interface ClientService {
	
	public List<ClientEntity> FindClients();

	public ClientEntity findByIdClient(Long id);

	public ClientEntity saveClient(ClientEntity clientEntity);
	
}
