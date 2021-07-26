package com.piotrsarnecki.demo_gym.repositories;

import com.piotrsarnecki.demo_gym.entities.CardTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTypeRepository extends JpaRepository<CardTypeEntity, Long> {

}
