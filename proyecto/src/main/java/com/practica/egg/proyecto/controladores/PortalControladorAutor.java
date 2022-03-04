package com.practica.egg.proyecto.controladores;

import com.practica.egg.proyecto.entidades.Autor;
import com.practica.egg.proyecto.errores.ErrorServicio;
import com.practica.egg.proyecto.repositorios.RepositorioAutor;
import com.practica.egg.proyecto.servicios.ServicioAutor;
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
public class PortalControladorAutor {

    @Autowired
    private ServicioAutor servicioAutor;
    @Autowired
    private RepositorioAutor repositorioAutor;
    

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/RegistroAutor")
    public String RegistroAutor() {
        return "RegistroAutor.html";
    }

    @PostMapping("/RegistroAutor")
    public String guardar(ModelMap modelo, @RequestParam String nombre) throws ErrorServicio {

        try {
            servicioAutor.crearAutor(nombre);
            modelo.put("exito", "Registro exitoso!!!");
            return "RegistroAutor.html";
        } catch (ErrorServicio ex) {
            modelo.put("error", "Error en el registro, faltan datos!!!");
            Logger.getLogger(PortalControladorAutor.class.getName()).log(Level.SEVERE, null, ex);
            return "RegistroAutor.html";
        }

    }

    @GetMapping("/ListarAutores")
    public String ListarAutores(ModelMap modelo) {
        List<Autor> autoresLista = repositorioAutor.findAll();
        modelo.addAttribute("autores", autoresLista);
        return "ListarAutores";
    }

    @GetMapping("/ModificarAutor/{id}")
    public String ModificarAutor(ModelMap modelo, @PathVariable String id) throws ErrorServicio {

        modelo.put("autor", repositorioAutor.getOne(id));
        return "ModificarAutor.html";
    }

    @PostMapping("/ModificarAutor/{id}")
    public String ModificarAutor(@PathVariable String id, @RequestParam String nombre) throws ErrorServicio {

        try {
            servicioAutor.modificarAutor(id, nombre);
        } catch (ErrorServicio ex) {
            Logger.getLogger(PortalControladorAutor.class.getName()).log(Level.SEVERE, null, ex);
            return "ModificarAutor.html";
        }
        return "index.html";

    }

    @GetMapping("/bajaAutor/{id}")
    public String bajaAutor(@PathVariable String id) throws ErrorServicio {
        try {
            servicioAutor.DarBajaAutor(id);
            return "redirect:/ListarAutores";
        } catch (ErrorServicio ex) {
            return "redirect:/";
        }
    }

