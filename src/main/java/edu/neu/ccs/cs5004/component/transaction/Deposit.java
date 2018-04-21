package edu.neu.ccs.cs5004.component.transaction;

public class Deposit implements Action {
  public static Deposit instance;

  public static Deposit getInstance() {
    if (instance == null) {
      instance = new Deposit();
    }
    return instance;
  }

}
