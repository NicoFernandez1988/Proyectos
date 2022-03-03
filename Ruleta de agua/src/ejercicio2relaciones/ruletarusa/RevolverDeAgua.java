
package ejercicio2relaciones.ruletarusa;


public class RevolverDeAgua {
    
    private int posicionActual;
    private int posicionAgua;
    private String chorro = "Mojado";
    public RevolverDeAgua() {
    }

    public RevolverDeAgua(int posicionActual, int posicionAgua, String chorro) {
        this.posicionActual = posicionActual;
        this.posicionAgua = posicionAgua;
        this.chorro = chorro;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(int posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    public String getChorro() {
        return chorro;
    }

    public void setChorro(String chorro) {
        this.chorro = chorro;
    }

    @Override
    public String toString() {
        return "RevolverDeAgua{" + "posicionActual=" + posicionActual + ", posicionAgua=" + posicionAgua + ", chorro=" + chorro + '}';
    }

   
    
   
}
