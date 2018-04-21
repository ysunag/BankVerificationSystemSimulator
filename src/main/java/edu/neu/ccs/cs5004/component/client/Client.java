package edu.neu.ccs.cs5004.component.client;

import edu.neu.ccs.cs5004.component.msgSig.RsaKey;

public class Client implements ClientI {

  private ClientId id;
  private RsaKey privateKey;
  private RsaKey publicKey;

  public Client(ClientId id) {
    this.id = id;

  }

  public ClientId getId() {
    return id;
  }

  public RsaKey getPublicKey() {
    return publicKey;
  }
}
