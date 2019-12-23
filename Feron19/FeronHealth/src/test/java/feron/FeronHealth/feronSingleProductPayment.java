package feron.FeronHealth;

import org.testng.annotations.Test;

public class feronSingleProductPayment extends MainTest {
  @Test
  public void f() throws InterruptedException {
	  feronlogin();
	  feronPaymentSinglePrdct();	  
  }
}
