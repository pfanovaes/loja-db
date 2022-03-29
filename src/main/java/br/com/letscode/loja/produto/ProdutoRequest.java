package br.com.letscode.loja.produto;

import javax.persistence.Entity;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity(name = "PRODUTO")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class ProdutoRequest {

    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String codigoBarra;
    private String status;
    private Long idFabricante;
    private Integer peso;
    private String pesoUnidadeMedida;

    public ProdutoEntity toEntity() {
        return new ProdutoEntity(
                this.getNome(),
                this.getDescricao(),
                this.getValor(),
                this.getCodigoBarra(),
                this.getIdFabricante(),
                this.getPeso(),
                this.getPesoUnidadeMedida()
                );

    }


}