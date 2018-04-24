package edu.neu.ccs.cs5004.component.client;

/**
 * Represents the process of generate the private and public RSA keys.
 */
public interface RsaKeyGeneratorI {
  /**
   * Generates the private and public RSA keys for the given client.
   * @param currentClient the given client to generate the private and public RSA keys for
   */
  void generateKey(Client currentClient);
}
