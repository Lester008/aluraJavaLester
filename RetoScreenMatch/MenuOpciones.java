import java.util.Scanner;
public class MenuOpciones {
    public static void main(String[] args) {
        int respuesta = 0;
        String name = "Tony Stark";
        String tipoCuenta = "Corriente";
        double saldo = 1599.99;

        System.out.println("***********************************");
        System.out.println("\n Nombre del Cliente: " + name);
        System.out.println("El tipo de cuenta es: " + tipoCuenta);
        System.out.println("Su saldo disponible es: $" + saldo);
        System.out.println("\n ***********************************");


       String menu = """
               *** Presiona el numero de la opcion deseasa ***
               1 - Consulta tu saldo
               2 - Retirar efectivo
               3 - Depositar a tu cuenta
               9 - Salir
               """;

        Scanner teclado = new Scanner(System.in);
       while (respuesta != 9){
           System.out.println(menu);
           respuesta = teclado.nextInt();

           switch (respuesta){
               case 1:
                   System.out.println("Tu saldo es: $" + saldo);
                   break;
               case 2:
                   System.out.println("¿Cual es el monto que desea retirar?");
                   double montoRetiro = teclado.nextDouble();
                   if (saldo < montoRetiro){
                       System.out.println("Saldo insuficiente");
                   }
                   else {
                       saldo = saldo - montoRetiro;
                       System.out.println("Tu nuevo saldo es: $" + saldo);
                   }
                   break;
               case 3:
                   System.out.println("¿Cual es el monto a depositar?");
                   double deposito = teclado.nextDouble();
                   saldo += deposito; //saldo igual a saldo mas el deposito
                   System.out.println("Tu nuevo saldo es: $" + saldo);
                   break;
               case 9:
                   System.out.println("Gracias por su preferencia, vuelva pronto");
                   break;
               default:
                   System.out.println("Esa opcion no es valida");
           }
       }
    }
}



/*

El reto consiste en construir una app bancaria en la que tiene que mostrar los siguientes datos:
nombre
tipo de cuenta
salgo

Despues tiene que tener un menu de opciones con las siguientes:

1 - Consulta tu saldo
2 - Retirar efectivo
3 - Depositar a tu cuenta
9 - Salir








 */