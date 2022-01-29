package com.padroesprojeto.aplicacaopadroes.service.impl;

import com.padroesprojeto.aplicacaopadroes.model.Endereco;
import com.padroesprojeto.aplicacaopadroes.model.EnderecoRepository;
import com.padroesprojeto.aplicacaopadroes.model.Shopping;
import com.padroesprojeto.aplicacaopadroes.model.ShoppingRepository;
import com.padroesprojeto.aplicacaopadroes.service.ShoppingService;
import com.padroesprojeto.aplicacaopadroes.service.ViaCepService;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação da <b>Strategy</b> {@link ShoppingService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author EmersonPC
 */

@Service
public class ShoppingServiceImpl implements ShoppingService{
    
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ShoppingRepository shoppingRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;
    
    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    
    @Override
    public Iterable<Shopping> buscarTodos() {
        return shoppingRepository.findAll();
    }

    @Override
    public Shopping buscarPorId(Long id) {
        // Outra forma de fazer
        //Optional<Shopping> shopping = shoppingRepository.findById( id );
        //return shopping.get();
        
        return shoppingRepository.findById( id ).get();
    }

    @Override
    public void excluirShopping(Long id) {
        shoppingRepository.deleteById( id );
    }

    @Override
    public void inserirShopping(Shopping shopping) {
        salvarShopping( shopping );
    }

    @Override
    public void atualizarShopping(Long id, Shopping shopping) {
        Optional<Shopping> shoOptional = shoppingRepository.findById( id );
        
        if( shoOptional.isPresent() )
            salvarShopping( shopping );
    }
    
    public void salvarShopping(Shopping shopping){
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
	String cep = shopping.getEndereco().getCep();
               
	Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            
            return novoEndereco;
        });
		
        shopping.setEndereco(endereco);
        
	// Inserir Cliente, vinculando o Endereco (novo ou existente).
	shoppingRepository.save(shopping);
    }
    
}
