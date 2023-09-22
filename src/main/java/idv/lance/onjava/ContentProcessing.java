package idv.lance.onjava;

import java.util.UUID;

interface Content {
  String getId();

  boolean isIdExist();
}

class File implements Content {
  @Override
  public String getId() {
	return UUID.randomUUID().toString();
  }

  public boolean isIdExist() {
	return getId() != null;
  }
}

interface ContentIdValidator {
  boolean validate(Content content);
}

public class ContentProcessing {

  public static void main(String[] args) {
	ContentIdValidator validator = Content::isIdExist;
	boolean validate = validator.validate(new File());
	System.out.println(validate);
  }
}
