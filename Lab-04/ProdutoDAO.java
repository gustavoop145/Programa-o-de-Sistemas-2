import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ProdutoDAO {
    private static final Path arquivo = Paths.get("produtos.txt");

    public List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            if (!Files.exists(arquivo)) return produtos; // se não existe retorna lista vazia
            List<String> linhas = Files.readAllLines(arquivo);
            for (String linha : linhas) {
                String[] c = linha.split(";");
                Produto p = new Produto(c[0], Double.parseDouble(c[1]), c[2]);
                produtos.add(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }
        return produtos;
    }

    public void salvarProdutos(List<Produto> produtos) {
        List<String> linhas = new ArrayList<>();
        for (Produto p : produtos) {
            linhas.add(p.getDescricao() + ";" + p.getPreco() + ";" + p.getMarca());
        }
        try {
            Files.write(arquivo, linhas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }
}
