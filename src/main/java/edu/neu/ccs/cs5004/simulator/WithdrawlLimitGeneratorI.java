package edu.neu.ccs.cs5004.simulator;

import java.util.Map;

import edu.neu.ccs.cs5004.component.client.ClientId;

public interface WithdrawlLimitGeneratorI {
  int WITHDRAWLBOUND = 3000;
  Map<ClientId, Integer> generateWithdrawlLimits();
}
