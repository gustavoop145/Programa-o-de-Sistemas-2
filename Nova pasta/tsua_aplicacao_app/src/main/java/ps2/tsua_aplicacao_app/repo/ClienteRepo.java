package ps2.tsua_aplicacao_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ps2.tsua_aplicacao_app.dao.ClienteDAO;

import java.util.List;

public interface ClienteRepo extends JpaRepository<ClienteDAO, Long> {
    List<ClienteDAO> findByNomeContaining(String nome);
}
