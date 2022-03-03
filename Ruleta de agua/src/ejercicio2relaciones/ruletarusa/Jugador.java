
package ejercicio2relaciones.ruletarusa;



public class Jugador {
    
    private int Id;
    private String nombre;
    private String mojado = "Seco";
    
    public Jugador() {
    }

    public Jugador(int Id, String nombre, String mojado) {
        this.Id = Id;
        this.nombre = nombre;
        this.mojado = mojado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMojado() {
        return mojado;
    }

    public void setMojado(String mojado) {
        this.mojado = mojado;
    }

    @Override
    public String toString() {
        return "Jugador{" + "Id=" + Id + ", nombre=" + nombre + ", mojado=" + mojado + '}';
    }
    
    
    
    
}
