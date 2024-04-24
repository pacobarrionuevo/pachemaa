public class TresOMás {

  public static void main(String[] args) {
    System.out.println("TRES O MÁS");
    /* Definimos el bucle. Se juegan 10 rondas sí o sí, entonces
     * hay que definir un bucle que controle el numero de rondas.
     */
    int turnos;
    int puntosJugador1Total = 0;
    int puntosJugador2Total = 0;
    for (turnos = 1; turnos <= 10; turnos++) {
      //Defino esta variable para contar cuantos puntos tiene cada jugador
      // en cada ronda. Se reinicia en cada iteración
      int puntosJugador1RondaI = 0;
      int puntosJugador2RondaI = 0;
      /* Estos arrays los usamos para almacenar la cantidad de cada
       * número que puede salir en cada dado.
       * Esto nos servirá para saber cuántos puntos se lleva cada jugador.
       */
      int[] numerosJugador1 = new int[6];
      int[] numerosJugador2 = new int[6];
      for (int i = 0; i < 6; i++) {
        //No estoy seguro de si mi código me devolverá este array a 0.
        //Así me aseguro.
        numerosJugador1[i] = 0;
        numerosJugador2[i] = 0;
      }
      //Empieza el turno del jugador 1.
      System.out.print("Tirada " + turnos + " del jugador 1: ");
      int[] tiradaJugador1 = new int[5];
      for (int i = 0; i < 5; i++) {
        tiradaJugador1[i] = (int) (Math.random() * 6) + 1;
        /* Esto hace que, dependiendo del número que salga en la tirada,
         * se añada la cantidad de ese número que hay en el array.
         */
        if (tiradaJugador1[i] == 1) {
          numerosJugador1[0] += 1;
        } else if (tiradaJugador1[i] == 2) {
          numerosJugador1[1] += 1;
        } else if (tiradaJugador1[i] == 3) {
          numerosJugador1[2] += 1;
        } else if (tiradaJugador1[i] == 4) {
          numerosJugador1[3] += 1;
        } else if (tiradaJugador1[i] == 5) {
          numerosJugador1[4] += 1;
        } else if (tiradaJugador1[i] == 6) {
          numerosJugador1[5] += 1;
        }
        //Estas líneas imprimen qué ha salido en cada tirada.
        if (i != 4) {
          System.out.print(tiradaJugador1[i] + "-");
        } else {
          System.out.print(tiradaJugador1[i] + " ;");
        }
      }
      //Ahora, tenemos que contar el número de puntos obtenidos y luego mostrarlos
      //Definimos el booleano que nos activa la opción "Tirada extra"
      boolean tiradaExtra = false;
      for (int i = 0; i < 6; i++) {
        if (numerosJugador1[i] == 2) {
          puntosJugador1RondaI = 0;
          tiradaExtra = true;
        }
        if (numerosJugador1[i] == 3) {
          puntosJugador1RondaI = 3;
        }
        if (numerosJugador1[i] == 4) {
          puntosJugador1RondaI = 6;
        }
        if (numerosJugador1[i] == 5) {
          puntosJugador1RondaI = 12;
        }
      }
      //Si no se activa la opción tirada extra, no se mete en este if
      //Si está activada, se repite todo el proceso hasta que se sumen puntos
      if (!tiradaExtra) {
        System.out.print(puntosJugador1RondaI + " puntos");
      } else {
        System.out.print(puntosJugador1RondaI + " puntos; Tirada Extra");
        //Activamos la condición que nos permite salir del else.
        boolean salirTiradaExtra = false;
        while (!salirTiradaExtra) {
          //Repetimos todo el proceso de tirada.
          numerosJugador1 = new int[6];
          for (int i = 0; i < 6; i++) {
            numerosJugador1[i] = 0;
          }
          System.out.println("");
          System.out.print("Tirada " + turnos + " del jugador 1: ");
          tiradaJugador1 = new int[5];
          for (int i = 0; i < 5; i++) {
            tiradaJugador1[i] = (int) (Math.random() * 6) + 1;
            if (tiradaJugador1[i] == 1) {
              numerosJugador1[0] += 1;
            } else if (tiradaJugador1[i] == 2) {
              numerosJugador1[1] += 1;
            } else if (tiradaJugador1[i] == 3) {
              numerosJugador1[2] += 1;
            } else if (tiradaJugador1[i] == 4) {
              numerosJugador1[3] += 1;
            } else if (tiradaJugador1[i] == 5) {
              numerosJugador1[4] += 1;
            } else if (tiradaJugador1[i] == 6) {
              numerosJugador1[5] += 1;
            }
            if (i != 4) {
              System.out.print(tiradaJugador1[i] + "-");
            } else {
              System.out.print(tiradaJugador1[i] + " ;");
            }
          }
          //Me di cuenta tarde de que tenía que salir del bucle siempre que no saliera
          //que hay algún valor que se repita dos veces, así que es un poco una solución de emergencia
          boolean salir = false;
          for (int i = 0; i < 6; i++) {
            if (numerosJugador1[i] == 0 || numerosJugador1[i] == 1) {
              puntosJugador1RondaI = 0;
              salir = true;
            }
            if (numerosJugador1[i] == 2) {
              puntosJugador1RondaI = 0;
            }
            if (numerosJugador1[i] == 3) {
              puntosJugador1RondaI = 3;
              salir = true;
            }
            if (numerosJugador1[i] == 4) {
              puntosJugador1RondaI = 6;
              salir = true;
            }
            if (numerosJugador1[i] == 5) {
              puntosJugador1RondaI = 12;
              salir = true;
            }
            if (numerosJugador1[i] == 3) {
              puntosJugador1RondaI = 3;
              salir = true;
            }
          }
          if (salir) {
            salirTiradaExtra = true;
          } else {
            salirTiradaExtra = false;
          }
          if (salirTiradaExtra) {
            System.out.print(puntosJugador1RondaI + " puntos; ");
          } else {
            System.out.print(puntosJugador1RondaI + " puntos;Tirada Extra");
          }
        }
      }
      puntosJugador1Total += puntosJugador1RondaI;
      //Ahora que se ha sumado todo, pasamos al jugador 2.
      System.out.println("");
      System.out.print("Tirada " + turnos + " del jugador 2: ");
      int[] tiradaJugador2 = new int[5];
      for (int i = 0; i < 5; i++) {
        tiradaJugador2[i] = (int) (Math.random() * 6) + 1;
        if (tiradaJugador2[i] == 1) {
          numerosJugador2[0] += 1;
        } else if (tiradaJugador2[i] == 2) {
          numerosJugador2[1] += 1;
        } else if (tiradaJugador2[i] == 3) {
          numerosJugador2[2] += 1;
        } else if (tiradaJugador2[i] == 4) {
          numerosJugador2[3] += 1;
        } else if (tiradaJugador2[i] == 5) {
          numerosJugador2[4] += 1;
        } else if (tiradaJugador2[i] == 6) {
          numerosJugador2[5] += 1;
        }
        if (i != 4) {
          System.out.print(tiradaJugador2[i] + "-");
        } else {
          System.out.print(tiradaJugador2[i] + " ;");
        }
      }
      tiradaExtra = false;
      for (int i = 0; i < 6; i++) {
        if (numerosJugador2[i] == 2) {
          puntosJugador2RondaI = 0;
          tiradaExtra = true;
        }
        if (numerosJugador2[i] == 3) {
          puntosJugador2RondaI = 3;
        }
        if (numerosJugador2[i] == 4) {
          puntosJugador2RondaI = 6;
        }
        if (numerosJugador2[i] == 5) {
          puntosJugador2RondaI = 12;
        }
      }
      if (!tiradaExtra) {
        System.out.print(puntosJugador2RondaI + " puntos");
      } else {
        System.out.print(puntosJugador2RondaI + " puntos; Tirada Extra");
        //Activamos la condición que nos permite salir del else.
        boolean salirTiradaExtra = false;
        while (!salirTiradaExtra) {
          //Repetimos todo el proceso de tirada.
          numerosJugador2 = new int[6];
          for (int i = 0; i < 6; i++) {
            numerosJugador2[i] = 0;
          }
          System.out.println("");
          System.out.print("Tirada " + turnos + " del jugador 2: ");
          tiradaJugador2 = new int[5];
          for (int i = 0; i < 5; i++) {
            tiradaJugador2[i] = (int) (Math.random() * 6) + 1;
            if (tiradaJugador2[i] == 1) {
              numerosJugador2[0] += 1;
            } else if (tiradaJugador2[i] == 2) {
              numerosJugador2[1] += 1;
            } else if (tiradaJugador2[i] == 3) {
              numerosJugador2[2] += 1;
            } else if (tiradaJugador2[i] == 4) {
              numerosJugador2[3] += 1;
            } else if (tiradaJugador2[i] == 5) {
              numerosJugador2[4] += 1;
            } else if (tiradaJugador2[i] == 6) {
              numerosJugador2[5] += 1;
            }
            if (i != 4) {
              System.out.print(tiradaJugador2[i] + "-");
            } else {
              System.out.print(tiradaJugador2[i] + " ;");
            }
          }
          boolean salir = false;
          for (int i = 0; i < 6; i++) {
            if (numerosJugador2[i] == 0 || numerosJugador2[i] == 1) {
              puntosJugador2RondaI = 0;
              salir = true;
            }
            if (numerosJugador2[i] == 2) {
              puntosJugador2RondaI = 0;
            }
            if (numerosJugador2[i] == 3) {
              puntosJugador2RondaI = 3;
              salir = true;
            }
            if (numerosJugador2[i] == 4) {
              puntosJugador2RondaI = 6;
              salir = true;
            }
            if (numerosJugador2[i] == 5) {
              puntosJugador1RondaI = 12;
              salir = true;
            }
            if (numerosJugador2[i] == 3) {
              puntosJugador2RondaI = 3;
              salir = true;
            }
          }
          // Ya sé que me podría haber ahorrado un booleano, pero me estaba dando errores
          // y he preferido asegurar.
          if (salir) {
            salirTiradaExtra = true;
          } else {
            salirTiradaExtra = false;
          }
          if (salirTiradaExtra) {
            System.out.print(puntosJugador2RondaI + " puntos; ");
          } else {
            System.out.print(puntosJugador2RondaI + " puntos;Tirada Extra");
          }
        }
      }
      puntosJugador2Total += puntosJugador2RondaI;
      System.out.println("");
      System.out.print(
        "Fin de ronda " + turnos + ". Jugador 1 -" + puntosJugador1Total
      );
      System.out.println(" ; Jugador 2 - " + puntosJugador2Total);
      System.out.println("");
    }
    System.out.println("\n" + puntosJugador1Total + " " + puntosJugador2Total);
    if (puntosJugador1Total > puntosJugador2Total) {
      System.out.println(
        "¡Gana el jugador 1 con " + puntosJugador1Total + " puntos!"
      );
    } else {
      System.out.println(
        "¡Gana el jugador 2 con " + puntosJugador2Total + " puntos!"
      );
    }
    if (puntosJugador1Total == puntosJugador2Total) {
      System.out.println("¡Empate!");
    }
  }
}
