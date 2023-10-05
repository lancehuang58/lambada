package idv.lance.onjava;

import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamToSysout {
  public static void main(String[] args) throws IOException {
	try (InputStream is = FileInputStreamToSysout.class.getResourceAsStream("/Cheese.dat")) {
	  if (is != null) {
		is.transferTo(System.out);
	  }
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }
}
