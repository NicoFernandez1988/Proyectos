package com.practica.egg.proyecto.controladores;


import com.practica.egg.proyecto.entidades.Editorial;

import com.practica.egg.proyecto.errores.ErrorServicio;

import com.practica.egg.proyecto.repositorios.RepositorioEditorial;

import com.practica.egg.proyecto.servicios.ServicioEditorial;

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
public class PortalControladorEditorial {

    
    @Autowired
    private ServicioEditorial servicioEditorial;
    @Autowired
    private RepositorioEditorial repositorioEditorial;
    @Autowired
    


    @GetMapping("/RegistroEditorial")
    public String RegistroEditorial() {
        return "RegistroEditorial.html";
    }

    @PostMapping("/RegistroEditorial")
    public String crearEditorial(ModelMap modelo, @RequestParam String nombre) throws ErrorServicio {

        try {
            servicioEditorial.crearEditorial(nombre);
            modelo.put("exito", "Registro exitoso!!!");
            return "RegistroEditorial.html";
        } catch (ErrorServicio ex) {
            modelo.put("error", "Error en el registro, faltan datos!!!");
            Logger.getLogger(PortalControladorAutor.class.getName()).log(Level.SEVERE, null, ex);
            return "RegistroEditorial.html";
        }

    }

    @GetMapping("/ListarEditoriales")
    public String ListarEditoriales(ModelMap modelo) {
        List<Editorial> editorialesLista = repositorioEditorial.findAll();
        modelo.addAttribute("editoriales", editorialesLista);
        return "ListarEditoriales";
    }

    @GetMapping("/ModificarEditorial/{id}")
    public String ModificarEditorial(ModelMap modelo, @PathVariable String id) throws ErrorServicio {

        modelo.put("editorial", repositorioEditorial.getOne(id));
        return "ModificarEditorial.html";
    }

    @PostMapping("/ModificarEditorial/{id}")
    public String ModificarEditorial(@PathVariable String id, @RequestParam String nombre) throws ErrorServicio {

        try {
            servicioEditorial.modificarEditorial(id, nombre);
        } catch (ErrorServicio ex) {
            Logger.getLogger(PortalControladorAutor.class.getName()).log(Level.SEVERE, null, ex);
            return "ModificarEditorial.html";
        }
        return "index.html";

    }

    @GetMapping("/bajaEditorial/{id}")
    public String bajaEditorial(@PathVariable String id) throws ErrorServicio {
        try {
            servicioEditorial.DarBajaEditorial(id);
            return "redirect:/ListarEditoriales";
        } catch (ErrorServicio ex) {
            return "redirect:/";
        }
    }

    @GetMapping("/altaEditorial/{id}")
    public String altaEditorial(@PathVariable String id) throws ErrorServicio {
        try {
            servicioEditorial.DarAltaEditorial(id);
            return "redirect:/ListarEditoriales";
        } catch (ErrorServicio ex) {
            return "redirect:/";
        }
    }

}