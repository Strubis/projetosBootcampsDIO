package com.padroesprojeto.aplicacaopadroes.controller;



import com.padroesprojeto.aplicacaopadroes.model.Shopping;
import com.padroesprojeto.aplicacaopadroes.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author EmersonPC
 */

@RestController
@RequestMapping( "shoppings" )
public class ShoppingRestController {
    
    // injeção de dependência
    @Autowired
    private ShoppingService shoppingService;
    
    @GetMapping
    public ResponseEntity<Iterable<Shopping>> buscarTodos(){
        return ResponseEntity.ok( shoppingService.buscarTodos() );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Shopping> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok( shoppingService.buscarPorId( id ) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirShopping(@PathVariable Long id){
        shoppingService.excluirShopping( id );
        
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    public ResponseEntity<Shopping> inserirShopping(@RequestBody Shopping shopping){
        shoppingService.inserirShopping( shopping );
        
        return ResponseEntity.ok( shopping );
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Shopping> atualizarShopping(@PathVariable Long id, @RequestBody Shopping shopping){
        shoppingService.atualizarShopping( id, shopping );
        
        return ResponseEntity.ok(shopping);
    }
}
