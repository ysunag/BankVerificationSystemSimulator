package edu.neu.ccs.cs5004.component.transaction;

public class DepositAccepted implements TransactionStatusI{

  public static DepositAccepted instance;

  public static DepositAccepted getInstance() {
    if (instance == null) {
      instance = new DepositAccepted();
    }
    return instance;
  }

  @Override
  public String toString() {
    return "deposit accepted";
  }
}
