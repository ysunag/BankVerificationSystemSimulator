package edu.neu.ccs.cs5004.component.transaction;

public class Withdrawal implements Action {
  public static Withdrawal instance;

  public static Withdrawal getInstance() {
    if (instance == null) {
      instance = new Withdrawal();
    }
    return instance;
  }
}
