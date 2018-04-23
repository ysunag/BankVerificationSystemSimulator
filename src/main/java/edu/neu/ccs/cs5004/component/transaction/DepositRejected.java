package edu.neu.ccs.cs5004.component.transaction;

public class DepositRejected implements TransactionStatusI{

  public static final DepositRejected INSTANCE = new DepositRejected();

  public static DepositRejected getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "deposit rejected";
  }
}
