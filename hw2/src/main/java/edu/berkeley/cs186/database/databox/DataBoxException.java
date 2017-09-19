package edu.berkeley.cs186.database.databox;

public class DataBoxException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public DataBoxException() {
    super();
  }

  public DataBoxException(String message) {
    super(message);
  }
}
