package br.com.letscode.loja.produto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
