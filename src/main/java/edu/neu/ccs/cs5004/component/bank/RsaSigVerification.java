package edu.neu.ccs.cs5004.component.bank;

import java.math.BigInteger;

import edu.neu.ccs.cs5004.component.msgSig.MsgDigiPairI;
import edu.neu.ccs.cs5004.component.msgSig.RsaKey;

public class RsaSigVerification implements RsaSigVerificationI {

  public boolean verifyMsg(BankI bank, MsgDigiPairI pair) {
    RsaKey currentKey = bank.getPublicKeys().get(pair.getClientId());
    int decryptedMsg = BigInteger.valueOf(pair.getSignature().getVal()).modPow(
            currentKey.getFirst(), currentKey.getSecond()).intValue();
    return decryptedMsg == pair.getMessage().getVal();
  }
}
