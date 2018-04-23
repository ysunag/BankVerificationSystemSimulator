package edu.neu.ccs.cs5004.component.transaction;

public class DepositAccepted implements TransactionStatusI{

  public static final DepositAccepted INSTANCE = new DepositAccepted();

  public static DepositAccepted getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "deposit accepted";
  }
}
