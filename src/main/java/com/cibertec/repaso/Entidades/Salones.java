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
public class Salones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="descripcion" , nullable = false , length = 50)
    private String descripcion;

    @OneToMany(mappedBy = "salon")
    private List<Alumno> alumnos;
}
