import java.util.Scanner;
public class Evaluaciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota = 0;
        double mediaEvaluacion = 0;
        double totalEvaluacion = 0;

        while (nota != -1 ){
            System.out.println("Escribe la nota que le darias a l pelicula Matrix");
            nota = teclado.nextDouble();
            // Aqui se le dice que la primer variabla vale lo mismo de ella + la variable nota
            if(nota != -1){
                mediaEvaluacion += nota;
                totalEvaluacion++;
            }
        }
        System.out.println("La media de evaluaciones para Matrix es: " + mediaEvaluacion / totalEvaluacion);
    }
}
