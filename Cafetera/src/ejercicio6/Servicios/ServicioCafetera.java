
package ejercicio6.Servicios;
import java.util.Scanner;
import ejercicio6.Cafetera;

public class ServicioCafetera {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");   
  Cafetera CA1 = new Cafetera();
  boolean salir = false;
  
  public void funcionCafetera(){
      
      CA1.setCapacidadMaxima(1000);
      CA1.setCantidadActual(1000);
      
      funcionamiento();
      
  }
  
  public double llenarCafetera(){
      
      
      if (CA1.getCapacidadMaxima() == 1000 && CA1.getCantidadActual() == 1000){
          System.out.println("La cafetera no puede sumar mas contenido");
      } else {
          CA1.setCantidadActual(1000);
      }
      return CA1.getCantidadActual();
  }
  
  public double servirTaza(){
      
      int volTaza;
      System.out.println("Cuantos cm3 tiene la taza que utilizará?");
      volTaza = scan.nextInt();
      if (CA1.getCantidadActual()>= volTaza){
          CA1.setCantidadActual(CA1.getCantidadActual() - volTaza);
          System.out.println("La taza se lleno de cafe");
      } else {
          System.out.println("No se alcanzo a llenar la taza. Solo se lleno hasta " + CA1.getCantidadActual() + " cm3 ");
          CA1.setCantidadActual(0);
      }
      return CA1.getCantidadActual();
  }
  
  public double vaciarCafetera(){
      
      System.out.println("La cafetera fue vaciada.");
      CA1.setCantidadActual(0);
      
      return CA1.getCantidadActual();
  }
  
  public double agregarCafe(){
      
      int cantCafe;
      System.out.println("Cuantos cm3 de cafe va a agregar a la cafetera?");
      cantCafe = scan.nextInt();
      if (CA1.getCantidadActual() == 1000){
          System.out.println("La cafetera esta llena, no se puede agregar mas contenido");
      } else if(CA1.getCantidadActual() + cantCafe >= 1000){
          System.out.println("La cafetera fue llenada");
          CA1.setCantidadActual(1000);
      } else{
          CA1.setCantidadActual(CA1.getCantidadActual() + cantCafe);
      }
      return CA1.getCantidadActual();
  }
  
  public void funcionamiento(){
      
      do{
         
         int eleccion;
         System.out.println("---------NESPRESSO----------");
         System.out.println("Elija el tipo de accion que desea realizar con la cafetera");
         System.out.println("1: Llenar la cafetera ");
         System.out.println("2: Servir una taza");
         System.out.println("3: Vaciar la cafetera");
         System.out.println("4: Agregar una cierta cantidad de cafe");
         System.out.println("5: Dejar de usar la cafetera");
         eleccion = scan.nextInt();
         
         switch(eleccion){
             
             case 1:
                 System.out.println("La cafetera esta llena con: " + llenarCafetera() + " cm3. ");
                 break;
             case 2:
                 System.out.println("La capacidad actual de la  cafetera es: " + servirTaza() + "  cm3." );
                 break;
             case 3:
                 System.out.println("La cantidad de cafe que tiene la cafetera es de: " + vaciarCafetera() + " cm3.");
                 break;
             case 4:
                 System.out.println("Ahora la cafetera cuenta con "  + agregarCafe() + " cm3.");
                 break;
             case 5:
                 System.out.println(" Esta seguro que desea salir?:  (S/N)");
                 String confirm = scan.next();
                 if(confirm.equals("S")|| confirm.equals("s")){
                     salir = true;
                     break;
                 }
         }
         
     } while ( salir == false);
     System.out.println("Esperamos haya disfrutado del cafe");
             
         
     
  }
  
}
