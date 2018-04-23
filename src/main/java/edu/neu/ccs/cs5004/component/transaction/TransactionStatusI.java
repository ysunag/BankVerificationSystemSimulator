package edu.neu.ccs.cs5004.component.transaction;

public interface TransactionStatusI {

  static TransactionStatusI generateTransactionStatus(Action action, boolean approved) {
    if(action.equals(Deposit.instance) && approved) {
      return DepositAccepted.getInstance();
    } else if(action.equals(Deposit.instance) && !approved) {
      return DepositRejected.getInstance();
    } else if (action.equals(Withdrawal.instance) && approved) {
      return WithdrawalAccepted.getInstance();
    } else {
      return WithdrawalRejected.getInstance();
    }
  }
}
