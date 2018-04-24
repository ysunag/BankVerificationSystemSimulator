package edu.neu.ccs.cs5004.problem1.component.bank;

import edu.neu.ccs.cs5004.problem1.component.msgsignature.MsgDigiPairI;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.RsaKey;

import java.math.BigInteger;


/**
 * Represents the process of verifying the received transaction message.
 */

public class RsaSigVerification implements RsaSigVerificationI {

  @Override
  public boolean verifyMsg(BankI bank, MsgDigiPairI pair) {
    RsaKey currentKey = bank.getPublicKeys().get(pair.getClientId());
    int decryptedMsg = BigInteger.valueOf(pair.getSignature().getVal()).modPow(
            BigInteger.valueOf(currentKey.getFirst()), BigInteger.valueOf(
                    currentKey.getSecond())).intValue();
    return decryptedMsg == pair.getMessage().getVal();
  }
}
