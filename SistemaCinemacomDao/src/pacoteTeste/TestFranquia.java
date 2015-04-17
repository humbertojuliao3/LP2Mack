package pacoteTeste;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import 

/**
 *
 * @author DANIEL
 */
public class TestFranquia {
    
    public TestFranquia() {
    }
    @Test
    public void testaConstrutorPadrao(){
        Franquia f1 = new Franquia();
        Assert.assertEquals(" ",f1.getNome());
        Assert.assertEquals(" ",f1.getEndereco());        
    }
    @Test
    public void testaConstrutorNaoPadrao(){
        Franquia f1 = new Franquia("Nome","Joaquim Floriano");
        Assert.assertEquals("Nome", f1.getNome());
        Assert.assertEquals("Joaquim Floriano", f1.gteEndereco());        
    }
    @Test
    public void testaClasse(){
        Franquia f1 = new Franquia();
        f1.setNome("Nome");
        Assert.assertEquals("Nome",f1.getNome());
        f1.setEndereco("Joaquim Floriano");
        Assert.assertEquals("Joaquim Floriano",f1.getEndereco());
    }
}
