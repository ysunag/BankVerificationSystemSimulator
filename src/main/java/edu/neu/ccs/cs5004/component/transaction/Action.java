package edu.neu.ccs.cs5004.component.transaction;

import edu.neu.ccs.cs5004.component.msgSig.MessageI;

public interface Action {
  int DEPOSITBound = 4;
  static Action generateAction(MessageI msg) {
    int last = msg.getVal() / 10;
    if (last <= DEPOSITBound) {
      return Deposit.getInstance();
    } else {
      return Withdrawal.getInstance();
    }
  }
}
