package com.piotrsarnecki.demo_gym.entities;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employee")
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private GymEntity gymEntity;

    public EmployeeEntity() {
    }
}
