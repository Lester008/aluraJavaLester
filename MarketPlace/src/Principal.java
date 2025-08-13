import javax.xml.transform.Source;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("***********************************************************************");
        System.out.println("\nPor favor coloca el limite de tu tarjeta:");
        double limite = teclado.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        while(salir != 0){
            System.out.println("Coloca la descripcion del producto:");
            String description = teclado.next();

            System.out.println("Ingresa el valor del producto:");
            double  purchaseValue = teclado.nextDouble();

            Compra compra = new Compra(purchaseValue, description);
            boolean compraRealizada = tarjeta.makePurchase(compra);

            if (compraRealizada){
                System.out.println("Compra realizada");
                System.out.println("Escribe 0 para salir o 1 para continuar");
                salir = teclado.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                salir = 0;
            }
        }
        System.out.println("**************************************************************************************");
        System.out.println("Compras realizadas:\n");
        Collections.sort(tarjeta.getListaDeCompras());

        for (Compra compra : tarjeta.getListaDeCompras()){
            System.out.println(compra.getDescription() + " - " + compra.getPurchaseValue());
        }
        System.out.println("\n************************************************************************************");
        System.out.println("\nTu saldo actual es: " + tarjeta.getSaldo());
    }
}
