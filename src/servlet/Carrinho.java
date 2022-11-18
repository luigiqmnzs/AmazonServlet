package servlet;

import java.util.HashMap;

import model.Produto;

public class Carrinho {
	HashMap<Integer, Produto> itensCarrinho;
    public Carrinho(){
    itensCarrinho = new HashMap<>();
      
    }
    public HashMap<Integer, Produto> getItensCarrinho(){
        return itensCarrinho;
    }
    public void colocarNoCarrinho(int codigo, Produto p){
    	itensCarrinho.put(codigo, p);
    }
    public void deletarDoCarrinho(int codigo){
        itensCarrinho.remove(codigo);
    }
}
