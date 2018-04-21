package edu.neu.ccs.cs5004.component.transaction;

public class WithdrawalAccepted implements TransactionStatusI {
  public static WithdrawalAccepted instance;

  public static WithdrawalAccepted getInstance() {
    if (instance == null) {
      instance = new WithdrawalAccepted();
    }
    return instance;
  }
  @Override
  public String toString() {
    return "withdrawal accepted";
  }
}
