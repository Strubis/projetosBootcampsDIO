package com.padroesprojeto.aplicacaopadroes.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EmersonPC
 */

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{
    
}
