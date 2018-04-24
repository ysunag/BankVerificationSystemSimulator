package edu.neu.ccs.cs5004.component.transaction;

/**
 * Represents the deposit rejected status.
 */
public class DepositRejected implements TransactionStatusI{

  public static final DepositRejected INSTANCE = new DepositRejected();

  /**
   * Getter for the deposit rejected status instance.
   * @return the deposit rejected status instance
   */
  public static DepositRejected getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "deposit rejected";
  }
}
