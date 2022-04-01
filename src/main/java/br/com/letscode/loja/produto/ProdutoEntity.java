package br.com.letscode.loja.produto;

import br.com.letscode.loja.fabricante.FabricanteEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "PRODUTO")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoEntity {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_produto")
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

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProdutoStatus status;


    @ManyToOne
    @JoinColumn(name = "ID_FABRICANTE")
    private FabricanteEntity fabricante;


    @Column(name = "PESO")
    private Integer peso;

    @Column(name = "PESO_UNIDADE_MEDIDA")
    private String pesoUnidadeMedida;

    @Column(name = "DATA_CRIACAO")
    private ZonedDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    private ZonedDateTime dataAtualizacao;

    public ProdutoEntity(String nome, String descricao, BigDecimal valor, String codigoBarra, FabricanteEntity fabricante, Integer peso, String pesoUnidadeMedida) {

        this.codigo = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.codigoBarra = codigoBarra;
        this.status = ProdutoStatus.ATIVO;
        this.fabricante = fabricante;
        this.peso = peso;
        this.pesoUnidadeMedida = pesoUnidadeMedida;
        this.dataCriacao = ZonedDateTime.now();
        this.dataAtualizacao = ZonedDateTime.now();
    }
}
