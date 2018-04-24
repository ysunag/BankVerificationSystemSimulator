package edu.neu.ccs.cs5004.component.transaction;

/**
 * Represents the deposit action.
 */
public class Deposit implements Action {
  public static final Deposit INSTANCE = new Deposit();

  /**
   * Getter for the deposit instance.
   * @return the deposit instance.
   */
  public static Deposit getInstance() {
    return INSTANCE;
  }

}
