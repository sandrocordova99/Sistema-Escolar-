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
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="Descripcion" , nullable = false , length = 50)
    private String descripcion;

    @ManyToMany(mappedBy = "grados")
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "grado")
    private List<Alumno> alumno;

}
