package edu.neu.ccs.cs5004.problem1.component.transaction;

/**
 * Represents the withdrawal action.
 */
public class Withdrawal implements Action {
  public static final Withdrawal INSTANCE = new Withdrawal();

  /**
   * Getter for the withdrawal instance.
   * @return the withdrawal instance.
   */
  public static Withdrawal getInstance() {
    return INSTANCE;
  }
}
