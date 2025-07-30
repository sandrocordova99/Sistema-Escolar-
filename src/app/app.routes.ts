import { Routes } from '@angular/router';
import { ListarAlumnosComponent } from './componentes/alumnos/listar-alumnos/listar-alumnos.component';
import { AgregarCursosAlumnoComponent } from './componentes/alumnos/agregar-cursos-alumno/agregar-cursos-alumno.component';
import { CrearAlumnoComponent } from './componentes/alumnos/crear-alumno/crear-alumno.component';
import { ActualizarAlumnoComponent } from './componentes/alumnos/actualizar-alumno/actualizar-alumno.component';
import { BuscarAlumnoIdComponent } from './componentes/alumnos/buscar-alumno-id/buscar-alumno-id.component';
import { BuscarCursosIdComponent } from './componentes/cursos/buscar-cursos-id/buscar-cursos-id.component';
import { ListarGradosComponent } from './componentes/grado/listar-grados/listar-grados.component';
import { ListarHorariosComponent } from './componentes/horario/listar-horarios/listar-horarios.component';
import { AgregarCursosHorarioComponent } from './componentes/horario/agregar-cursos-horario/agregar-cursos-horario.component';
import { ListaProfesoresComponent } from './componentes/profesor/lista-profesores/lista-profesores.component';
import { CrearProfesoresComponent } from './componentes/profesor/crear-profesores/crear-profesores.component';
import { BuscarProfesoresComponent } from './componentes/profesor/buscar-profesores/buscar-profesores.component';
import { ActualizarProfesoresComponent } from './componentes/profesor/actualizar-profesores/actualizar-profesores.component';
import { ListarSalonesComponent } from './componentes/salon/listar-salones/listar-salones.component';

export const routes: Routes = [
    //alumnos
    {path:'listarAlumnos',component:ListarAlumnosComponent},
    {path:'crearAlumnos',component:CrearAlumnoComponent},
    {path:'actualizarAlumnos',component:ActualizarAlumnoComponent},
    {path:'buscarAlumno',component:BuscarAlumnoIdComponent},
    {path:'agregarCursoAlumno',component:AgregarCursosAlumnoComponent},
   
    //cursos
    {path:'listarCursos',component:BuscarCursosIdComponent},
    {path:'buscarCursos',component:BuscarCursosIdComponent},
 
    //grados
    {path:'listarGrados',component:ListarGradosComponent},

    //horario
    {path:'listarHorario',component:ListarHorariosComponent},
    {path:'agregarCursoHorario',component:AgregarCursosHorarioComponent},

    //profesor
    {path:'listarProfesores',component:ListaProfesoresComponent},
    {path:'crearProfesores',component:CrearProfesoresComponent},
    {path:'buscarProfesores',component:BuscarProfesoresComponent},
    {path:'actualizarProfesores',component:ActualizarProfesoresComponent},

    //salon
    {path:'listarSalones',component:ListarSalonesComponent},


];
