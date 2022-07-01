
package com.mycompany.reservas.servicios;

import com.mycompany.reservas.entidades.Persona;
import com.mycompany.reservas.entidades.Sala;
import java.util.ArrayList;
import java.util.Scanner;


public  class ServicioReserva {
    
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Persona> personas = new ArrayList();
    ArrayList<Sala> salas = new ArrayList();
   
  
    
    public String Reserva(){
        
       
        String respuesta = "";        
        do{
            Persona P1 = new Persona();
            System.out.println("Indique el nombre de quien realiza la reserva: ");
            P1.setNombre(scan.next());
            System.out.println("Indique el apellido de quien realiza la reserva: ");
            P1.setApellido(scan.next());
            System.out.println("Indique el DNI de quien realiza la reserva: ");
            P1.setDni(scan.nextInt());
            
            personas.add(P1);
            
            Sala S1 = new Sala();
            
            int tipo;
            boolean salir1 = false;
            do{
            System.out.println("Que tipo de sala desea reservar?: ");
            System.out.println("Presione 1 para la sala chica.");
            System.out.println("Presione 2 para la sala mediana.");
            System.out.println("Presione 3 para la sala grande.");
            System.out.println("Presione 4 para volver al menu.");
            tipo = scan.nextInt();
            switch(tipo){
                case 1:
                    S1.setTipo("Sala chica");
                    salir1 = true;
                break;
                
                case 2:
                    S1.setTipo("Sala mediana");
                    salir1 = true;
                break;
                
                case 3:
                    S1.setTipo("Sala grande");
                    salir1 = true;
                break;
                
                case 4:
                    Menu();
                    
                break;
                
                default:
                    System.out.println("El valor ingresado fue incorrecto, intente nuevamente.");
                    System.out.println(" ");
            }
            }while(salir1 == false);
            
            
            int dia;
            boolean salir2 = false;
            do{
            System.out.println("Que dia desea reservar?: ");
            System.out.println("Presione 1 para Lunes.");
            System.out.println("Presione 2 para Martes.");
            System.out.println("Presione 3 para Miercoles.");
            System.out.println("Presione 4 para Jueves.");
            System.out.println("Presione 5 para Viernes.");
            System.out.println("Presione 6 para volver al menu.");
            dia = scan.nextInt();
            switch(dia){
                case 1:
                    S1.setDia("Lunes");
                    salir2 = true;
                break;
                
                case 2:
                    S1.setDia("Martes");
                    salir2 = true;
                break;
                
                case 3:
                    S1.setDia("Miercoles");
                    salir2 = true;
                break;
                
                case 4:
                    S1.setDia("Jueves");
                    salir2 = true;
                break;
                
                case 5:
                    S1.setDia("Viernes");
                    salir2 = true;
                break;
                
                case 6:
                    Menu();
                    
                break;
                
                default:
                    System.out.println("El valor ingresado fue incorrecto, intente nuevamente");
                    System.out.println(" ");
            }
             }while(salir2 == false);
        
             int horas;
             boolean salir3 = false;
             do{
                
            System.out.println("Cuantas horas desea reservar la sala?: ");
            System.out.println("Presione 1 para reservar turno mañana de 10hs a 13hs.");
            System.out.println("Presione 2 para reservar turno tarde de 17hs a 19hs.");
            System.out.println("Presione 3 para reservar turno noche de 21hs a 22hs.");
            System.out.println("Presione 4 para volver al menu.");
            horas = scan.nextInt();
            switch(horas){
                case 1:
                    S1.setTurno("De 10hs a 13hs");
                   
                    salir3 = true;
                break;
                
                case 2:
                    S1.setTurno("De 17hs a 19hs");
                    
                    salir3 = true;
                break;
                
                case 3:
                    S1.setTurno("De 21hs a 22hs");
                    
                    salir3 = true;
                break;
                    
                case 4:
                    Menu();
                    
                break;
                
                default:
                    System.out.println("El valor ingresado fue incorrecto, intente nuevamente");
                    System.out.println(" ");
            }
             
            }while(salir3 == false);
             
             salas.add(S1);
             P1.setSala(S1);
            System.out.println("Desea realizar otra reserva? Si/No... ");
            respuesta = scan.next();
            System.out.println(" ");
        } while(respuesta.equalsIgnoreCase("SI"));
        
        return "Reserva realizada con exito.";
    }   
    
    
    
    public void MostrarReserva(){
        System.out.println(" ");
        System.out.println("Las reservas realizadas son: ");
        System.out.println(" ");
        personas.forEach((e)->System.out.println(e));
        System.out.println(" ");
        
    }
    
    
    public void EliminarReserva(){
        
        int documento;
        System.out.println("Escriba su numero de documento para eliminar su reserva: ");
        documento = scan.nextInt();
        
        for(int i = 0; i < personas.size(); i++){
            if(personas.get(i).getDni().equals(documento)){
                personas.remove(i);
                System.out.println(" ");
                System.out.println("Reserva eliminada con exito.");
                System.out.println(" ");
            }else{
                System.out.println("Numero de documento sin reserva asignada.");
                break;
            }
    }
    
    }
    
    
    
    public void Menu(){
        
        boolean salir = false;

        do {

            int eleccion;
            System.out.println("---------MENU RESERVA SALA DE CONFERENCIAS----------");
            System.out.println("Elija el tipo de accion que desea realizar");
            System.out.println("1: Ver los tipos de salas de conferencias. ");
            System.out.println("2: Ver los turnos disponibles de reserva.");
            System.out.println("3: Ver las fechas disponibles de reserva");
            System.out.println("4: Realizar reserva.");
            System.out.println("5: Eliminar reserva.");
            System.out.println("6: Mostrar las reservas realizadas.");
            System.out.println("7: Salir del menu.");
            
            eleccion = scan.nextInt();

            switch (eleccion) {

                case 1:
                    System.out.println("Los tipos de salas son: ");
                    System.out.println(" ");
                    System.out.println("Sala chica, con capacidad de hasta 25 personas");
                    System.out.println("Sala mediana, con capacidad de hasta 50 personas");
                    System.out.println("Sala grande, con capacidad de hasta 100 personas");
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.println("La disponibilidad horaria es: ");
                    System.out.println(" ");
                    System.out.println("Hay disponibilidad de 10hs a 13hs, en el turno mañana");
                    System.out.println("Hay disponibilidad de 17hs a 19hs, en el turno tarde");
                    System.out.println("Hay disponibilidad de 21hs a 22hs, en el turno noche");
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("Las fechas disponibles de reserva son: Lunes a viernes, de 10hs a 22hs.");
                    System.out.println(" ");
                    break;
                case 4:
                    Reserva();
                    break;
                case 5:
                    EliminarReserva();
                    break;
                case 6:
                    MostrarReserva();
                    break;
                case 7:
                    System.out.println(" Esta seguro que desea salir?:  (S/N)");
                    String confirm = scan.next();
                    if (confirm.equals("S") || confirm.equals("s")) {
                        salir = true;
                        break;
                    }
                    break;
                
            }

        } while (salir == false);
        System.out.println("Hasta la proxima.");
        
        
    }
    
   
    
}
