package edu.neu.ccs.cs5004.commandLineArgument;

public class InvalidVerificationSystemException extends RuntimeException{
  public static final String WrondArgNum = "Wrong number of arguments provided";
  public static final String WrongClientNum = "Please provide valid number of bank clients";
  public static final String WrongVerificationNum = "Please provide valid number of unique"
          + " verifications.";
  public static final String WrongInvalidMsgPercent = "Please provide valid invalid message " +
          "percentage.";
  public static final String WrongOutput = "Invalid output file name provided";

  public InvalidVerificationSystemException(String message) {
    super(message);
  }

  public static class InvalidArgNumException extends InvalidVerificationSystemException {
    public InvalidArgNumException() {
      super(WrondArgNum);
    }
  }

  public static class InvalidClientNumException extends InvalidVerificationSystemException {
    public InvalidClientNumException() {
      super(WrongClientNum);
    }
  }

  public static class InvalidVerificationNumException extends InvalidVerificationSystemException {
    public InvalidVerificationNumException() {
      super(WrongVerificationNum);
    }
  }

  public static class InvalidMsgPercentException extends InvalidVerificationSystemException {
    public InvalidMsgPercentException() {
      super(WrongInvalidMsgPercent);
    }
  }

  public static class InvalidOutputException extends InvalidVerificationSystemException {
    public InvalidOutputException() {
      super(WrongOutput);
    }
  }
}
