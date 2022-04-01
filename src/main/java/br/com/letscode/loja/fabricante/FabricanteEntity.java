package br.com.letscode.loja.fabricante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "FABRICANTE")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FabricanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fabricante_seq")
    @SequenceGenerator(name = "fabricante_seq", sequenceName = "fabricante_seq")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_CRIACAO")
    private String dataCriacao;

    @Column(name = "DATA_ALTERACAO")
    private String dataAlteracao;
}
