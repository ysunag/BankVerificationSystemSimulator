package edu.neu.ccs.cs5004.problem1.component.transaction;

/**
 * Represents the deposit accepted status.
 */
public class DepositAccepted implements TransactionStatusI{

  public static final DepositAccepted INSTANCE = new DepositAccepted();

  /**
   * Getter for the deposit accepted status instance.
   * @return the deposit accepted status instance
   */
  public static DepositAccepted getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "deposit accepted";
  }
}
