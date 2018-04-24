package edu.neu.ccs.cs5004.commandlineargs;

/**
 * Represents the commandline argument parser.
 */

import edu.neu.ccs.cs5004.outputresult.FileName;

public class ArgumentParser {
  private String[] args;

  /**
   * Creates a new command linet argument parser.
   * @param args the command line argument to be processed.
   */
  public ArgumentParser(String[] args) {
    this.args = new String[args.length];
    for (int i = 0; i < args.length; i++) {
      this.args[i] = args[i];
    }
  }

  /**
   * Checks whether the given command line arguments are valid.
   * @throws InvalidVerificationSystemException upon invalid arguments.
   */
  public void checkArgument() {
    if ( args.length != ArgumentRule.ARGNUM) {
      throw new InvalidVerificationSystemException.InvalidArgNumException();
    }
    if (getClientNum() > ArgumentRule.CLIENTNUMBOUND || getClientNum() < 0) {
      throw new InvalidVerificationSystemException.InvalidClientNumException();
    }
    if (getVerificationNum() > ArgumentRule.VERIFICATIONNUMBOUND || getVerificationNum() < 0) {
      throw new InvalidVerificationSystemException.InvalidVerificationNumException();
    }
    if (getInvalidMsgPercentage() > ArgumentRule.INVALIDPERCENTAGEBOUND
            || getInvalidMsgPercentage() < 0) {
      throw new InvalidVerificationSystemException.InvalidMsgPercentException();
    }
    if (!getOutputFile().getName().matches(ArgumentRule.REGEX_OUTPUT_FILE)) {
      throw new InvalidVerificationSystemException.InvalidOutputException();
    }
  }

  /**
   * Gets the number of clients to be generated.
   * @return the number of clients to be generated.
   */
  public int getClientNum() {
    return Integer.parseInt(args[0]);
  }

  /**
   * Gets the number of messages to be verified.
   * @return the number of messages to be verified.
   */
  public int getVerificationNum() {
    return Integer.parseInt(args[1]);
  }

  /**
   * Gets the percentage of invalid digital signature to be generated.
   * @return the percentage of invalid digital signature to be generated
   */
  public double getInvalidMsgPercentage() {
    return Double.parseDouble(args[2]);
  }

  /**
   * Gets the name of the output file.
   * @return the name of the output file.
   */
  public FileName getOutputFile() {
    return new FileName(args[3]);
  }

}
