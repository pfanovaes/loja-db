package br.com.letscode.loja.produto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> buscarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoEntity criar(ProdutoRequest produtoRequest) {
        ProdutoEntity produtoEntity = produtoRequest.toEntity();
        return produtoRepository.save(produtoEntity);
    }

    public ProdutoEntity atualizar(Long id, ProdutoRequest produtoRequest) {

        Optional<ProdutoEntity> optprodutoEntity = produtoRepository.findById(id);
        ProdutoEntity produtoEntity = optprodutoEntity.get();

        produtoEntity.setValor(produtoEntity.getValor());

        return produtoRepository.save(produtoEntity);
    }
}
