import model.Assento;
import model.AssentoEconomica;

public class App{
    public static void main(String[] args){
        Assento a1 = new AssentoEconomica(classe:"Economica", precoBase:50.0);
        System.out.println("Valor Assento "+ a1.calcularPrecoFinal());
        
        Assento a2= new AssentoExecutiva("Economica", 50.0);
        System.out.println("Valor do Assento:"+ a2.calcularPrecoFinal());
        
        Passageiro p1 = new Passaqgeiro(nome:"Carlos");
        System.out.println(x"compraado assento na classe economica");
        p1.setAssento(a1);
        
        System.out.println("O assento do passageiro ["p1.getNome()+] custa [R$"]")
    }
}