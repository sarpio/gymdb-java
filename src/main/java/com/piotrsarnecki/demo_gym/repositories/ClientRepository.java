package com.piotrsarnecki.demo_gym.repositories;

import com.piotrsarnecki.demo_gym.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
