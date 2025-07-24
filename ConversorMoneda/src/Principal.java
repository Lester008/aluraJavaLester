import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("Sea bienvenido(a) al Conversor de Moneda");
        String primerMenu = """
                ***Acontinuacion, te compartimos los valores para el tipo de moneda validos:***
                USD ==> Dolar
                MXN ==> Peso Mexicano
                BRL ==> Real Brasileño
                ARS ==> Peso Argentino
                COP ==> Peso Colombiano
                EUR ==> Euro
                CHF ==> Franco Suizo
                GBP ==> Libra Esterlina
                ******************************************************************************
                """;
        System.out.println(primerMenu);

        try {
            System.out.println("Coloca tu moneda base:");
            var primerValor = teclado.nextLine();

            System.out.println("Coloca tu moneda destino:");
            var segundoValor = teclado.nextLine();

            System.out.println("Coloca la cantidad a convertir:");
            var cantidad = teclado.nextLine();
            Moneda moneda = consulta.haceConversion(primerValor, segundoValor, Double.parseDouble(cantidad));
            System.out.println(moneda);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicacion.");
        }

    }
}
