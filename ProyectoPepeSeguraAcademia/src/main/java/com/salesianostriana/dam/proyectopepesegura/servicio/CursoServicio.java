package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Certificado;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CertificadoRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CursoServicio extends BaseServiceImpl<Curso, Long, CursoRepositorio>{
	
	@Autowired
	private CertificadoRepositorio certificadoRepositorio; 
	@Autowired
	 private CursoRepositorio cursoRepositorio;
	 
	@Autowired
	private CertificadoServicio certificadoServicio;
	
	public List<Curso> buscarPorIdioma(String nombre) {
		return cursoRepositorio.findByNombreContainsIgnoreCase(nombre);
	}
	public Optional<Curso> finById(Long id){
		return cursoRepositorio.findById(id);
	}
	
	
	public Curso asignaCertificadoACurso(Curso c, @PathVariable("id") Long id ) {
		Certificado certificado = c.getCertificado();
		Optional<Curso> cursoAsignado = cursoRepositorio.findById(id);
		if (certificado != null && cursoAsignado.isPresent()) {
		cursoAsignado.get().setCertificado(certificado);
	    certificadoServicio.save(certificado);
		} 
		return c;
		
		
	}
	
	public void editarCurso(Long id) {
		
	}
	
    @Transactional
    public void deleteCurso(Long id) {
        Optional<Curso> cursos = cursoRepositorio.findById(id);
        if (cursos.isPresent()) {
            Curso curso = cursos.get();
            if (curso.getCertificado() == null || curso.getMateriales() == null) {
               cursoRepositorio.delete(curso);
            } if (curso.getCertificado() != null || curso.getMateriales() != null) {

           // String mensaje;//mostrar en pantalla un mensaje que le salga que no puede borrar cursos con datos asociados
            	String  modal= "No se puede borrar un curso asociado";
            }
    }

}
}