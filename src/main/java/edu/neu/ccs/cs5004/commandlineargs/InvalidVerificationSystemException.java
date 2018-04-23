package edu.neu.ccs.cs5004.commandlineargs;

public class InvalidVerificationSystemException extends RuntimeException{
  public static final String WRONGARGNUM = "Wrong number of arguments provided";
  public static final String WRONGCLIENTNUM = "Please provide valid number of bank clients";
  public static final String WRONGVERIFICATIONNUM = "Please provide valid number of unique"
          + " verifications.";
  public static final String WRONGINVALIDMSGPERCENT = "Please provide valid invalid message " +
          "percentage.";
  public static final String WRONGOUTPUT = "Invalid output file name provided";

  public InvalidVerificationSystemException(String message) {
    super(message);
  }

  public static class InvalidArgNumException extends InvalidVerificationSystemException {
    public InvalidArgNumException() {
      super(WRONGARGNUM);
    }
  }

  public static class InvalidClientNumException extends InvalidVerificationSystemException {
    public InvalidClientNumException() {
      super(WRONGCLIENTNUM);
    }
  }

  public static class InvalidVerificationNumException extends InvalidVerificationSystemException {
    public InvalidVerificationNumException() {
      super(WRONGVERIFICATIONNUM);
    }
  }

  public static class InvalidMsgPercentException extends InvalidVerificationSystemException {
    public InvalidMsgPercentException() {
      super(WRONGINVALIDMSGPERCENT);
    }
  }

  public static class InvalidOutputException extends InvalidVerificationSystemException {
    public InvalidOutputException() {
      super(WRONGOUTPUT);
    }
  }
}
