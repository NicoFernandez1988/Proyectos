
package com.practica.egg.proyecto.servicios;


import com.practica.egg.proyecto.entidades.Editorial;
import com.practica.egg.proyecto.errores.ErrorServicio;
import com.practica.egg.proyecto.repositorios.RepositorioEditorial;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEditorial {
    
    
    @Autowired
    private RepositorioEditorial repositorioEditorial;
    
    public void crearEditorial(String nombre) throws ErrorServicio{
        
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre de la editorial no puede ser nulo.");
        }
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(Boolean.TRUE);
        
        repositorioEditorial.save(editorial);
        
    }
    
    public void consultaEditorial(String id) throws ErrorServicio{
         
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del autor no puede ser nulo");
        }
        
        Optional<Editorial>respuesta = repositorioEditorial.findById(id);
        
        if(respuesta.isPresent()){
        
        
        System.out.println("La editorial buscada, se encuentra en la base de datos.");
        
        
        }else{
            throw new ErrorServicio("No se encontro el Autor solicitado.");
        }
    }
    
    public void modificarEditorial(String id, String nombre) throws ErrorServicio{
        
        if(id == null){
            throw new ErrorServicio("El id del autor no puede ser nulo");
        }
        
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
        
        Optional<Editorial>respuesta = repositorioEditorial.findById(id);
        if(respuesta.isPresent()){
        Editorial editorial = respuesta.get();
        editorial.setNombre(nombre);
        
        repositorioEditorial.save(editorial);
        } else{
            throw new ErrorServicio("No se encontro la editorial solicitada.");
        }
        
        
    }
    
    
    public void DarBajaEditorial(String id) throws ErrorServicio{
        
        if(id == null){
            throw new ErrorServicio("El id de la editorial no puede ser nulo");
        }
        
        Optional<Editorial>respuesta = repositorioEditorial.findById(id);
        if(respuesta.isPresent()){
        Editorial editorial = respuesta.get();
        editorial.setAlta(Boolean.FALSE);
        
        repositorioEditorial.save(editorial);
        } else{
            throw new ErrorServicio("No se encontro la editorial solicitada.");
        }
        
    }
    
    public void DarAltaEditorial(String id) throws ErrorServicio{
        
        if(id == null){
            throw new ErrorServicio("El id de la editorial no puede ser nulo");
        }
        
        Optional<Editorial>respuesta = repositorioEditorial.findById(id);
        if(respuesta.isPresent()){
        Editorial editorial = respuesta.get();
        editorial.setAlta(Boolean.TRUE);
        
        repositorioEditorial.save(editorial);
        } else{
            throw new ErrorServicio("No se encontro la editorial solicitada.");
        }
        
    }
    
}
