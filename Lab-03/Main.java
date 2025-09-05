public class SistemaReserva {
    public static void main(String[] args) {
        Assento economica = new AssentoEconomica();
        Assento executiva = new AssentoExecutiva();
        Assento primeiraClasse = new AssentoPrimeiraClasse();

        System.out.printf("Assento %s: R$ %.2f%n", economica.classe, economica.calcularPrecoFinal());
        System.out.printf("Assento %s: R$ %.2f%n", executiva.classe, executiva.calcularPrecoFinal());
        System.out.printf("Assento %s: R$ %.2f%n", primeiraClasse.classe, primeiraClasse.calcularPrecoFinal());
    }
}
