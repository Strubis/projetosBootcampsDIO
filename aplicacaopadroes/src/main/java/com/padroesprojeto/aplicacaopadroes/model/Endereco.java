/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.padroesprojeto.aplicacaopadroes.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * Os dados de endereço serão consumidos via API - Via CEP
 *
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 * @author EmersonPC
 */
@Data
@Entity
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

}
