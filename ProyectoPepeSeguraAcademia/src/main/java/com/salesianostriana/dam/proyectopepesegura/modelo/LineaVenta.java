package com.salesianostriana.dam.proyectopepesegura.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(LineaVentaPk.class)
public class LineaVenta {

	@Id
	@GeneratedValue
	private Long id;

  //  private Long idLv;
    
	   /*@Id
	    private Long idVenta;

	    @Id
	    private Long Idcurso;*/

  
    @Id
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;
    
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

	
    public double getPrecioLineaVenta() {
        return curso.getPrecio();
    }
    
   //Metodos helper paraa añadir un curso 
   public void addCurso(Curso c) {
    	this.curso= c;
    	c.addLineaVenta(this);
    }
   public void removeCurso(Curso c) {
	   this.curso.setIdCurso(c.getIdCurso());
	   c.setLv(null);
   }

  
}
