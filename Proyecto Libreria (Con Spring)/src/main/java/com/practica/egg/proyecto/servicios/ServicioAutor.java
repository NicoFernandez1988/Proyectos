
package com.practica.egg.proyecto.servicios;

import com.practica.egg.proyecto.entidades.Autor;
import com.practica.egg.proyecto.errores.ErrorServicio;
import com.practica.egg.proyecto.repositorios.RepositorioAutor;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutor {
    
    
    @Autowired
    private RepositorioAutor repositorioAutor;
    
    public void crearAutor(String nombre) throws ErrorServicio{
        
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre del autor no puede ser nulo.");
        }
        
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(Boolean.TRUE);
        
        repositorioAutor.save(autor);
        
    }
    
     public void consultaAutor(String id) throws ErrorServicio{
         
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del autor no puede ser nulo");
        }
        
        Optional<Autor>respuesta = repositorioAutor.findById(id);
        
        if(respuesta.isPresent()){
        
        
        System.out.println("El autor buscado, se encuentra en la base de datos.");
        
        
        }else{
            throw new ErrorServicio("No se encontro el Autor solicitado.");
        }
    }
    
    
    public void modificarAutor(String id, String nombre) throws ErrorServicio{
        
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del autor no puede ser nulo");
        }
        
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
        
        Optional<Autor>respuesta = repositorioAutor.findById(id);
        if(respuesta.isPresent()){
        Autor autor = respuesta.get();
        autor.setNombre(nombre);
        
        repositorioAutor.save(autor);
        } else{
            throw new ErrorServicio("No se encontro el Autor solicitado.");
        }
        
        
    }
    
    
    public void DarBajaAutor(String id) throws ErrorServicio{
        
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del autor no puede ser nulo");
        }
        
        Optional<Autor>respuesta = repositorioAutor.findById(id);
        if(respuesta.isPresent()){
        Autor autor = respuesta.get();
        autor.setAlta(Boolean.FALSE);
        
        repositorioAutor.save(autor);
        } else{
            throw new ErrorServicio("No se encontro el Autor solicitado.");
        }
        
    }
    
   public void DarAltaAutor(String id) throws ErrorServicio{
        
        if(id == null || id.isEmpty()){
            throw new ErrorServicio("El id del autor no puede ser nulo");
        }
        
        Optional<Autor>respuesta = repositorioAutor.findById(id);
        if(respuesta.isPresent()){
        Autor autor = respuesta.get();
        autor.setAlta(Boolean.TRUE);
        
        repositorioAutor.save(autor);
        } else{
            throw new ErrorServicio("No se encontro el Autor solicitado.");
        }
        
    }
    
}
