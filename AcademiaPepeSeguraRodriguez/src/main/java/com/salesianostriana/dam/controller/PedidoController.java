package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.dam.model.Pedido;
import com.salesianostriana.dam.services.PedidoService;

@Controller
@RequestMapping("/admin/pedido")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	@GetMapping({"/", "/listaPedido"})
	public String listarTodos(Model model) {
		model.addAttribute("listaPedido",pedidoService.findAll() );
		return "listaDPedido";//No colocada
	}
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("pedido", new Pedido());
		return "FormularioPedido";
	}
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("estudiante") Pedido p) {
		pedidoService.save(p);
		return "rediret:/";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		if(pedidoService.findById(id).isPresent()) {
			model.addAttribute("estudiante", pedidoService.findById(id).get());
			return "FormularioPedido";
		}else {
			return "redirect:/";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("pedido") Pedido p) {
		pedidoService.edit(p);
		return "redirect:/";
	}

	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		pedidoService.deleteById(id);
		return "redirect:/";
	}
}
