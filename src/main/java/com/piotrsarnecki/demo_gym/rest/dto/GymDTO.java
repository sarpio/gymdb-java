package com.piotrsarnecki.demo_gym.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Set;

@Getter
@Setter
public class GymDTO {

    private Long id;

    @Schema(description = "gym name")
    @NotNull
    @NotBlank
    private String name;
    private String city;

    @Schema(description = "required time format HH:MM", required = true)
    private Time openFrom;

    @Schema(description = "required time format HH:MM", required = true)
    private Time openTo;
    private Set<CardTypeDTO> cardTypes;
}
