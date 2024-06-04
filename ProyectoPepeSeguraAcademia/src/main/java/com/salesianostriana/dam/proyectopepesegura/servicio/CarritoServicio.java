package com.salesianostriana.dam.proyectopepesegura.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.modelo.Carrito;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVenta;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CarritoRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;

@Service
public class CarritoServicio {
	@Autowired
    private CarritoRepositorio carritoRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public Carrito obtenerCarrito(Estudiante estudiante) {
        return carritoRepositorio.findByEstudiante(estudiante);
    }

    public void agregarCurso(Estudiante estudiante, Long cursoId) {
        Carrito carrito = carritoRepositorio.findByEstudiante(estudiante);
        if (carrito == null) {
            carrito = new Carrito();
            carrito.setEstudiante(estudiante);
        }

        Curso curso = cursoRepositorio.findById(cursoId).orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        LineaVenta lv = new LineaVenta();
        lv.setCurso(curso);
        lv.setCarrito(carrito);

        carrito.getLv().add(lv);  // Asegúrate de que el getter y setter para la lista de LineaVenta se llamen correctamente
        carritoRepositorio.save(carrito);
    }

    public void eliminarCurso(Estudiante estudiante, Long idCurso) {
        Carrito carrito = carritoRepositorio.findByEstudiante(estudiante);
        if (carrito != null) {
            carrito.getLv().removeIf(lv -> lv.getCurso().getIdCurso() == idCurso);
            carritoRepositorio.save(carrito);
        }
    }
}

