package com.piotrsarnecki.demo_gym.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    @Schema(description = "client first and last name", required = true)
    @NotBlank
    @NotNull
    private String name;
    @Schema(description = "client cards")
    private Set<CardDTO> cards;
}
