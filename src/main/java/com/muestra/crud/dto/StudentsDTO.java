package com.muestra.crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentsDTO {

    private Integer idStudent;

    @NotNull @NotEmpty @Size(min = 5, max = 25)
    private String name;
    @NotNull @NotEmpty @Size(min = 5, max = 25)
    private String lastName;
    @NotNull @Min(value = 1)
    private Integer idCampus;
    @NotNull @Min(value = 1)
    private Integer idCareer;

}
