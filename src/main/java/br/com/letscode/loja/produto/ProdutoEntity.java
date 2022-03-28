package br.com.letscode.loja.produto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "PRODUTO")
@Data
@AllArgsConstructor

public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CODIGO")
    private UUID codigo;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "CODIGO_BARRA")
    private String codigoBarra;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ID_FABRICANTE")
    private Long idFabricante;

    @Column(name = "PESO")
    private Integer peso;

    @Column(name = "PESO_UNIDADE_MEDIDA")
    private String pesoUnidadeMedida;

    @Column(name = "DATA_CRIACAO")
    private ZonedDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    private ZonedDateTime dataAtualizacao;
}
