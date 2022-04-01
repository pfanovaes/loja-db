package br.com.letscode.loja.fabricante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<FabricanteEntity, Long> {
}
