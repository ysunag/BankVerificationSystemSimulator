package edu.neu.ccs.cs5004.component.client;

import edu.neu.ccs.cs5004.component.msgsignature.RsaKey;

public class Client {
  public static final int IDBOUND = 100000;

  private ClientId clientId;
  private RsaKey privateKey;
  private RsaKey publicKey;

  public Client(ClientId clientId) {
    this.clientId = clientId;

  }

  public ClientId getId() {
    return clientId;
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
