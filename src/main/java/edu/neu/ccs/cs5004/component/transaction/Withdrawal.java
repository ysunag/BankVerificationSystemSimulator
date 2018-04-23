package edu.neu.ccs.cs5004.component.transaction;

public class Withdrawal implements Action {
  public static final Withdrawal INSTANCE= new Withdrawal();

  public static Withdrawal getInstance() {
    return INSTANCE;
  }
}
