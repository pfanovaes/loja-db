package br.com.letscode.loja.produto;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("produtos")
@RestController
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<ProdutoEntity>> get(

    ){

        List<ProdutoEntity> produtos = produtoService.buscarTodos();

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> create(@RequestBody ProdutoRequest request) {

        ProdutoEntity produto = produtoService.criar(request);
        return ResponseEntity.created(null).body(produto);
    }


}
