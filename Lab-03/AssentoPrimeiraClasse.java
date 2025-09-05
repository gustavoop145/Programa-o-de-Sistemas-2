class AssentoPrimeiraClasse extends Assento {
    public AssentoPrimeiraClasse() {
        super("Primeira Classe", 1500.00);
    }
    public double calcularPrecoFinal() {
        return precoBase * 1.5;
    }
}
