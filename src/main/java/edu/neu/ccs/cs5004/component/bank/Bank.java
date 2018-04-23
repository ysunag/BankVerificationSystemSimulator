package edu.neu.ccs.cs5004.component.bank;

import java.util.HashMap;
import java.util.Map;


import edu.neu.ccs.cs5004.component.client.ClientId;
import edu.neu.ccs.cs5004.component.msgsignature.RsaKey;

public class Bank implements BankI{
  private Map<ClientId, Integer> depositLimits;
  private Map<ClientId, Integer> withdrawlLimits;
  private Map<ClientId, RsaKey> publicKeys;


  public Bank() {
    publicKeys = new HashMap<>();
  }

  public Map<ClientId, RsaKey> getPublicKeys() {
    return publicKeys;
  }

  public Map<ClientId, Integer> getDepositLimits() {
    return depositLimits;
  }

  public Map<ClientId, Integer> getWithdrawlLimits() {
    return withdrawlLimits;
  }

  public void addPublicKey(ClientId clientId, RsaKey key) {
    publicKeys.put(clientId, key);
  }

  public void setWithdrawlLimits(Map<ClientId, Integer> withdrawlLimits) {
    this.withdrawlLimits = withdrawlLimits;
  }


  public void setDepositLimits(Map<ClientId, Integer> depositLimits) {
    this.depositLimits = depositLimits;
  }


}