    @GetMapping("/altaAutor/{id}")
    public String altaAutor(@PathVariable String id) throws ErrorServicio {
        try {
            servicioAutor.DarAltaAutor(id);
            return "redirect:/ListarAutores";
        } catch (ErrorServicio ex) {
            return "redirect:/";
        }
    }
//
//    @GetMapping("/RegistroEditorial")
//    public String RegistroEditorial() {
//        return "RegistroEditorial.html";
//    }
//
//    @PostMapping("/RegistroEditorial")
//    public String crearEditorial(ModelMap modelo, @RequestParam String nombre) throws ErrorServicio {
//
//        try {
//            servicioEditorial.crearEditorial(nombre);
//            modelo.put("exito", "Registro exitoso!!!");
//            return "RegistroEditorial.html";
//        } catch (ErrorServicio ex) {
//            modelo.put("error", "Error en el registro, faltan datos!!!");
//            Logger.getLogger(PortalControlador.class.getName()).log(Level.SEVERE, null, ex);
//            return "RegistroEditorial.html";
//        }
//
//    }
//
//    @GetMapping("/ListarEditoriales")
//    public String ListarEditoriales(ModelMap modelo) {
//        List<Editorial> editorialesLista = repositorioEditorial.findAll();
//        modelo.addAttribute("editoriales", editorialesLista);
//        return "ListarEditoriales";
//    }
//
//    @GetMapping("/ModificarEditorial/{id}")
//    public String ModificarEditorial(ModelMap modelo, @PathVariable String id) throws ErrorServicio {
//
//        modelo.put("editorial", repositorioEditorial.getOne(id));
//        return "ModificarEditorial.html";
//    }
//
//    @PostMapping("/ModificarEditorial/{id}")
//    public String ModificarEditorial(@PathVariable String id, @RequestParam String nombre) throws ErrorServicio {
//
//        try {
//            servicioEditorial.modificarEditorial(id, nombre);
//        } catch (ErrorServicio ex) {
//            Logger.getLogger(PortalControlador.class.getName()).log(Level.SEVERE, null, ex);
//            return "ModificarEditorial.html";
//        }
//        return "index.html";
//
//    }
//
//    @GetMapping("/bajaEditorial/{id}")
//    public String bajaEditorial(@PathVariable String id) throws ErrorServicio {
//        try {
//            servicioEditorial.DarBajaEditorial(id);
//            return "redirect:/ListarEditoriales";
//        } catch (ErrorServicio ex) {
//            return "redirect:/";
//        }
//    }
//
//    @GetMapping("/altaEditorial/{id}")
//    public String altaEditorial(@PathVariable String id) throws ErrorServicio {
//        try {
//            servicioEditorial.DarAltaEditorial(id);
//            return "redirect:/ListarEditoriales";
//        } catch (ErrorServicio ex) {
//            return "redirect:/";
//        }
//    }

//    @GetMapping("/RegistroLibro")
//    public String RegistroLibro(ModelMap modelo) {
//        List<Autor> autores = repositorioAutor.findAll();
//        modelo.put("autores", autores);
//        List<Editorial> editoriales = repositorioEditorial.findAll();
//        modelo.put("editoriales", editoriales);
//        return "RegistroLibro.html";
//    }
//
//    @PostMapping("/RegistroLibro")
//    public String crearLibro(ModelMap modelo, @RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ejemplaresPrestados, @RequestParam String idAutor, @RequestParam String idEditorial) throws ErrorServicio {
//
//        try {
//            servicioLibro.crearLibro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, idAutor, idEditorial);
//            
//            List<Autor> autores = repositorioAutor.findAll();
//            List<Editorial> editoriales = repositorioEditorial.findAll();
//            modelo.put("autores", autores);
//            modelo.put("editoriales", editoriales);
//            modelo.put("exito", "Registro exitoso!!!");
//            return "RegistroLibro.html";
//
//        } catch (ErrorServicio ex) {
//            String s = String.valueOf(anio);
//            modelo.put("anio", s);
//            List<Autor> autores = repositorioAutor.findAll();
//            List<Editorial> editoriales = repositorioEditorial.findAll();
//            modelo.put("error", "Error en el registro, faltan datos!!!");
//            modelo.put("autores", autores);
//            modelo.put("editoriales", editoriales);
//            Logger.getLogger(PortalControlador.class.getName()).log(Level.SEVERE, null, ex);
//            
//            return "RegistroLibro.html";
//        }
//
//    }
//
//    @GetMapping("/ListarLibros")
//    public String ListarLibros(ModelMap modelo) {
//        List<Libro> librosLista = repositorioLibro.findAll();
//        modelo.addAttribute("libros", librosLista);
//        return "ListarLibros";
//    }
//
//    @GetMapping("/ModificarLibro/{id}")
//    public String ModificarLibro(ModelMap modelo, @PathVariable String id) throws ErrorServicio {
//        List<Autor> autores = repositorioAutor.findAll();
//        modelo.addAttribute("autores", autores);
//        List<Editorial> editoriales = repositorioEditorial.findAll();
//        modelo.addAttribute("editoriales", editoriales);
//        modelo.put("libro", repositorioLibro.getOne(id));
//        return "ModificarLibro.html";
//    }
//
//    @PostMapping("/ModificarLibro/{id}")
//    public String ModificarLibro(ModelMap modelo, @PathVariable String id, @RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer ejemplaresPrestados, @RequestParam String idAutor, @RequestParam String idEditorial) throws ErrorServicio {
//
//        try {
//            servicioLibro.modificarLibro(id, isbn, titulo, anio, ejemplares, ejemplaresPrestados, idAutor, idEditorial);
//        } catch (ErrorServicio ex) {
//            List<Autor> autores = repositorioAutor.findAll();
//            List<Editorial> editoriales = repositorioEditorial.findAll();
//            modelo.addAttribute("autores", autores);
//            modelo.addAttribute("editoriales", editoriales);
//            modelo.put("autor", idAutor);
//            modelo.put("editorial", idEditorial);
//            Logger.getLogger(PortalControlador.class.getName()).log(Level.SEVERE, null, ex);
//            return "ModificarLibro.html";
//        }
//        return "index.html";
//
//    }
//
//    @GetMapping("/bajaLibro/{id}")
//    public String bajaLibro(@PathVariable String id) throws ErrorServicio {
//        try {
//            servicioLibro.DarBajaLibro(id);
//            return "redirect:/ListarLibros";
//        } catch (ErrorServicio ex) {
//            return "redirect:/";
//        }
//    }
//
//    @GetMapping("/altaLibro/{id}")
//    public String altaLibro(@PathVariable String id) throws ErrorServicio {
//        try {
//            servicioLibro.DarAltaLibro(id);
//            return "redirect:/ListarLibros";
//        } catch (ErrorServicio ex) {
//            return "redirect:/";
//        }
//    }

}
