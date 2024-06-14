package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.repositorio.LineaVentaRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.MaterialRepositorio;
import com.salesianostriana.dam.proyectopepesegura.servicio.CertificadoServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.CursoServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.MaterialServicio;


import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CursoController {

	@Autowired
	CursoServicio cursoServicio;
	@Autowired
	CertificadoServicio  certificadoServicio;
	@Autowired
	MaterialServicio materialServicio;
	@Autowired
	LineaVentaRepositorio lineaVentaRepositorio;
	@Autowired
	MaterialRepositorio materialRepositorio;
	
	@GetMapping("/admin/Curso")
	public String listarCursos(Model model) {
		model.addAttribute("listaCurso", cursoServicio.findAll() );
		model.addAttribute("nombreCertificado",  certificadoServicio.findAll());
		model.addAttribute("listaMaterial", materialServicio.findAll());
		return "admin/listaCurso";
	}//mostrar formulario
	@GetMapping("/admin/formularioCurso")
	public String mostrarFormularioCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "admin/formularioCurso";
	}
	
	@PostMapping("/admin/nuevoCurso/submit")
	public String procesarFormularioCurso(@ModelAttribute("curso") Curso c) {
		cursoServicio.save(c).setComprado(false); //Se guarda como un curso no comprado todo aquel que entre
		return "redirect:/admin/Curso";
	}
	
	@GetMapping("/admin/editarCurso/{idCurso}")
	public String mostrarFormularioEdicionCurso(@PathVariable("idCurso") long idCurso, Model model) {
		Optional<Curso> cursoEditar = cursoServicio.findById(idCurso);
		if(cursoEditar.isPresent()) {
			model.addAttribute("listaMaterial",materialServicio.findAll());
			model.addAttribute("listaCertificado", certificadoServicio.findAll());
			model.addAttribute("curso", cursoEditar.get());
		
			return "admin/editarFormularioCurso";
		}else {
			return "redirect:/admin/Curso";
		}
	}
	
    @PostMapping("/admin/editarCurso/submit")
    public String editarCurso(@ModelAttribute("curso") Curso c) {
    	if(c.getCertificado()==null) {
    			c.setCertificado(null);
    			c.addMaterial(c.getMateriales());
    			cursoServicio.edit(c);

    	}if(c.getMateriales()==null) {
    		c.addCertificado(c.getCertificado());
    		c.setMateriales(null);
    		cursoServicio.save(c);
    		

    	}if(c.getCertificado()==null && c.getMateriales()==null) {
    		cursoServicio.save(c);
    	}else {
    		c.addCertificado(c.getCertificado());
    		c.addMaterial(c.getMateriales());
    		cursoServicio.edit(c);	
    	}
    		
    		return "redirect:/admin/Curso";
    }

