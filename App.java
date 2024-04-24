import java.util.Scanner;
public class App {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    // Mostramos el nombre del juego
    System.out.println("SPRAC");

    // Pedimos al usuario que introduzca la cantidad de dinero que quiere apostar
    System.out.print("¿Cuánto dinero quiere apostar? ");
    int apuesta = sc.nextInt();


    // Comprobamos que la apuesta sea positiva
    if (apuesta <= 0) {
      System.out.println("La apuesta debe ser mayor que cero.");
      return; // Terminamos el programa
    }

    // Generamos la tirada aleatoria de los tres dados
    int dado1 = (int) (Math.random() * 6) + 1; // Número aleatorio entre 1 y 6
    int dado2 = (int) (Math.random() * 6) + 1; // Número aleatorio entre 1 y 6
    int dado3 = (int) (Math.random() * 6) + 1; // Número aleatorio entre 1 y 6

    // Mostramos el resultado de los dados
    System.out.println("Dado 1: " + dado1);
    System.out.println("Dado 2: " + dado2);
    System.out.println("Dado 3: " + dado3);

    // Calculamos la suma de los dados
    int suma = dado1 + dado2 + dado3;

    // Mostramos la suma
    System.out.println("Suma: " + suma);

    // Comprobamos si el jugador ha ganado o perdido en la primera etapa
    if (suma == 12 || suma == 15 || suma == 18) {
      // El jugador ha ganado el doble de la cantidad que apostó
      System.out.println("¡Enhorabuena! ¡Ha ganado " + (apuesta * 2) + " €!");
      return; // Terminamos el programa
    } else if (suma == 3 || suma == 6 || suma == 9) {
      // El jugador ha perdido todo su dinero
      System.out.println("¡Lo siento, ha perdido los " + apuesta + " €!");
      return; // Terminamos el programa
    } else {
      // El juego entra en una segunda etapa
      System.out.println("Tiene que seguir tirando, debe conseguir sumar " + suma + " para ganar.");
      System.out.println("Si obtiene un 12, perderá la partida.");

      // Creamos una variable booleana para controlar el bucle
      boolean seguir = true;

      // Repetimos el proceso hasta que el jugador gane o pierda
      while (seguir) {
        // Pedimos al usuario que pulse INTRO para tirar los dados
        System.out.print("Pulse INTRO para tirar los dados.");
        sc.nextLine(); // Leemos la entrada del usuario

        // Generamos la tirada aleatoria de los tres dados
        dado1 = (int) (Math.random() * 6) + 1; 
        dado2 = (int) (Math.random() * 6) + 1; 
        dado3 = (int) (Math.random() * 6) + 1; 

        // Mostramos el resultado de los dados
        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);
        System.out.println("Dado 3: " + dado3);

        // Calculamos la suma de los dados
        int nuevaSuma = dado1 + dado2 + dado3;

        // Mostramos la suma
        System.out.println("Suma: " + nuevaSuma);

        // Comprobamos si el jugador ha ganado o perdido en la segunda etapa
        if (nuevaSuma == suma) {
          // El jugador ha ganado el doble de la cantidad que apostó
          System.out.println("¡Enhorabuena! ¡Ha ganado " + (apuesta * 2) + " €!");
          seguir = false; // Salimos del bucle
        } else if (nuevaSuma == 12) {
          // El jugador ha perdido todo su dinero
          System.out.println("¡Lo siento, ha perdido los " + apuesta + " €!");
          seguir = false; // Salimos del bucle
        } else {
          // El jugador tiene que seguir tirando
          System.out.println("Continúe jugando.");
        }
      }
    }
}
}
