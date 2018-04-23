package edu.neu.ccs.cs5004.component.client;

import edu.neu.ccs.cs5004.component.msgSig.RsaKey;

public class Client {
  public static final int IDBOUND = 100000;

  private ClientId id;
  private RsaKey privateKey;
  private RsaKey publicKey;

  public Client(ClientId id) {
    this.id = id;

  }

  public ClientId getId() {
    return id;
  }

  RsaKey getPrivateKey() {
    return privateKey;
  }

  public RsaKey getPublicKey() {
    return publicKey;

  }

  void setPrivateKey(RsaKey privateKey) {
    this.privateKey = privateKey;
  }

  void setPublicKey(RsaKey publicKey) {
    this.publicKey = publicKey;
  }
}
