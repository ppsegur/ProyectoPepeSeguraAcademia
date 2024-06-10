package com.salesianostriana.dam.proyectopepesegura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;



public interface VentaRepositorio  extends JpaRepository<Venta, Long> {
	 
	/*@Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END " +
	           "FROM Venta v LEFT JOIN v.lineaVenta lv " +
	           "WHERE v.estudiante = :estudiante AND lv.curso = :curso AND v.finalizada = false")
	    boolean hayCursoEnCarrito(Estudiante estudiante,Curso curso);
*/
	    Venta findByEstudianteAndFinalizada(Estudiante estudiante, boolean finalizada);

}
