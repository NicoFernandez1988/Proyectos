package ejercicio3relaciones.ServicioBaraja;


import ejercicio3relaciones.cartas.Carta;
import ejercicio3.Enum.Valores;
import ejercicio3.Enum.Palos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baraja {

    private Carta C;
    Scanner read = new Scanner(System.in);
    private ArrayList<Carta> mazo = new ArrayList();
    private ArrayList<Carta> eliminar = new ArrayList();
    Valores V1;
    Palos P1;
    Carta C1 = new Carta();
    

    public void crearMazo() {
        
          int count = 0;
        do {
            for (Valores aux : Valores.values()) {
                if (count == 0) {
                    C1 = new Carta(aux, P1.ORO);
                    mazo.add(C1);
                }
                if (count == 1) {
                     C1 = new Carta(aux, P1.BASTO);
                    mazo.add(C1);
                }
                if (count == 2) {
                     C1 = new Carta(aux, P1.COPA);
                    mazo.add(C1);
                }
                if (count == 3) {
                   C1 = new Carta(aux, P1.ESPADA);
                    mazo.add(C1);
                }
            }
            count++;
        } while (count != 4);
        
    }
    
    public void barajar(){
        
        Collections.shuffle(mazo);
        System.out.println(" ");
        System.out.println("El mazo de cartas fue barajado.");
        System.out.println(" ");
    }

    public void siguienteCarta() {
       
        System.out.println(" ");
        System.out.println(mazo.get(0).toString());
        eliminar.add(mazo.get(0));
        mazo.remove(0);
        
    }

    public void cartasDisponibles() {
        
          System.out.println("Cartas disponibles: ");
        System.out.println(mazo.size() + " cartas.");
        
    }

    public void darCartas() {
        
        System.out.println("Cuantas cartas desea sacar?");
        int cartas = read.nextInt();
        
        if(cartas > mazo.size()){
            System.out.println("No quedan cartas.");
        }else{
            int count=0;
            do {
                siguienteCarta();
                count++;
            } while (cartas != count);
            
        }
        
    }

    public void cartasMonton() {
        System.out.println(" ");
        System.out.println("Las cartas que fueron repartidas son: ");
        System.out.println(" ");
         for (Carta aux : eliminar) {
            
            System.out.println(aux.toString());
        }
        
    }

    public void mostrarBaraja() {
        
         for (Carta aux : mazo) {
            
            System.out.println(aux);
        }
        
    }
    
    public void menu(){
        
        boolean salir = false;
            System.out.println("--------------BIENVENIDO--------------");
            System.out.println(" ");
            System.out.println("Usted cuenta con un mazo de 40 cartas.");
            System.out.println("");
        do {
            
             System.out.println("Elija una opcion: ");
             System.out.println("1. Barajar mazo.");
             System.out.println("2. Dar la primer carta del mazo.");
             System.out.println("3. Mostrar la cantidad de cartas del mazo.");
             System.out.println("4. Repartir cartas.");
             System.out.println("5. Ver las cartas repartidas");
             System.out.println("6. Ver mazo");
             System.out.println("7. Salir");
            
             int option = read.nextInt();
             
             switch(option){
                 case 1: 
                     barajar();
                 break;
                 case 2: 
                     siguienteCarta();
                     break;
                 case 3: 
                     cartasDisponibles();
                     break;
                 case 4: 
                     darCartas();
                     break;
                 case 5: 
                     cartasMonton();
                     break;
                 case 6: 
                     mostrarBaraja();
                     break;
                 case 7: 
                     System.out.println("Esta seguro que desea salir? ");
                    String confirm = read.next();
                 if(confirm.equals("SI")|| confirm.equals("si")){
                     salir = true;
                     break;
                 }
                    break;
                default:
                    System.out.println("La opcion debe ser entre 1 y 7");
                     salir=true;
                     break;
                 
                     
             }
        } while (salir==false);
        System.out.println("Hasta la proxima.");
    }
        
    }
    

