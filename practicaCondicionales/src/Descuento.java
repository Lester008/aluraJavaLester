import java.util.Scanner;

public class Descuento {
    public static void main(String[] args){
        double valuePurchase = 0;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Ingrese el valor de la compra: ");
        valuePurchase = userInput.nextDouble();

        if (valuePurchase > 99.99){
            double discount = valuePurchase * 0.10;
            double finalValue = valuePurchase - discount;
            System.out.println("Descuento del 10% aplicado. \nNuevo valor: $" + finalValue);
        } else {
            System.out.println("Descuento no aplicado. \nValor total: $" + valuePurchase);
        }
    }
}
