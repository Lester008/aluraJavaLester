public class Aprovacion {
    public static void main(String[] args){
        double calificacion = 10;

        if (calificacion > 6.9){
            System.out.println("El estudiante tuvo un promedio de " + calificacion + " y fue aprobado");
        }
        else if (calificacion > 4.9) {
            System.out.println("El estudiante tuvo un promedio de " + calificacion + " y esta en recuperación");
        }
        else {
            System.out.println("El estudiante tuvo un promedio de " + calificacion + " y fue reprobado");
        }
    }
}
