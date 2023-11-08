package com.muestra.crud.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Students {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    @Column(length = 25, nullable = false)
    private String name;
    @Column(length = 25,nullable = false)
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "id_Campus", nullable = false)
    private Campus campus;
    @ManyToOne
    @JoinColumn(name = "id_Career", nullable = false)
    private Career career;
}
