package edu.neu.ccs.cs5004.simulator.processMsgSig;

import edu.neu.ccs.cs5004.component.bank.BankI;
import edu.neu.ccs.cs5004.component.msgSig.MsgDigiPairI;

public interface RsaSigVerificationI {
  boolean verifyMsg(BankI bank, MsgDigiPairI pair);
}
