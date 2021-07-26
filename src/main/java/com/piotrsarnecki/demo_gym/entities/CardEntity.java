package com.piotrsarnecki.demo_gym.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valid_from")
    private Date validFrom;

    @Column(name = "valid_to")
    private Date validTo;

    @ManyToOne
    @JoinColumn(name = "card_type_id")
    private CardTypeEntity cardTypeEntity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;
}
