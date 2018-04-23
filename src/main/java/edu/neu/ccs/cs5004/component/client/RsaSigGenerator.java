package edu.neu.ccs.cs5004.component.client;

import java.math.BigInteger;

import edu.neu.ccs.cs5004.component.msgsignature.DigiSig;
import edu.neu.ccs.cs5004.component.msgsignature.DigiSigI;
import edu.neu.ccs.cs5004.component.msgsignature.MessageI;

public class RsaSigGenerator implements RsaSigGeneratorI {
  public DigiSigI generateSig(Client currentClient, MessageI msg) {
    BigInteger message = BigInteger.valueOf(msg.getVal());
    int sigVal = message.modPow(currentClient.getPrivateKey().getFirst(),
    currentClient.getPrivateKey().getSecond()).intValue();
  //  System.out.println(sigVal);
    return new DigiSig(sigVal);
  }
}
