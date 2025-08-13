public record Moneda(String base_code ,String target_code, double conversion_rate, double conversion_result) {

    @Override
    public String toString(){
        return "Moneda base: " + base_code + "\n" +
                "Moneda destino: " + target_code + "\n" +
                "Valor moneda base: " + conversion_rate + "\n" +
                "Valor final: " + conversion_result;
    }
}
