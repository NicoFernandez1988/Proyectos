package ejercicio2relaciones.servicios;

import ejercicio2relaciones.ruletarusa.Juego;
import ejercicio2relaciones.ruletarusa.Jugador;
import ejercicio2relaciones.ruletarusa.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicioRuletaRusa {

    Scanner scan = new Scanner(System.in).useDelimiter("\n");

    RevolverDeAgua rda = new RevolverDeAgua();
    ArrayList<Jugador> jugadores = new ArrayList();
    ArrayList<RevolverDeAgua> revolver = new ArrayList();
    Juego j = new Juego();

    public void llenarJuego() {

        int contador = 1;
        System.out.println("Indique cuantos jugadores van a participar del juego? ");
        int respuesta = scan.nextInt();
        if(respuesta<1){
            System.out.println("La cantidad de jugadores no puede ser menor a 1, se ha asignado el minimo de 1 jugador.");
            respuesta = 1;
        }else if(respuesta>6){
            System.out.println("La cantidad de jugadores no puede ser mayor a 6, se ha asignado el maximo de 6 jugadores.");
            respuesta = 6;
        }  
    
        System.out.println(" ");

        do {

            Jugador J = new Jugador();

            System.out.println("Ingrese el nombre del jugador: " + contador);
            J.setNombre(scan.next());

            System.out.println("Ingrese el ID del jugador: " + contador);
            J.setId(scan.nextInt());

            jugadores.add(J);
            contador += 1;

        } while (contador != respuesta + 1);

    }

    public void llenarRevolver() {
        int numero = (int) (Math.random() * 5 + 1);
        int numero2 = (int) (Math.random() * 5 + 1);
        System.out.println("");
        System.out.println("El tambor del revolver fue girado, con una carga de agua en su interior.");
        System.out.println(" ");

        rda.setPosicionActual(numero);
        rda.setPosicionAgua(numero2);
       
    }

    public void ronda() {
           
        j.setRonda(j.getRonda() + 1);
             
        System.out.println("RONDA: " + j.getRonda());
        System.out.println(" ");
        }


    public void disparo() {
        for (int i = 0; i < jugadores.size(); i++) {
            ronda();
            System.out.println("Turno de " + jugadores.get(i).getNombre());
            System.out.println("Presiona enter para realizar el disparo.");
            String option = scan.next();
            if (mojado()) {
                System.out.println("Aca se terminó " + jugadores.get(i).getNombre());
                System.out.println("TE MOJASTE!!!");
                jugadores.get(i).setMojado("Mojado");
                break;   
            } else{
                System.out.println(jugadores.get(i).getNombre());
                System.out.println("Tuviste suerte, la carga no se disparo.");
                System.out.println(" ");
                siguienteChorro();
            }
            if (i==jugadores.size()-1){
                i=-1;
            }
        }
    }

   public boolean mojado() {
        return rda.getPosicionActual() == rda.getPosicionAgua();
       
    }

    public void siguienteChorro() {

        rda.setPosicionActual(rda.getPosicionActual() + 1);
        if (rda.getPosicionActual() == 7) {
            rda.setPosicionActual(1);
        }

    }

    public void mostrar() {

        System.out.println("FIN DEL JUEGO...");
        System.out.println("");
        System.out.println("El historial de los jugadores es: ");
        System.out.println(" ");
        jugadores.forEach((e) -> System.out.println(e));
        System.out.println(" ");

    }

}
