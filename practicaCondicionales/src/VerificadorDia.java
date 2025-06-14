import java.util.Scanner;

public class VerificadorDia {
    public static void main(String[] args){
        String userDay = "";

        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el día de la semana (solo letras minusculas)");
        userDay = userInput.nextLine();

        if(userDay.equals("sabado") || userDay.equals("domingo")){
            System.out.println("El día " + userDay + " es día inhábil" );
        } else {
            System.out.println("El día " + userDay + " es día hábil");
        }
    }}
