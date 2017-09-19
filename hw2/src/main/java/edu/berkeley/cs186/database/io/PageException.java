package edu.berkeley.cs186.database.io;

/**
 * Exception thrown for errors while paging.
 *
 * YOU SHOULD NOT NEED TO CHANGE ANY OF THE CODE IN THIS PACKAGE.
 */
public class PageException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public PageException() {
    super();
  }

  public PageException(String message) {
    super(message);
  }
}

