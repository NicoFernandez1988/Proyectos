package com.practica.egg.proyecto.controladores;

import com.practica.egg.proyecto.entidades.Autor;
import com.practica.egg.proyecto.entidades.Editorial;
import com.practica.egg.proyecto.entidades.Libro;
import com.practica.egg.proyecto.errores.ErrorServicio;
import com.practica.egg.proyecto.repositorios.RepositorioAutor;
import com.practica.egg.proyecto.repositorios.RepositorioEditorial;
import com.practica.egg.proyecto.repositorios.RepositorioLibro;
import com.practica.egg.proyecto.servicios.ServicioLibro;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortalControladorLibro {

    
    @Autowired
    private RepositorioAutor repositorioAutor;
    
    @Autowired
    private RepositorioEditorial repositorioEditorial;
    @Autowired
    private ServicioLibro servicioLibro;
    @Autowired
    private RepositorioLibro repositorioLibro;

    

    @GetMapping("/RegistroLibro")
    public String RegistroLibro(ModelMap modelo) {
        List<Autor> autores = repositorioAutor.findAll();
        modelo.put("autores", autores);
        List<Editorial> editoriales = repositorioEditorial.findAll();
        modelo.put("editoriales", editoriales);
        return "RegistroLibro.html";
    }

    @PostMapping("/RegistroLibro")
    public String crearLibro(ModelMap modelo, @RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ejemplaresPrestados, @RequestParam String idAutor, @RequestParam String idEditorial) throws ErrorServicio {

        try {
            servicioLibro.crearLibro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, idAutor, idEditorial);
            
            List<Autor> autores = repositorioAutor.findAll();
            List<Editorial> editoriales = repositorioEditorial.findAll();
            modelo.put("autores", autores);
            modelo.put("editoriales", editoriales);
            modelo.put("exito", "Registro exitoso!!!");
            return "RegistroLibro.html";

        } catch (ErrorServicio ex) {
            String s = String.valueOf(anio);
            modelo.put("anio", s);
            List<Autor> autores = repositorioAutor.findAll();
            List<Editorial> editoriales = repositorioEditorial.findAll();
            modelo.put("error", "Error en el registro, faltan datos!!!");
            modelo.put("autores", autores);
            modelo.put("editoriales", editoriales);
            Logger.getLogger(PortalControladorAutor.class.getName()).log(Level.SEVERE, null, ex);
            
            return "RegistroLibro.html";
        }

    }

    @GetMapping("/ListarLibros")
    public String ListarLibros(ModelMap modelo) {
        List<Libro> librosLista = repositorioLibro.findAll();
        modelo.addAttribute("libros", librosLista);
        return "ListarLibros";
    }

    @GetMapping("/ModificarLibro/{id}")
    public String ModificarLibro(ModelMap modelo, @PathVariable String id) throws ErrorServicio {
        List<Autor> autores = repositorioAutor.findAll();
        modelo.addAttribute("autores", autores);
        List<Editorial> editoriales = repositorioEditorial.findAll();
        modelo.addAttribute("editoriales", editoriales);
        modelo.put("libro", repositorioLibro.getOne(id));
        return "ModificarLibro.html";
    }

    @PostMapping("/ModificarLibro/{id}")
    public String ModificarLibro(ModelMap modelo, @PathVariable String id, @RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ejemplaresPrestados, @RequestParam String idAutor, @RequestParam String idEditorial) throws ErrorServicio {

        try {
            servicioLibro.modificarLibro(id, isbn, titulo, anio, ejemplares, ejemplaresPrestados, idAutor, idEditorial);
        } catch (ErrorServicio ex) {
            List<Autor> autores = repositorioAutor.findAll();
            List<Editorial> editoriales = repositorioEditorial.findAll();
            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            modelo.put("autor", idAutor);
            modelo.put("editorial", idEditorial);
            Logger.getLogger(PortalControladorAutor.class.getName()).log(Level.SEVERE, null, ex);
            return "ModificarLibro.html";
        }
        return "index.html";

    }

    @GetMapping("/bajaLibro/{id}")
    public String bajaLibro(@PathVariable String id) throws ErrorServicio {
        try {
            servicioLibro.DarBajaLibro(id);
            return "redirect:/ListarLibros";
        } catch (ErrorServicio ex) {
            return "redirect:/";
        }
    }

    @GetMapping("/altaLibro/{id}")
    public String altaLibro(@PathVariable String id) throws ErrorServicio {
        try {
            servicioLibro.DarAltaLibro(id);
            return "redirect:/ListarLibros";
        } catch (ErrorServicio ex) {
            return "redirect:/";
        }
    }

}