package com.muestra.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CareerDTO {
    private Integer idCareer;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 25)
    private String nameCareer;
    @NotNull
    private boolean enabled;
}
