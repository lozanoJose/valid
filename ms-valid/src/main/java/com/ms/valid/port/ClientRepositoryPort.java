package com.ms.valid.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.valid.domain.entity.ClientEntity;

@Repository
public interface ClientRepositoryPort extends JpaRepository<ClientEntity, Long>{

}
