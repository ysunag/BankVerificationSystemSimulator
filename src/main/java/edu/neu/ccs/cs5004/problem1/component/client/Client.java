package edu.neu.ccs.cs5004.problem1.component.client;

import edu.neu.ccs.cs5004.problem1.component.msgsignature.RsaKey;

/**
 * Represents the client with an ID, a private RSA key and a public RSA key.
 */
public class Client {
  public static final int IDBOUND = 100000;

  private ClientId clientId;
  private RsaKey privateKey;
  private RsaKey publicKey;

  /**
   * Creates a new client with the given ID.
   * @param clientId the given client ID.
   */
  public Client(ClientId clientId) {
    this.clientId = clientId;

  }

  /**
   * Getter for property 'clientId'.
   * @return Value for property 'clientId'
   */
  public ClientId getId() {
    return clientId;
  }

  /**
   * Getter for property 'privateKey'.
   * @return Value for property 'privateKey'
   */
  RsaKey getPrivateKey() {
    return privateKey;
  }

  /**
   * Getter for property 'publicKey'.
   * @return Value for property 'publicKey'
   */
  public RsaKey getPublicKey() {
    return publicKey;

  }

  /**
   * Setter for property 'privateKey'.
   * @param privateKey the value for setting the property 'privateKey'
   */
  void setPrivateKey(RsaKey privateKey) {
    this.privateKey = privateKey;
  }

  /**
   * Setter for property 'publicKey'.
   * @param publicKey the value for setting the property 'publicKey'
   */
  void setPublicKey(RsaKey publicKey) {
    this.publicKey = publicKey;
  }
}
