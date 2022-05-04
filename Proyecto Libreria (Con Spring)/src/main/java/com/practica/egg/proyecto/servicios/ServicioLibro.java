
package com.practica.egg.proyecto.servicios;

import com.practica.egg.proyecto.entidades.Autor;
import com.practica.egg.proyecto.entidades.Editorial;
import com.practica.egg.proyecto.entidades.Libro;
import com.practica.egg.proyecto.errores.ErrorServicio;
import com.practica.egg.proyecto.repositorios.RepositorioAutor;
import com.practica.egg.proyecto.repositorios.RepositorioEditorial;
import com.practica.egg.proyecto.repositorios.RepositorioLibro;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioLibro {
    
    @Autowired
    private RepositorioLibro repositorioLibro;
    @Autowired
    private RepositorioAutor repositorioAutor;
    @Autowired
    private RepositorioEditorial repositorioEditorial;
    
public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, String idAutor, String idEditorial) throws ErrorServicio {
    
        
        Autor autor = repositorioAutor.getOne(idAutor);
        if(autor == null){
            throw new ErrorServicio("No se encontro el autor solicitado");
        }
        Editorial editorial = repositorioEditorial.getOne(idEditorial);
        if(editorial == null){
            throw new ErrorServicio("No se encontro la editorial solicitada");
        }
        
        if (isbn == null) {
            String s = String.valueOf(isbn);
            
            throw new ErrorServicio ("Debe indicar ISBN");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new ErrorServicio ("Debe indicar el Titulo");
        }
        
        if (anio == null) {
            throw new ErrorServicio ("Debe ingresar el anio");
        }
        if (ejemplares == null) {
            throw new ErrorServicio ("Debe ingresar ejemplares");
        }
        if (ejemplaresPrestados == null) {
            throw new ErrorServicio ("Debe ingresar los ejemplares prestados");
        }
       
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);
        libro.setAlta(Boolean.TRUE);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        repositorioLibro.save(libro);
    }

    public void consultaLibro(String id) throws ErrorServicio{
         
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del libro no puede ser nulo");
        }
        
        Optional<Libro>respuesta = repositorioLibro.findById(id);
        
        if(respuesta.isPresent()){
        
        
        System.out.println("El libro buscado, se encuentra en la base de datos.");
        
        
        }else{
            throw new ErrorServicio("No se encontro el Autor solicitado.");
        }
    }

    public void modificarLibro(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, String idAutor, String idEditorial) throws ErrorServicio{
        
        
        Autor autor = repositorioAutor.getOne(idAutor);
        if(autor == null){
            throw new ErrorServicio("No se encontro el autor solicitado");
        }
        Editorial editorial = repositorioEditorial.getOne(idEditorial);
        if(editorial == null){
            throw new ErrorServicio("No se encontro la editorial solicitada");
        }
        
        
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del libro no puede ser nulo");
        }
        
         if (isbn == null || isbn.toString().isEmpty()) {
            throw new ErrorServicio ("Debe indicar ISBN");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new ErrorServicio ("Debe indicar el Titulo");
        }
        
        if (anio == null) {
            throw new ErrorServicio ("Debe ingresar el año");
        }
        if (ejemplares == null) {
            throw new ErrorServicio ("Debe ingresar ejemplares");
        }
        
        if (ejemplaresPrestados == null) {
            throw new ErrorServicio ("Debe ingresar ejemplares");
        }
        
        
        Optional<Libro>respuesta = repositorioLibro.findById(id);
        if(respuesta.isPresent()){
        Libro libro = respuesta.get();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        repositorioLibro.save(libro);
        } else{
            throw new ErrorServicio("No se encontro el libro solicitado.");
        }
        
        
    }
    
    public void DarBajaLibro(String id) throws ErrorServicio{
        
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del libro no puede ser nulo");
        }
        
        Optional<Libro>respuesta = repositorioLibro.findById(id);
        if(respuesta.isPresent()){
        Libro libro = respuesta.get();
        libro.setAlta(Boolean.FALSE);
        
        repositorioLibro.save(libro);
        } else{
            throw new ErrorServicio("No se encontro el libro solicitado.");
        }
        
    }
    
    public void DarAltaLibro(String id) throws ErrorServicio{
        
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del libro no puede ser nulo");
        }
        
        Optional<Libro>respuesta = repositorioLibro.findById(id);
        if(respuesta.isPresent()){
        Libro libro = respuesta.get();
        libro.setAlta(Boolean.TRUE);
        
        repositorioLibro.save(libro);
        } else{
            throw new ErrorServicio("No se encontro el libro solicitado.");
        }
        
    }
    
}
