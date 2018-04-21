package edu.neu.ccs.cs5004.commandLineArgument;


import edu.neu.ccs.cs5004.outputResult.FileName;

public class ArgumentParser {
  private String[] args;

  public ArgumentParser(String[] args) {
    this.args = new String[args.length];
    for (int i = 0; i < args.length; i++) {
      this.args[i] = args[i];
    }
  }

  public void checkArgument() {
    if( args.length != ArgumentRule.ArgNum) {
      throw new InvalidVerificationSystemException.InvalidArgNumException();
    }
    if (getClientNum() > ArgumentRule.CLIENTNUMBOUND || getClientNum() < 0) {
      throw new InvalidVerificationSystemException.InvalidClientNumException();
    }
    if (getVerificationNum() > ArgumentRule.VERIFICATIONNUMBOUND || getVerificationNum() < 0) {
      throw new InvalidVerificationSystemException.InvalidVerificationNumException();
    }
    if (!getOutputFile().getName().matches(ArgumentRule.REGEX_OUTPUT_FILE)) {
      throw new InvalidVerificationSystemException.InvalidOutputException();
    }
  }

  public int getClientNum() {
    return Integer.parseInt(args[0]);
  }

  public int getVerificationNum() {
    return Integer.parseInt(args[1]);
  }

  public double getInvalidMsgPercentage() {
    return Double.parseDouble(args[2]);
  }

  public FileName getOutputFile() {
    return new FileName(args[3]);
  }

}
