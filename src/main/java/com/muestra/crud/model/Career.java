package com.muestra.crud.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Career {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCareer;
    @Column(length = 25, nullable = false)
    private String nameCareer;
    @Column(nullable = false)
    private boolean enabled;
}
