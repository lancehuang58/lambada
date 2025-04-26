package idv.lance.onjava;

import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamToSysout {
  public static void main(String[] args) throws IOException {
	try (InputStream is = FileInputStreamToSysout.class.getResourceAsStream("/Cheese.dat")) {
	  if (is != null) {
		//is to sysout
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
	  }
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }
}
