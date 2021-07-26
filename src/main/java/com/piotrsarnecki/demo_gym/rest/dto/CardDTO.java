package com.piotrsarnecki.demo_gym.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Description;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
public class CardDTO {
    private Long id;

    private Date validFrom;

    private Date validTo;
    @NotNull
    @Schema(description = "required card type id", required = true)
    private CardTypeDTO cardType;
    @Schema(description = "card owner client id", required = true)
    @NotNull
    private Long clientId;
}
