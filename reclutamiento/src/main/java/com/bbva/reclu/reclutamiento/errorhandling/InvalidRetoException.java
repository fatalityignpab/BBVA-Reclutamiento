package com.bbva.reclu.reclutamiento.errorhandling;


public class InvalidRetoException extends RuntimeException {

  private static final long serialVersionUID = -4957281189808005732L;

  public InvalidRetoException() {
    super();
  }

  public InvalidRetoException(String message) {
      super(message);
    }
    
}