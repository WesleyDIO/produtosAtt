package api.produtos.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Positive;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false, columnDefinition = "int default 1")
    @Positive
    private Integer estoque;
    @Column(nullable = false)
    private Date validade;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String codigo_barra;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Double medida;
    @Column(nullable = false)
    private String fabricante;
    @Column(nullable = false)
    private String categoria;


}
