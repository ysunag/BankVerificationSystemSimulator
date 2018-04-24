package edu.neu.ccs.cs5004.problem1.component.client;

import edu.neu.ccs.cs5004.problem1.component.msgsignature.DigiSig;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.DigiSigI;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.MessageI;


import java.math.BigInteger;


/**
 * Represents the process of generating digital signature.
 */
public class RsaSigGenerator implements RsaSigGeneratorI {

  @Override
  public DigiSigI generateSig(Client currentClient, MessageI msg) {
    BigInteger message = BigInteger.valueOf(msg.getVal());
    int sigVal = message.modPow(BigInteger.valueOf(currentClient.getPrivateKey().getFirst()),
            BigInteger.valueOf(currentClient.getPrivateKey().getSecond())).intValue();
    return new DigiSig(sigVal);
  }
}
