package edu.neu.ccs.cs5004.component.transaction;

public class WithdrawalRejected implements TransactionStatusI{

  public static WithdrawalRejected instance;

  public static WithdrawalRejected getInstance() {
    if (instance == null) {
      instance = new WithdrawalRejected();
    }
    return instance;
  }

  @Override
  public String toString() {
    return "withdrawal rejected";
  }
}
