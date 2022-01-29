package com.padroesprojeto.aplicacaopadroes.service;

import com.padroesprojeto.aplicacaopadroes.model.Shopping;



/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author EmersonPC
 */
public interface ShoppingService {
    
    Iterable<Shopping> buscarTodos();
    
    Shopping buscarPorId(Long id);
    
    void excluirShopping(Long id);
    
    void inserirShopping(Shopping shopping);
    
    void atualizarShopping(Long id, Shopping shopping);
}
