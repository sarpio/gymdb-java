package com.piotrsarnecki.demo_gym.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class CardTypeDTO {
    private Long id;
    @Schema(description = "card type name", required = true)
    @NotNull
    @NotBlank
    private String name;
    @Schema(description = "card price", required = true)
    @NotNull
    @Min(0)
    private Double price;
    @Schema(description = "gyms where this card type is valid")
    private Set<GymDTO> gyms;
}
