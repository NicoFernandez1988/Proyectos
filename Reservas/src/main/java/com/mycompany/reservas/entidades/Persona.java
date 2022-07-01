
package com.mycompany.reservas.entidades;


public class Persona {
    
    private String Nombre;
    private String Apellido;
    private Integer Dni;
    private Sala sala;

    public Persona() {
    }

    public Persona(String Nombre, String Apellido, Integer Dni, Sala sala) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Dni = Dni;
        this.sala = sala;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Integer getDni() {
        return Dni;
    }

    public void setDni(Integer Dni) {
        this.Dni = Dni;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Persona: {" + "Nombre: " + Nombre + " // Apellido: " + Apellido + " // Dni: " + Dni + " // " + sala + '}';
    }


    
    
}
