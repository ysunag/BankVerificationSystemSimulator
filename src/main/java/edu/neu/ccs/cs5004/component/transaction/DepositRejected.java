package edu.neu.ccs.cs5004.component.transaction;

public class DepositRejected implements TransactionStatusI{

  public static DepositRejected instance;

  public static DepositRejected getInstance() {
    if (instance == null) {
      instance = new DepositRejected();
    }
    return instance;
  }

  @Override
  public String toString() {
    return "deposit rejected";
  }
}
