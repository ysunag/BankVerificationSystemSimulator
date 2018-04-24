package edu.neu.ccs.cs5004.problem1.simulator;


import edu.neu.ccs.cs5004.problem1.component.bank.BankI;
import edu.neu.ccs.cs5004.problem1.component.client.ClientId;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.MessageI;
import edu.neu.ccs.cs5004.problem1.component.transaction.Action;
import edu.neu.ccs.cs5004.problem1.component.transaction.Deposit;
import edu.neu.ccs.cs5004.problem1.component.transaction.Withdrawal;



/**
 * Represents the process of determining whether the transaction request amount is allowed.
 */
public class TransactionStatusDetermination implements TransactionStatusDeterminationI {

  private BankI bank;

  /**
   * Creates a new transaction status determination process with the given bank.
   * @param bank the given bank
   */
  public TransactionStatusDetermination(BankI bank) {
    this.bank = bank;
  }

  @Override
  public boolean verifyTransaction(MessageI msg, ClientId client) {
    Action action = Action.generateAction(msg);
    int amount = msg.getVal() / 10;
    if ((action.equals(Deposit.INSTANCE) && bank.getDepositLimits().get(client) >= amount)
            || (action.equals(Withdrawal.INSTANCE)
            && bank.getWithdrawlLimits().get(client) >= amount)) {
      return true;
    } else {
      return false;
    }

  }
}
