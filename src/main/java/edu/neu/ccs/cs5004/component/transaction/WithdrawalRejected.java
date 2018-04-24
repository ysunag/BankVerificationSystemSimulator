package edu.neu.ccs.cs5004.component.transaction;


/**
 * Represents the withdrawal rejected status.
 */
public class WithdrawalRejected implements TransactionStatusI{

  public static final WithdrawalRejected INSTANCE = new WithdrawalRejected();

  /**
   * Getter for the withdrawal rejected status instance.
   * @return the withdrawal rejected status instance
   */
  public static WithdrawalRejected getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "withdrawal rejected";
  }
}
