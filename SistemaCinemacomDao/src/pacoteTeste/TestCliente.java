package pacoteTeste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author DANIEL
 */
public class TestCliente {
    
    public TestCliente() {
    }

    @Test
    public void testaConstrutorPadrao(){
        Cliente c = new Cliente();
        Assert.assertEquals(" ",c.getNome());
        Assert.assertEquals(" ",c.getEndereco());
        Assert.assertEquals(" ",c.getTelefone());
    }
    @Test
    public void testaConstrutorNaoPadrao(){
        Cliente c1 = new Cliente("José","Roma","3425-4536");
        Assert.assertEquals("José", c1.getNome());
        Assert.assertEquals("Roma", c1.getEndereco());
        Assert.assertEquals("3425-4536",c1.getTelefone());
    }
    @Test
    public void testaSetters(){
        Cliente c2 = new Cliente();
        String nome, endereco, telefone;
        nome = "Nome";
        endereco = "Endereco";
        telefone = "1111-2222";
        c2.setNome(nome);
        c2.setEndereco(endereco);
        c2.setTelefone(telefone);
        Assert.assertEquals(nome, c2.getNome());
        Assert.assertEquals(endereco, c2.getEndereco());
        Assert.assertEquals(telefone, c2.getTelefone());
    }
}
