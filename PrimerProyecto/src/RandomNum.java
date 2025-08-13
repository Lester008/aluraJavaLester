import javax.xml.transform.Source;
import java.util.Scanner;
import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random numRandom = new Random();
        int number = numRandom.nextInt(100);
        int numberUser = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Coloca un numero entre 0 y 100");
            numberUser = teclado.nextInt();
            System.out.println("Este era el numero " + number);
            if (numberUser == number){
                System.out.println("Felicidades, adivinaste el numero");
                break;
            }
        }
    }
}
