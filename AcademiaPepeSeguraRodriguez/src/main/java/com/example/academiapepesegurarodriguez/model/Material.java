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

@Data@Entity@NoArgsConstructor@AllArgsConstructor
@Builder
public class Material {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String tipo;
	
	/*@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_curso_material"))
	private Curso curso;*/
}
