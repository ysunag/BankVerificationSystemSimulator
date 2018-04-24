package edu.neu.ccs.cs5004.component.bank;

import edu.neu.ccs.cs5004.component.msgsignature.MsgDigiPairI;

/**
 * Represents the process of verifying the received transaction message.
 */
public interface RsaSigVerificationI {
  /**
   * Verifies whether the given signature and message pair is valid using the public key stored
   * in the bank.
   * @param bank the bank storing the public key.
   * @param pair the message and signature pair to verify
   * @return true if the given signature and message pair is valid, false otherwise
   */
  boolean verifyMsg(BankI bank, MsgDigiPairI pair);
}
