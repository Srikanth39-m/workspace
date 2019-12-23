package com.nextClick;

import org.testng.annotations.Test;

import com.main.nextClick.MainTest;

public class NextClickLaunch extends MainTest {
  @Test
  public void f() throws InterruptedException {
	 nextClickLaunch();
	 Thread.sleep(4000);
	 MasterDataCategoryAdd();
	  
	  
  
  }
}
