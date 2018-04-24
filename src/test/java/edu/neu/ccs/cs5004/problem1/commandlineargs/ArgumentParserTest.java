package edu.neu.ccs.cs5004.problem1.commandlineargs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.outputresult.FileName;


public class ArgumentParserTest {
  private ArgumentParser testParser;

  @Before
  public void setUp() throws Exception {
    String[] args = {"300", "50", "10", "output.csv"};
    testParser = new ArgumentParser(args);
  }

  @Test(expected = InvalidVerificationSystemException.InvalidArgNumException.class)
  public void checkArgument1() {
    String[] args5 = {"300", "10", "output.csv"};
    ArgumentParser testParser5 = new ArgumentParser(args5);
    testParser5.checkArgument();
  }

  @Test(expected = InvalidVerificationSystemException.InvalidClientNumException.class)
  public void checkArgument2() {
    String[] args1 = {"-1", "50", "10", "output.csv"};
    ArgumentParser testParser1 = new ArgumentParser(args1);
    testParser1.checkArgument();
    String[] args4 = {"60000", "50", "10", "output.csv"};
    ArgumentParser testParser4 = new ArgumentParser(args4);
    testParser4.checkArgument();
  }


  @Test(expected = InvalidVerificationSystemException.InvalidVerificationNumException.class)
  public void checkArgument3() {
    String[] args2= {"300", "-50", "10", "output.csv"};
    ArgumentParser testParser2 = new ArgumentParser(args2);
    testParser2.checkArgument();
    String[] args6 = {"300", "20000", "10", "output.csv"};
    ArgumentParser testParser6 = new ArgumentParser(args6);
    testParser6.checkArgument();
  }


  @Test(expected = InvalidVerificationSystemException.InvalidMsgPercentException.class)
  public void checkArgument4() {
    String[] args3 = {"300", "50", "-10", "output.csv"};
    ArgumentParser testParser3 = new ArgumentParser(args3);
    testParser3.checkArgument();
    String[] args7 = {"300", "50", "110", "output.csv"};
    ArgumentParser testParser7 = new ArgumentParser(args7);
    testParser7.checkArgument();
  }


  @Test(expected = InvalidVerificationSystemException.InvalidOutputException.class)
  public void checkArgument5() {
    String[] args8 = {"300", "50", "10", "output"};
    ArgumentParser testParser8 = new ArgumentParser(args8);
    testParser8.checkArgument();
  }


  @Test
  public void getClientNum() {
    Assert.assertEquals(300, testParser.getClientNum());
  }

  @Test
  public void getVerificationNum() {
    Assert.assertEquals(50, testParser.getVerificationNum());
  }

  @Test
  public void getInvalidMsgPercentage() {
    Assert.assertEquals(10, testParser.getInvalidMsgPercentage(), 0.001);
  }

  @Test
  public void getOutputFile() {
    Assert.assertEquals(new FileName("output.csv"), testParser.getOutputFile());
  }
}