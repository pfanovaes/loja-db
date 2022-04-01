package br.com.letscode.loja.produto;

import br.com.letscode.loja.fabricante.FabricanteEntity;
import br.com.letscode.loja.fabricante.FabricanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private FabricanteRepository fabricanteRepository;

    public List<ProdutoEntity> buscarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoEntity criar(ProdutoRequest produtoRequest) {
        Optional<FabricanteEntity> fabricanteEntity = fabricanteRepository.findById(produtoRequest.getIdFabricante());
        ProdutoEntity produtoEntity = toEntity(produtoRequest, fabricanteEntity.get());
        return produtoRepository.save(produtoEntity);
    }

/*    public ProdutoEntity atualizar(Long id, ProdutoRequest produtoRequest) {

        Optional<ProdutoEntity> optprodutoEntity = produtoRepository.findById(id);
        ProdutoEntity produtoEntity = optprodutoEntity.get();

        produtoEntity.setValor(produtoEntity.getValor());

        return produtoRepository.save(toEntity(produtoRequest));
    }*/

    private ProdutoEntity toEntity(ProdutoRequest produtoRequest, FabricanteEntity fabricante) {
        return new ProdutoEntity(
                produtoRequest.getNome(),
                produtoRequest.getDescricao(),
                produtoRequest.getValor(),
                produtoRequest.getCodigoBarra(),
                fabricante,
                produtoRequest.getPeso(),
                produtoRequest.getPesoUnidadeMedida()
        );

    }
}
