package edu.neu.ccs.cs5004.component.bank;

import java.util.Map;

import edu.neu.ccs.cs5004.client.ClientId;
import edu.neu.ccs.cs5004.component.msgSig.RsaKey;

public interface BankI {
  Map<ClientId, Integer> getDepositLimits();

  Map<ClientId, Integer> getWithdrawlLimits();

  void addPublicKey(ClientId id, RsaKey key);
}
