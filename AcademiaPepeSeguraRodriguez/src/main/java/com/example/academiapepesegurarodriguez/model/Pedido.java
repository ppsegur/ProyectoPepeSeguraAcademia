package com.example.academiapepesegurarodriguez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@Entity@AllArgsConstructor@NoArgsConstructor
@Builder
public class Pedido {

	@Id
	@GeneratedValue
	private long id;
	private double precioF;

	/*@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_estudiante_pedido"))
	private Estudiante estudiante;*/
}
