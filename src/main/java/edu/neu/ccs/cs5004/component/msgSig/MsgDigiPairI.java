package edu.neu.ccs.cs5004.component.msgSig;

import edu.neu.ccs.cs5004.component.client.ClientId;

public interface MsgDigiPairI {

  MessageI getMessage();

  DigiSigI getSignature();

  ClientId getClientId();

}
