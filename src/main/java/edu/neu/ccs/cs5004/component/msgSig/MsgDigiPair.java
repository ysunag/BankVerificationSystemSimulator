package edu.neu.ccs.cs5004.component.msgSig;

import edu.neu.ccs.cs5004.component.client.ClientId;

public class MsgDigiPair implements MsgDigiPairI {
  private MessageI message;
  private DigiSigI signature;
  private ClientId client;

  public MsgDigiPair(MessageI message, DigiSigI signature, ClientId client) {
    this.message = message;
    this.signature = signature;
    this.client = client;
  }

  public MessageI getMessage() {
    return message;
  }

  public DigiSigI getSignature() {
    return signature;
  }

  public ClientId getClientId() {
    return client;
  }
}
