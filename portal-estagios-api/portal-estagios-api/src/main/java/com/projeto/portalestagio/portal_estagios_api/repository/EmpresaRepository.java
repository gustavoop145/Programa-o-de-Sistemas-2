package com.projeto.portalestagio.portal_estagios_api.repository;

import com.projeto.portalestagio.portal_estagios_api.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
