package com.piotrsarnecki.demo_gym.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cardtype")
@AllArgsConstructor
@NoArgsConstructor
public class CardTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "cardTypeEntity")
    private Set<CardEntity> cardEntitySet;

    @ManyToMany(mappedBy = "cardTypeEntities")
    private Set<GymEntity> gymEntities;
}
