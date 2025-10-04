package ps2.tsua_aplicacao_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ps2.tsua_aplicacao_app.dao.ClienteDAO;
import ps2.tsua_aplicacao_app.dao.ProdutoDAO;
import ps2.tsua_aplicacao_app.repo.ClienteRepo;
import ps2.tsua_aplicacao_app.repo.ProdutoRepo;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class TsuaAplicacaoAppApplication implements CommandLineRunner {

    private final ClienteRepo clienteRepo;
    private final ProdutoRepo produtoRepo;

    public TsuaAplicacaoAppApplication(ClienteRepo clienteRepo, ProdutoRepo produtoRepo) {
        this.clienteRepo = clienteRepo;
        this.produtoRepo = produtoRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(TsuaAplicacaoAppApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("(1) Gerenciar Clientes");
            System.out.println("(2) Gerenciar Produtos");
            System.out.println("(0) Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> menuClientes(sc);
                case 2 -> menuProdutos(sc);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // ---------- MENU CLIENTES ----------
    private void menuClientes(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- CLIENTES ---");
            System.out.println("(1) Listar todos");
            System.out.println("(2) Buscar por nome");
            System.out.println("(3) Criar novo");
            System.out.println("(4) Alterar");
            System.out.println("(5) Apagar por ID");
            System.out.println("(0) Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> clienteRepo.findAll().forEach(c ->
                        System.out.println(c.getId() + " - " + c.getNome() + " (" + c.getEmail() + ")"));
                case 2 -> {
                    System.out.print("Digite parte do nome: ");
                    String nome = sc.nextLine();
                    clienteRepo.findByNomeContaining(nome)
                            .forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
                }
                case 3 -> {
                    ClienteDAO novo = new ClienteDAO();
                    System.out.print("Nome: ");
                    novo.setNome(sc.nextLine());
                    System.out.print("Email: ");
                    novo.setEmail(sc.nextLine());
                    clienteRepo.save(novo);
                    System.out.println("Cliente criado!");
                }
                case 4 -> {
                    System.out.print("ID para alterar: ");
                    Long idAlt = sc.nextLong();
                    sc.nextLine();
                    Optional<ClienteDAO> opt = clienteRepo.findById(idAlt);
                    if (opt.isPresent()) {
                        ClienteDAO c = opt.get();
                        System.out.print("Novo nome (" + c.getNome() + "): ");
                        c.setNome(sc.nextLine());
                        System.out.print("Novo email (" + c.getEmail() + "): ");
                        c.setEmail(sc.nextLine());
                        clienteRepo.save(c);
                        System.out.println("Alterado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("ID para apagar: ");
                    Long idDel = sc.nextLong();
                    sc.nextLine();
                    clienteRepo.deleteById(idDel);
                    System.out.println("Apagado!");
                }
            }
        } while (opcao != 0);
    }

    // ---------- MENU PRODUTOS ----------
    private void menuProdutos(Scanner sc) {
        int opcao;
        do {
            System.out.println("\n--- PRODUTOS ---");
            System.out.println("(1) Listar todos");
            System.out.println("(2) Buscar por nome");
            System.out.println("(3) Criar novo");
            System.out.println("(4) Alterar");
            System.out.println("(5) Apagar por ID");
            System.out.println("(0) Voltar");
            System.out.print("Escolha: ");
