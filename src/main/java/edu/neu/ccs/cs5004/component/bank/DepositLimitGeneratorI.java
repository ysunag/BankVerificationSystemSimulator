package edu.neu.ccs.cs5004.component.bank;

import java.util.Map;

import edu.neu.ccs.cs5004.component.client.ClientId;

public interface DepositLimitGeneratorI {
  int DEPOSITBOUND = 2000;

  Map<ClientId, Integer> generateDepositLimits();
}
