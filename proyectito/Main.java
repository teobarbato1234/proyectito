import java.util.*; // Importa List y ArrayList (colecciones)

interface Rastreable {          // Declara la interfaz: un "contrato"
    void rastrear();            // Método sin cuerpo que toda clase que la implemente debe definir
}                                // Fin de la interfaz

abstract class Transporte implements Rastreable { // Clase base abstracta, implementa Rastreable
    String patente;                                // Atributo común a todos los transportes

    abstract void calcularCosto(double km);         // Método abstracto: cada subclase lo define distinto
}                                                    // Fin de la clase Transporte

class Terrestre extends Transporte {                        // Terrestre HEREDA de Transporte
    void calcularCosto(double km) {                          // Implementación propia del método abstracto
        System.out.println("Terrestre: $" + km * 15);        // Calcula e imprime el costo ($15 por km)
    }                                                         // Fin del método calcularCosto
    public void rastrear() {                                 // Implementación propia de rastrear() (de la interfaz)
        System.out.println("Rastreo GPS");                   // Imprime el tipo de rastreo terrestre
    }                                                         // Fin del método rastrear
}                                                             // Fin de la clase Terrestre

class Aereo extends Transporte {                             // Aereo también HEREDA de Transporte
    void calcularCosto(double km) {                          // Misma firma que en Terrestre, distinta lógica
        System.out.println("Aéreo: $" + km * 40);            // Calcula e imprime el costo ($40 por km)
    }                                                         // Fin del método calcularCosto
    public void rastrear() {                                 // Otra implementación distinta de rastrear()
        System.out.println("Rastreo transponder");           // Imprime el tipo de rastreo aéreo
    }                                                         // Fin del método rastrear
}                                                             // Fin de la clase Aereo

public class Main {                                          // Clase principal (debe llamarse igual que el archivo: Main.java)
    public static void main(String[] args) {                 // Punto de entrada del programa
        List<Transporte> flota = new ArrayList<>();           // Lista de tipo Transporte (clase base)
        flota.add(new Terrestre());                            // Agrega un objeto Terrestre a la lista
        flota.add(new Aereo());                                // Agrega un objeto Aereo a la lista
        for (Transporte t : flota) {                           // Recorre la lista; "t" es de tipo Transporte
            t.calcularCosto(100);                              // POLIMORFISMO: ejecuta la versión según el objeto real
            t.rastrear();                                      // POLIMORFISMO: ídem con rastrear()
        }                                                       // Fin del for
    }                                                           // Fin del main
}                                                               // Fin de la clase Main