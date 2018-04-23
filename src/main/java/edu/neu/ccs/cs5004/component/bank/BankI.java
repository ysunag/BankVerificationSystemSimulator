package edu.neu.ccs.cs5004.component.bank;


import java.util.Map;

import edu.neu.ccs.cs5004.component.client.ClientId;
import edu.neu.ccs.cs5004.component.msgsignature.RsaKey;

public interface BankI {
  Map<ClientId, Integer> getDepositLimits();

  Map<ClientId, Integer> getWithdrawlLimits();

  Map<ClientId, RsaKey> getPublicKeys();

  void addPublicKey(ClientId clientId, RsaKey key);
}
