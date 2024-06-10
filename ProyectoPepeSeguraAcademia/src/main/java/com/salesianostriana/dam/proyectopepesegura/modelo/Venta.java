package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.time.LocalDate;
import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @ManyToOne
    @JoinColumn(name = "id")
    private Estudiante estudiante;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "venta", 
    		cascade = CascadeType.ALL, 
    		fetch = FetchType.EAGER,
    		orphanRemoval = true)
    @Builder.Default
    private List<LineaVenta> lv = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPedido;
    private double importeTotal;
   //Booleano 
    private boolean finalizada;
	//LineaVenta
	
	public void addLineaVenta(LineaVenta lv) {
		this.lv.add(lv);
		lv.setVenta(this);
	}

	
	public void removeLineaVenta(LineaVenta lv) {
	    this.lv.remove(lv);
	    lv.setVenta(null);
	}

	
	
}