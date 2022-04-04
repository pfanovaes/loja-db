package br.com.letscode.loja.produto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long> {

    @Query(value = "SELECT * FROM PRODUTO WHERE codigo_barra = ?1", nativeQuery = true)
    ProdutoEntity findByCodigoBarra(String codigoBarra);

}
