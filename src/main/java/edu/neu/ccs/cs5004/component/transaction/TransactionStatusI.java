package edu.neu.ccs.cs5004.component.transaction;

/**
 * Represents the transaction status.
 */
public interface TransactionStatusI {

  /**
   * Generates the transaction status with the given action and whether the transaction is approved.
   * @param action the given transaction action
   * @param approved whether the transaction is approved
   * @return deposit approved if the deposit request is approved, deposit rejected if the deposit
   *        is rejected, withdrawal approved if the withdrawal request is approved and withdrawal
   *        rejected if the withdrawal is rejected
   */
  static TransactionStatusI generateTransactionStatus(Action action, boolean approved) {
    if (action.equals(Deposit.INSTANCE) && approved) {
      return DepositAccepted.getInstance();
    } else if (action.equals(Deposit.INSTANCE) && !approved) {
      return DepositRejected.getInstance();
    } else if (action.equals(Withdrawal.INSTANCE) && approved) {
      return WithdrawalAccepted.getInstance();
    } else {
      return WithdrawalRejected.getInstance();
    }
  }
}
