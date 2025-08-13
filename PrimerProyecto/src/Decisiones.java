public class Decisiones {

    public static void main(String[] args) {
        int fechaLanzamiento = 1999;
        boolean incluidoEnPlan = true;
        double notaPelicula = 8.2;
        String tipoPlan = "Plus";

        if (fechaLanzamiento >= 2022) {
            System.out.println("Peliculas mas populares");
        }else {
            System.out.println("Peliculas retro que aun vale la pena ver");
        }

        if (incluidoEnPlan || tipoPlan.equals("Plus")){
            System.out.println("Disfrute de su pelicula");
        }else{
            System.out.println("Pelicula no disponible para su plan actual");
        }
    }
}
