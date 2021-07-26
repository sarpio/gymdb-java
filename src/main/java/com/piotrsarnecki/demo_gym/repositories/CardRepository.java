package com.piotrsarnecki.demo_gym.repositories;

import com.piotrsarnecki.demo_gym.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
