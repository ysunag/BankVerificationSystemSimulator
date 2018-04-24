package edu.neu.ccs.cs5004.component.bank;


import edu.neu.ccs.cs5004.component.client.ClientId;
import edu.neu.ccs.cs5004.component.msgsignature.RsaKey;


import java.util.Map;

/**
 * Represents a bank.
 */
public interface BankI {
  /**
   * Getter for property 'DepositLimits'.
   * @return Value for property 'DepositLimits'
   */
  Map<ClientId, Integer> getDepositLimits();

  /**
   * Getter for property 'WithdrawalLimits'.
   * @return Value for property 'WithdrawalLimits'
   */
  Map<ClientId, Integer> getWithdrawlLimits();


  /**
   * Getter for property 'publicKeys'.
   * @return Value for property 'publicKeys'
   */
  Map<ClientId, RsaKey> getPublicKeys();

  /**
   * Adds a client ID and the public key to the public key map of the bank.
   * @param clientId the client id to add
   * @param key the public key to add
   */
  void addPublicKey(ClientId clientId, RsaKey key);

  /**
   * Setter for property 'WithdrawalLimits'.
   * @param withdrawlLimits the withdrawal limit to be set
   */
  void setWithdrawlLimits(Map<ClientId, Integer> withdrawlLimits);


  /**
   * Setter for property 'DepositLimits'.
   * @param depositLimits the deposit limits to be set
   */
  void setDepositLimits(Map<ClientId, Integer> depositLimits);
}
