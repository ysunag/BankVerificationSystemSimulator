package edu.neu.ccs.cs5004.simulator;


import edu.neu.ccs.cs5004.component.bank.BankI;
import edu.neu.ccs.cs5004.component.transaction.Action;
import edu.neu.ccs.cs5004.component.transaction.Deposit;
import edu.neu.ccs.cs5004.component.transaction.Withdrawal;
import edu.neu.ccs.cs5004.component.client.ClientId;
import edu.neu.ccs.cs5004.component.msgSig.MessageI;

public class TransactionStatusDetermination implements TransactionStatusDeterminationI {

  private BankI bank;

  public TransactionStatusDetermination(BankI bank) {
    this.bank = bank;
  }

  public boolean verifyTransaction(MessageI msg, ClientId client) {
    Action action = Action.generateAction(msg);
    int amount = msg.getVal() / 10;
    if((action.equals(new Deposit()) && bank.getDepositLimits().get(client) >= amount)
            || (action.equals(new Withdrawal())
            && bank.getWithdrawlLimits().get(client) >= amount)) {
      return true;
    } else {
      return false;
    }
  }
}
