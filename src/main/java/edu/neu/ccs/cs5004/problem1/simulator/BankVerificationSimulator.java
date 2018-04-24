package edu.neu.ccs.cs5004.problem1.simulator;


import edu.neu.ccs.cs5004.problem1.commandlineargs.ArgumentParser;
import edu.neu.ccs.cs5004.problem1.component.bank.Bank;
import edu.neu.ccs.cs5004.problem1.component.bank.BankI;
import edu.neu.ccs.cs5004.problem1.component.bank.DepositLimitGenerator;
import edu.neu.ccs.cs5004.problem1.component.bank.DepositLimitGeneratorI;
import edu.neu.ccs.cs5004.problem1.component.bank.RsaSigVerification;
import edu.neu.ccs.cs5004.problem1.component.bank.RsaSigVerificationI;
import edu.neu.ccs.cs5004.problem1.component.bank.WithdrawlLimitGenerator;
import edu.neu.ccs.cs5004.problem1.component.bank.WithdrawlLimitGeneratorI;
import edu.neu.ccs.cs5004.problem1.component.client.Client;
import edu.neu.ccs.cs5004.problem1.component.client.ClientIdGenerator;
import edu.neu.ccs.cs5004.problem1.component.client.ClientIdGeneratorI;
import edu.neu.ccs.cs5004.problem1.component.client.RsaKeyGenerator;
import edu.neu.ccs.cs5004.problem1.component.client.RsaKeyGeneratorI;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.MsgDigiPairI;
import edu.neu.ccs.cs5004.problem1.component.transaction.Action;
import edu.neu.ccs.cs5004.problem1.component.transaction.TransactionStatusI;
import edu.neu.ccs.cs5004.problem1.outputresult.CsvFileWriter;
import edu.neu.ccs.cs5004.problem1.outputresult.FileName;
import edu.neu.ccs.cs5004.problem1.outputresult.FileWriterI;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Represents the bank verification simulator.
 */
public class BankVerificationSimulator implements BankVerificationSimulatorI {
  public static final String VERIFIED = "yes";
  public static final String NOTVERIFIED = "no";
  public static final String HEADER = "Transaction number-Date,Time,Client ID,Message,"
          + "Digital signature,Verified,Transaction status";
  private BankI bank;
  private List<Client> clients;
  private List<MsgDigiPairI> pairsToVerify;
  private int numOfClient;
  private int numOfVerification;
  private double invalidMsgPercent;
  private FileName outputFile;

  /**
   * Creates a new bank verification simulator system.
   * @param numOfClient the number of client to generate.
   * @param numOfVerification the number of verification to make
   * @param invalidMsgPercent the invalid message percentage
   * @param outputFile the output file name
   */
  public BankVerificationSimulator(int numOfClient, int numOfVerification, double invalidMsgPercent,
                                   FileName outputFile) {
    this.numOfClient = numOfClient;
    this.numOfVerification = numOfVerification;
    this.invalidMsgPercent = invalidMsgPercent;
    this.outputFile = outputFile;
    bank = new Bank();
    clients = new ArrayList<>();
  }

  @Override
  public void setUpBankSystem() {
    ClientIdGeneratorI clientGenerator = new ClientIdGenerator();
    clientGenerator.generateClientId(clients, numOfClient);
    RsaKeyGeneratorI keyGenerator = new RsaKeyGenerator();
    for (Client currentClient: clients) {
      keyGenerator.generateKey(currentClient);
      bank.addPublicKey(currentClient.getId(), currentClient.getPublicKey());
    }
    MsgSigGeneratorI msgSigGenerator = new MsgSigGenerator(clients, numOfClient);
    pairsToVerify = msgSigGenerator.generateMsgSigPairs(numOfVerification, invalidMsgPercent);
    DepositLimitGeneratorI depLimitGenerator = new DepositLimitGenerator(clients);
    bank.setDepositLimits(depLimitGenerator.generateDepositLimits());
    WithdrawlLimitGeneratorI wdLimitGenerator = new WithdrawlLimitGenerator(clients);
    bank.setWithdrawlLimits(wdLimitGenerator.generateWithdrawlLimits());
  }


  @Override
  public void runVerificationSimulator() {
    RsaSigVerificationI sigVerification = new RsaSigVerification();
    TransactionStatusDeterminationI transacStatDeterminator
            = new TransactionStatusDetermination(bank);
    StringBuilder sbuilder;
    String seperator = ",";
    int transactionNum = 1;
    List<String> output = new ArrayList<>();
    output.add(HEADER);
    for (MsgDigiPairI pair: pairsToVerify) {
      sbuilder = new StringBuilder();
      sbuilder.append(transactionNum);
      DateFormat dateFormat = new SimpleDateFormat("-yyyy/MM/dd,HH:mm:ss");
      Date date = new Date();
      sbuilder.append(dateFormat.format(date));
      sbuilder.append(seperator);
      sbuilder.append(pair.getClientId().getVal());
      sbuilder.append(seperator);
      sbuilder.append(pair.getMessage().getVal());
      sbuilder.append(seperator);
      sbuilder.append(pair.getSignature().getVal());
      sbuilder.append(seperator);
      boolean sigVerified = sigVerification.verifyMsg(bank, pair);
      sbuilder.append(sigVerified ? VERIFIED : NOTVERIFIED);
      sbuilder.append(seperator);
      Action currentAction = Action.generateAction(pair.getMessage());
      boolean validTransaction = transacStatDeterminator.verifyTransaction(pair.getMessage(),
              pair.getClientId());
      TransactionStatusI transactStatus = TransactionStatusI
              .generateTransactionStatus(currentAction, sigVerified && validTransaction);
      sbuilder.append(transactStatus.toString());
      transactionNum += 1;
      output.add(sbuilder.toString());
    }
    FileWriterI writer = new CsvFileWriter();
    writer.toWrite(outputFile, output);
  }


  /**
   * Run the bank verification simulation system.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArgumentParser parser = new ArgumentParser(args);
    parser.checkArgument();
    BankVerificationSimulatorI newSimulator  = new BankVerificationSimulator(
            parser.getClientNum(), parser.getVerificationNum(), parser.getInvalidMsgPercentage(),
            parser.getOutputFile());
    newSimulator.setUpBankSystem();
    newSimulator.runVerificationSimulator();
  }
}
