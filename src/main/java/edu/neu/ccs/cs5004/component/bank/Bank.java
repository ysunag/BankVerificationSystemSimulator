package edu.neu.ccs.cs5004.component.bank;

import edu.neu.ccs.cs5004.component.client.ClientId;
import edu.neu.ccs.cs5004.component.msgsignature.RsaKey;

import java.util.HashMap;
import java.util.Map;


/**
 * Represents a bank with the deposit limits of its clients, withdrawal limits of its clients
 * and the public keys of its clients.
 */
public class Bank implements BankI{
  private Map<ClientId, Integer> depositLimits;
  private Map<ClientId, Integer> withdrawlLimits;
  private Map<ClientId, RsaKey> publicKeys;


  /**
   * Constructs a new bank with an empty public key map.
   */
  public Bank() {
    publicKeys = new HashMap<>();
  }

  @Override
  public Map<ClientId, RsaKey> getPublicKeys() {
    return publicKeys;
  }

  @Override
  public Map<ClientId, Integer> getDepositLimits() {
    return depositLimits;
  }

  @Override
  public Map<ClientId, Integer> getWithdrawlLimits() {
    return withdrawlLimits;
  }

  @Override
  public void addPublicKey(ClientId clientId, RsaKey key) {
    publicKeys.put(clientId, key);
  }

  @Override
  public void setWithdrawlLimits(Map<ClientId, Integer> withdrawlLimits) {
    this.withdrawlLimits = withdrawlLimits;
  }

  @Override
  public void setDepositLimits(Map<ClientId, Integer> depositLimits) {
    this.depositLimits = depositLimits;
  }


}
