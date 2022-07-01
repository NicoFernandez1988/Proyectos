
package com.mycompany.reservas.entidades;


public class Sala {
    
    private String tipo;
    private String dia;
    private String turno;
    
    
    public Sala() {
    }

    public Sala(String tipo, String dia, String turno) {
        this.tipo = tipo;
        this.dia = dia;
        this.turno = turno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Sala: {" + "Tipo: " + tipo + " // Dia: " + dia + " // Turno: " + turno + '}';
    }

  
    
}