/*
	@PostMapping("/admin/editarCurso/submit")
	public String editarMaterialSubmit(@ModelAttribute("curso") Curso c) {
	    cursoServicio.edit(c);
		return "redirect:/admin/Curso";
	}
	
	/*Borrar curso
	@GetMapping("/admin/borrarCurso/{idCurso}")
	public String borrar(@PathVariable("idCurso") long idCurso) {
	Optional<Curso> curso = cursoServicio.findById(idCurso);
	    if(curso.isPresent()) {
	    	 //List<Certificado> certificadosAsociados = certificadoServicio.findByCurso(idCurso);	
	    	 //f(certificadosAsociados!=null){
	    		 
	    	 
	        cursoServicio.delete(curso.get());
	    }
	    return "redirect:/admin/Curso";
	}
<<<<<<< HEAD
	
	//Controladores del usuario
	//Obtener todos los cursos e ingles y mostrarselo al usuario 
	    @GetMapping("/cursos/ingles")
	    public String listarCursosDeIngles(Model model) {
	        List<Curso> cursos = cursoServicio.obtenerCursosDeIngles();
	        model.addAttribute("listaCurso", cursos);
	        return "cursosEstudiantes";
	    }
=======
	@GetMapping("/admin/borrarCurso/{idCurso}")
    public String borrar(@PathVariable("idCurso") long idCurso) {
        cursoServicio.deleteCurso(idCurso);
        return "redirect:/admin/Curso";
    }*/
    @GetMapping("/admin/borrarCurso/{idCurso}")
    public String borrar(@PathVariable("idCurso") Long idCurso, Model model) {
    	boolean materialExiste = materialRepositorio.existsByCurso_IdCurso(idCurso);
    	boolean existeLinea = lineaVentaRepositorio.existsByCurso_IdCurso(idCurso);
    	if(existeLinea || materialExiste) {

    		return "redirect:/admin/Curso?error=true";
    	}
            cursoServicio.deleteById(idCurso);
        return "redirect:/admin/Curso";
    }
    
    //muestra todos los cursos no comprados
    @GetMapping("/user/curso")
	public String listarCursosUsuarios(Model model) {
		model.addAttribute("listaCurso", cursoServicio.obtenerCursosPorComprado(false));
		return "/cursosEstudiantes";
    }
    @GetMapping("/user/curso/comprado")
    public String listarCursosComprado(Model model) {
    	model.addAttribute("listaCurso", cursoServicio.obtenerCursosPorComprado(true));
    	return "/cursosComprado";
    }
    
	//Método para buscar por nombre (consulta derivada)
	@GetMapping("/user/cursoBuscar")
    public String cursoBuscar(@RequestParam(required = false) String nombre, 
                              Model model) {
        List<Curso> listaCurso = cursoServicio.buscarPorNombreNoComprados(nombre);
        model.addAttribute("listaCurso", listaCurso);
        return "cursosEstudiantes";
	}
	@GetMapping("/user/cursoBuscar/comprado")
    public String cursoBuscarComprado(@RequestParam(required = false) String nombre, 
                              Model model) {
        List<Curso> listaCurso = cursoServicio.buscarPorNombreSiComprados(nombre);
        model.addAttribute("listaCurso", listaCurso);
        return "cursosComprado";
	}

	//Metodo para filtrar por los cursos mas caros
	@GetMapping("/user/caros")
	public String cursoMasCaros(Model model) {
		List<Curso> listacurso = cursoServicio.filtrarPorMasCaros();
		model.addAttribute("listaCurso", listacurso);
		return "cursosEstudiantes";
	}
	//mostrar la lista de cursos en Ingles
	@GetMapping("/user/ingles")
	public String listarPorIdiomaIngles(Model model) {
		model.addAttribute("listaCurso", cursoServicio.buscarPorIdioma("ingles") );
		return "inglesUser";
	}
	//mostrar la lista de cursos en Frances
	@GetMapping("/user/frances")
	public String listarPorIdiomaFrances(Model model) {
		model.addAttribute("listaCurso", cursoServicio.buscarPorIdioma("frances"));
		return "francesUser";
	}
	//mostrar la lista de cursos en español
	@GetMapping("/user/espanol")
	public String listarPorIdiomaEspañol(Model model) {
		model.addAttribute("listaCurso", cursoServicio.buscarPorIdioma("español"));
		return "esUser";
	}
	//mostrar detalles de un curso
	@GetMapping("/curso/detalle/{idCurso}")
	public String verDetalleCurso(@PathVariable Long idCurso, Model model) {
	    // Lógica para obtener el curso por su ID, por ejemplo, mediante un servicio
	    Optional<Curso> cursoOp = cursoServicio.findById(idCurso);
	   
	    if (cursoOp.isPresent()) {
	        Curso curso = cursoOp.get();
	        model.addAttribute("curso", curso);
	        return "cursoDetalle";
	    } else {
	        // Manejar el caso donde no se encuentra el curso por el ID
	        return "error"; // Por ejemplo, podrías redirigir a una página de error
	    }
	}
	//Controlador par ver el curso 
    @GetMapping("/video/{id}")
    public String verCurso(@PathVariable Long id, Model model) {
      Curso curso = cursoServicio.buscarPorId(id);
        if (curso != null) {
            model.addAttribute("curso", curso);
        }else {
        	model.addAttribute("curso", null);
        }
        return "videoCurso"; 
    }
	
	//Controlador para mostrar video 
	@GetMapping("/video/{idCurso}")
    public String mostrarVideoCurso(@PathVariable("idCurso") long idCurso, Model model) {
        Optional<Curso> curso = cursoServicio.findById(idCurso);
        if (curso.isPresent()) {
            model.addAttribute("curso", curso.get());
        } 

        return "videoCurso";
    }
	
}
	

