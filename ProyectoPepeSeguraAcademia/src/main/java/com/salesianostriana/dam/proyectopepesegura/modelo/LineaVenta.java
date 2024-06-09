package com.salesianostriana.dam.proyectopepesegura.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVentaPk;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(LineaVentaPk.class)
public class LineaVenta {

	@EmbeddedId
	 @Builder.Default
	 private LineaVentaPk linea = new LineaDeVentaPk();
  //  private Long idLv;
    
    @Id
    @ManyToOne
    @MapsId("LineaVentaPk")
    @JoinColumn(name = "idVenta")
    private Long idVenta;
    
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Long idCurso;

  
    
    /*Metodos helper paraa añadir un curso 
   public void addCurso(Curso c) {
    	this.curso.;
    	c.addLineaVenta(this);
    }
   public void removeCurso(Curso c) {
	   this.curso.setIdCurso(c.getIdCurso());
	   c.setLv(null);
   }
*/
  
}
