import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el primer lado:");
        int firstSide = userInput.nextInt();

        System.out.println("Ingrese el segundo lado:");
        int secondSide = userInput.nextInt();

        System.out.println("Ingrese el tercer lado:");
        int thirdSide = userInput.nextInt();

        if (firstSide + secondSide > thirdSide && firstSide + thirdSide > secondSide && secondSide + thirdSide > firstSide){
            System.out.println("Los lados pueden formar un triangulo");
        } else {
            System.out.println("Los lados no pueden formar un triangulo");
        }
    }
}
