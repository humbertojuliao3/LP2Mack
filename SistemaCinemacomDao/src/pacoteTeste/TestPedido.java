package pacoteTeste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANIEL
 */
public class TestPedido {
    
    public TestPedido() {
    }
  @Test
  public void testaConstrutorPadrao(){
      Pedido p = new Pedido();
      Assert.assertEquals(1, p.getNumeroPedido());
      Assert.assertNull(p.getItem());
  }
  @Test
  public void testaQuantidadeDeItem(){
      Pedido p = new Pedido();
      p.addItem();
      Assert.assertEquals(1, p.qtdItem);
  }
  @Test
  public void testaNumeroPedido(){
      Pedido p = new Pedido();
      p.setItem("Coca-cola");
      Assert.assertEquals("Coca-cola", p.getItem());
  }
}
