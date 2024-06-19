package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;



public interface VentaRepositorio  extends JpaRepository<Venta, Long> {
	 
	/*@Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END " +
	           "FROM Venta v LEFT JOIN v.lineaVenta lv " +
	           "WHERE v.estudiante = :estudiante AND lv.curso = :curso AND v.finalizada = false")
	    boolean hayCursoEnCarrito(Estudiante estudiante,Curso curso);

	    Venta findByEstudianteAndFinalizada(Estudiante estudiante, boolean finalizada);*/
	    Optional<Venta> findByEstudianteAndFinalizadaFalse(Estudiante estudiante);
	    boolean existsByEstudianteAndFinalizadaFalse(Estudiante estudiante);
	    List<Venta> findByEstudiante(Estudiante e);
	    
	    
	    //Consulta para ver el usuario con más ventas
	    @Query("SELECT v.estudiante FROM Venta v GROUP BY v.estudiante ORDER BY SUM(v.importeTotal) DESC")
	    Estudiante findEstudianteConMasVentas();
	    //Consulta para ver el total de ventas
	    @Query("SELECT SUM(v.importeTotal) FROM Venta v")
	    double findTotalVentas();
}
