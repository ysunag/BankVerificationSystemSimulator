package edu.neu.ccs.cs5004.component.transaction;

public interface TransactionStatusI {

  static TransactionStatusI generateTransactionStatus(Action action, boolean approved) {
    if(action.equals(Deposit.INSTANCE) && approved) {
      return DepositAccepted.getInstance();
    } else if(action.equals(Deposit.INSTANCE) && !approved) {
      return DepositRejected.getInstance();
    } else if (action.equals(Withdrawal.INSTANCE) && approved) {
      return WithdrawalAccepted.getInstance();
    } else {
      return WithdrawalRejected.getInstance();
    }
  }
}
