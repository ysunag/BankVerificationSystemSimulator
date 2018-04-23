package edu.neu.ccs.cs5004.component.transaction;

public class WithdrawalRejected implements TransactionStatusI{

  public static final WithdrawalRejected INSTANCE = new WithdrawalRejected();

  public static WithdrawalRejected getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "withdrawal rejected";
  }
}
