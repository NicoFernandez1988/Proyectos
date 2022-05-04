
package com.practica.egg.proyecto.repositorios;


import com.practica.egg.proyecto.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLibro extends JpaRepository<Libro, String> {
    
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo")String titulo);
    
    
}
