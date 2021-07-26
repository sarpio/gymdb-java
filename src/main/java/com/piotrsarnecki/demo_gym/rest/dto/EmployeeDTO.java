package com.piotrsarnecki.demo_gym.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    @Schema(description = "first and last name of employee", required = true)
    @NotNull
    @NotBlank
    private String name;
    @Schema(description = "employee type, trainer etc.", required = true)
    @NotNull
    @NotBlank
    private String type;
    @Schema(description = "gym where employee is working")
    private GymDTO gym;
}
