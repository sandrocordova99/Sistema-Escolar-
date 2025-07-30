package com.cibertec.repaso.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Descripcion" , nullable = false , length = 50)
    private String descripcion;

    @ManyToMany(mappedBy = "cursos")
    private List<Alumno> alumnos;

    @OneToMany(mappedBy = "cursos")
    private List<Profesor> profesores;

    @ManyToMany(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    @JoinTable(
            name = "Cursos_Horarios",
            joinColumns = @JoinColumn(name = "cursos"),
            inverseJoinColumns = @JoinColumn(name = "horarios")
    )
    private List<Horario> horarios;

}
