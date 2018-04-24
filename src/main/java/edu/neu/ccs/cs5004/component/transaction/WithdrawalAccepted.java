package edu.neu.ccs.cs5004.component.transaction;


/**
 * Represents the withdrawal accepted status.
 */
public class WithdrawalAccepted implements TransactionStatusI {
  public static final WithdrawalAccepted INSTANCE = new WithdrawalAccepted();

  /**
   * Getter for the withdrawal accepted status instance.
   * @return the withdrawal accepted status instance
   */
  public static WithdrawalAccepted getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "withdrawal accepted";
  }
}
