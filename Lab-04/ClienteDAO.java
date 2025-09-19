import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ClienteDAO {
    private static final Path arquivo = Paths.get("clientes.txt");

    public List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            if (!Files.exists(arquivo)) return clientes;
            List<String> linhas = Files.readAllLines(arquivo);
            for (String linha : linhas) {
                String[] c = linha.split(";");
                Cliente cli = new Cliente(c[0], c[1], c[2]);
                clientes.add(cli);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public void salvarClientes(List<Cliente> clientes) {
        List<String> linhas = new ArrayList<>();
        for (Cliente c : clientes) {
            linhas.add(c.getNome() + ";" + c.getCpf() + ";" + c.getEmail());
        }
        try {
            Files.write(arquivo, linhas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }
}
