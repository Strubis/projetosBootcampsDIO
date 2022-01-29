package com.padroesprojeto.aplicacaopadroes.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author EmersonPC
 */

@Data
@Entity
public class Shopping implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private int qtdLojas;
    
    // Franquias dos shoppings
    @ManyToOne
    private Endereco endereco;
    
}
