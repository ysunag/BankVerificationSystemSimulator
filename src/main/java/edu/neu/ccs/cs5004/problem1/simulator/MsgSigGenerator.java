package edu.neu.ccs.cs5004.problem1.simulator;

import edu.neu.ccs.cs5004.problem1.component.client.Client;
import edu.neu.ccs.cs5004.problem1.component.client.RsaSigGenerator;
import edu.neu.ccs.cs5004.problem1.component.client.RsaSigGeneratorI;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.DigiSig;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.DigiSigI;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.Message;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.MessageI;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.MsgDigiPair;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.MsgDigiPairI;



import java.util.LinkedList;
import java.util.List;
import java.util.Random;



/**
 * Represents the process of generating the message-digital signature pairs.
 */

public class MsgSigGenerator implements MsgSigGeneratorI {
  private List<Client> clients;
  private int numberOfClients;

  /**
   * Creates a new message-digital signature pair generator with given clients and the number of
   * clients.
   * @param clients the given clients
   * @param numberOfClients the number of the clients
   */
  public MsgSigGenerator(List<Client> clients, int numberOfClients) {
    this.clients = clients;
    this.numberOfClients = numberOfClients;
  }

  @Override
  public List<MsgDigiPairI> generateMsgSigPairs(int numOfVerification, double invalidMsgPercent) {
    Double temp = numOfVerification * invalidMsgPercent / 100;
    int allowedInvalidMsgNum = temp.intValue();
    int currentInvalidNum = 0;
    List<MsgDigiPairI> pairs = new LinkedList<>();

    RsaSigGeneratorI sigGenerator = new RsaSigGenerator();
    Random rand = new Random();
    MessageI msg;
    DigiSigI signature;
    Client currentClient;
    for (int i = 0; i < numOfVerification; i++) {
      int clientNum = rand.nextInt(numberOfClients);
      currentClient = clients.get(clientNum);
      msg = new Message(rand.nextInt(MessageI.MESSAGEBOUND) + 1);
      int validOrNot = rand.nextInt(2);
      if (validOrNot == 0 && currentInvalidNum < allowedInvalidMsgNum) {
        signature = new DigiSig(rand.nextInt(DigiSigI.DIGISIGRANDOMBOUND) + 1);
        currentInvalidNum += 1;
      } else {
        signature = sigGenerator.generateSig(currentClient, msg);
      }
      MsgDigiPairI currentPair = new MsgDigiPair(msg, signature, currentClient.getId());
      pairs.add(currentPair);
    }
    return pairs;
  }
}
