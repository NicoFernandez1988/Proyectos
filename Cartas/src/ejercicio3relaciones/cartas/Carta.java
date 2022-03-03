package ejercicio3relaciones.cartas;


import ejercicio3.Enum.Valores;
import ejercicio3.Enum.Palos;

public class Carta {

    private Valores valores;

    private Palos palos;

    public Carta() {
    }

    public Carta(Valores valores, Palos palos) {
        this.valores = valores;
        this.palos = palos;
    }

    public Valores getValores() {
        return valores;
    }

    public void setValores(Valores valores) {
        this.valores = valores;
    }

    public Palos getPalos() {
        return palos;
    }

    public void setPalos(Palos palos) {
        this.palos = palos;
    }

    @Override
    public String toString() {
        return "Carta{" + "valores=" + valores + ", palos=" + palos + '}';
    }
    
    
    
    
}
