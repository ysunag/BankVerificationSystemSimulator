package edu.neu.ccs.cs5004.component.client;

import java.math.BigInteger;
import java.security.SecureRandom;

import edu.neu.ccs.cs5004.component.msgsignature.RsaKey;

public class RsaKeyGenerator implements RsaKeyGeneratorI {
  public static final int BITLENGTH= 8;
  public static final int CERTAINTY = 90;
  public void generateKey(Client currentClient) {
    SecureRandom rnd = new SecureRandom();
    BigInteger primeP = new BigInteger(BITLENGTH, CERTAINTY, rnd);
    BigInteger primeQ = new BigInteger(BITLENGTH, CERTAINTY, rnd);
    BigInteger productN = primeP.multiply(primeQ);
    BigInteger tempN = primeP.subtract(BigInteger.ONE).multiply(primeQ.subtract(BigInteger.ONE));
    BigInteger numA = new BigInteger(BITLENGTH, rnd);
    while((!numA.gcd(productN).equals(BigInteger.ONE))
    || (!numA.gcd(tempN).equals(BigInteger.ONE))) {
      numA = new BigInteger(BITLENGTH, rnd);
    }
    BigInteger num = BigInteger.ONE;
    while(!tempN.multiply(num).add(BigInteger.ONE).mod(numA).equals(BigInteger.ZERO)) {
      num = num.add(BigInteger.ONE);
    }
    BigInteger numB = tempN.multiply(num).add(BigInteger.ONE).divide(numA);
   //  System.out.println(numB);
    currentClient.setPrivateKey(new RsaKey(numA, productN));
    currentClient.setPublicKey(new RsaKey(numB, productN));
  }
}
