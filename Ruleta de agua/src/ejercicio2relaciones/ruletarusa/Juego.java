
package ejercicio2relaciones.ruletarusa;


public class Juego {
    
    private Jugador jugadores;
    private RevolverDeAgua revolver;
    private int ronda;
    
    public Juego() {
    }

    public Juego(Jugador jugadores, RevolverDeAgua revolver, int ronda) {
        this.jugadores = jugadores;
        this.revolver = revolver;
        this.ronda = ronda;
    }

    public Jugador getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugadores) {
        this.jugadores = jugadores;
    }

    public RevolverDeAgua getRevolver() {
        return revolver;
    }

    public void setRevolver(RevolverDeAgua revolver) {
        this.revolver = revolver;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    @Override
    public String toString() {
        return "Juego{" + "jugadores=" + jugadores + ", revolver=" + revolver + ", ronda=" + ronda + '}';
    }

   
    
    
}
