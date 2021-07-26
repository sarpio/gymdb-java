package com.piotrsarnecki.demo_gym.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Set;
import java.util.Timer;

@Entity
@Table(name = "gym")
@Getter
@Setter
@RequiredArgsConstructor
public class GymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Transient
    private Time openFrom;

    @Transient
    private Time openTo;

    @ManyToMany
    @JoinTable(
            name = "gymcardtype",
            joinColumns = @JoinColumn(name = "gym_id"),
            inverseJoinColumns = @JoinColumn(name = "card_type_id"))
    private Set<CardTypeEntity> cardTypeEntities;

    @OneToMany(mappedBy = "gymEntity")
    private Set<EmployeeEntity> employeeEntities;
}
