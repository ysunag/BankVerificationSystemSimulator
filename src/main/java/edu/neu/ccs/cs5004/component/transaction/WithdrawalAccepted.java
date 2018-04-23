package edu.neu.ccs.cs5004.component.transaction;

public class WithdrawalAccepted implements TransactionStatusI {
  public static final WithdrawalAccepted INSTANCE = new WithdrawalAccepted();

  public static WithdrawalAccepted getInstance() {
    return INSTANCE;
  }
  @Override
  public String toString() {
    return "withdrawal accepted";
  }
}
