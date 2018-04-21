package edu.neu.ccs.cs5004.component.transaction;

public interface TransactionStatusI {

  static TransactionStatusI generateTransactionStatus(Action action, boolean approved) {
    if(action.equals(new Deposit()) && approved) {
      return DepositAccepted.getInstance();
    } else if(action.equals(new Deposit()) && !approved) {
      return DepositRejected.getInstance();
    } else if (action.equals(new Withdrawal()) && approved) {
      return WithdrawalAccepted.getInstance();
    } else {
      return WithdrawalRejected.getInstance();
    }
  }
}
