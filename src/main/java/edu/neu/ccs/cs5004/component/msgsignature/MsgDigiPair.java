package edu.neu.ccs.cs5004.component.msgsignature;

import edu.neu.ccs.cs5004.component.client.ClientId;

/**
 * Represents transaction message and digital signature pair.
 */
public class MsgDigiPair implements MsgDigiPairI {
  private MessageI message;
  private DigiSigI signature;
  private ClientId client;

  /**
   * Creates a new message and digital signature pair with the given message, digital signature and
   * the client ID.
   * @param message the given message
   * @param signature the given digital signature
   * @param client the given client ID
   */
  public MsgDigiPair(MessageI message, DigiSigI signature, ClientId client) {
    this.message = message;
    this.signature = signature;
    this.client = client;
  }

  @Override
  public MessageI getMessage() {
    return message;
  }

  @Override
  public DigiSigI getSignature() {
    return signature;
  }


  @Override
  public ClientId getClientId() {
    return client;
  }
}
