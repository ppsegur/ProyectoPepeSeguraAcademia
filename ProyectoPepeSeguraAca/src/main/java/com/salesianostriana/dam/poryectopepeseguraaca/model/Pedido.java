package com.salesianostriana.dam.poryectopepeseguraaca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
@Builder
public class Pedido {

	
	@Id
	@GeneratedValue
	private long idPedido;
	private double precioF;

	/*@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_estudiante_pedido"))
	private Estudiante estudiante;*/
}
