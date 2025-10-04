package ps2.tsua_aplicacao_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ps2.tsua_aplicacao_app.dao.ProdutoDAO;

import java.util.List;

public interface ProdutoRepo extends JpaRepository<ProdutoDAO, Long> {
    List<ProdutoDAO> findByNomeContaining(String nome);
}
