package com.nextClick;

import java.io.IOException;

import org.testng.annotations.Test;

public class gettingNamesFromImages {
  @Test
  public void ImageData() throws IOException {
	  MainTest tc=new MainTest();
	  tc.browserChrome();
	  tc.gettingProductNamesFromImages();
	  
  }
}
