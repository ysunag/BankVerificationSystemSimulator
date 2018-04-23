package edu.neu.ccs.cs5004.component.transaction;

public class Deposit implements Action {
  public static final Deposit INSTANCE = new Deposit();

  public static Deposit getInstance() {
    return INSTANCE;
  }

}
