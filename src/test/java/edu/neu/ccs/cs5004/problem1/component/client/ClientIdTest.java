package edu.neu.ccs.cs5004.problem1.component.client;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClientIdTest {
  private ClientId testId;
  private ClientId sameRefTestId;
  private ClientId sameStateTestId;
  private ClientId diffClientId;

  @Before
  public void setUp() throws Exception {
    testId = new ClientId(1001);
    sameRefTestId = testId;
    sameStateTestId = new ClientId(1001);
    diffClientId = new ClientId(100);
  }

  @Test
  public void getVal() {
    Assert.assertEquals(1001, testId.getVal());
  }

  @Test
  public void equals() {
    ClientId nulltestId = null;
    ClientId anothertestId = new ClientId(1001);

    Assert.assertTrue(testId.equals(sameRefTestId));
    Assert.assertTrue(testId.equals(sameStateTestId));
    Assert.assertEquals(testId.equals(sameStateTestId),
            sameStateTestId.equals(testId));
    Assert.assertEquals(testId.equals(sameStateTestId)
                    && sameStateTestId.equals(anothertestId),
            testId.equals(anothertestId));
    Assert.assertFalse(testId.equals(nulltestId));
    Assert.assertFalse(testId.equals(new Integer(9)));
    Assert.assertFalse(testId.equals(diffClientId));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testId.equals(sameStateTestId),
            testId.hashCode() == sameStateTestId.hashCode());
    Assert.assertEquals(testId.equals(sameRefTestId),
            testId.hashCode() == sameRefTestId.hashCode());
    Assert.assertEquals(!testId.equals(diffClientId),
            testId.hashCode() != diffClientId.hashCode());
  }
}