package com.salesianostriana.dam.proyectopepesegura.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(LineaVentaPk.class)
public class LineaVenta {

    @Id
    private Long idLv;
    
    @Id
    @ManyToOne
    private Venta carrito;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private int cantidad ;
    
    
    //Metodos helper paraa añadir un curso 
   public void addCurso(Curso c) {
    	this.curso.setIdCurso(c.getIdCurso());
    	c.addLineaVenta(this);
    }
   public void removeCurso(Curso c) {
	   this.curso.setIdCurso(c.getIdCurso());
	   c.setLv(null);
   }
}
