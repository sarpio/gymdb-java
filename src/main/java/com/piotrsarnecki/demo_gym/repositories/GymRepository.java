package com.piotrsarnecki.demo_gym.repositories;

import com.piotrsarnecki.demo_gym.entities.GymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<GymEntity, Long> {
}
