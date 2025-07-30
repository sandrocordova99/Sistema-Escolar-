package com.cibertec.repaso.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Nombre" , nullable = false)
    private String Nombre;

    @Column(name="Paterno" , nullable = false , length = 50)
    private String Paterno;

    @Column(name="Materno" , nullable = false , length = 50)
    private String Materno;

    @Column(name="Nacimiento" , nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(value = TemporalType.DATE)
    private Date Nacimiento;

    //Muchos alumnos pueden pertenecer a un solo grado

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Grado")
    //Unique
    private Grado grado;

    //Muchos alumnos pueden tener a muchos cursos
    @ManyToMany(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    @JoinTable(
            name = "Inscripcion_Alumnos",
            joinColumns = @JoinColumn(name = "alumno"),
            inverseJoinColumns = @JoinColumn(name ="cursos")
    )
    private List<Cursos> cursos;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "salon")
    private Salones salon;




}
