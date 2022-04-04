package br.com.letscode.loja.produto;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("produtos")
@RestController
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<Page<ProdutoEntity>> get(
        @RequestParam(name = "offset", required = true) Integer offset,
        @RequestParam(name = "limit", required = true) Integer limit

    ){

        Page<ProdutoEntity> produtos = produtoService.buscarTodos(offset, limit);
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> create(@RequestBody ProdutoRequest request) {

        ProdutoEntity produto = produtoService.criar(request);
        return ResponseEntity.created(null).body(produto);
    }

    @GetMapping("/codigo")
    public ResponseEntity<ProdutoEntity> getByCodigoBarra(
            @RequestParam("codigo") String codigoBarra) {

        ProdutoEntity produto = produtoService.buscarPorCodigoBarra(codigoBarra);
        return ResponseEntity.ok(produto);
    }

}
