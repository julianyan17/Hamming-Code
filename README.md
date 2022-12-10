Author: Julian Yan  
Date: 1/22/2019  
Title: Hamming Code  
Summary: This program applies the Hamming code to encode and decode messages while checking data corruption through the process. 

Contents: 
* Hamming.java 
  * This file includes methods that will corrupt a 7 piece String with a pattern of 0's and 1's based on the given number position, encode a 4 piece String based off the Hamming Code and decode a 7 piece String based off the Hamming Code.
   * String randomLowercaseString(int length)
   * String randomLowercaseStringII(int length)
   * String corrupt(String ciphertext, int bitPosition)
   * String encode(String originalMessage) 
   * String decode(String ciphertext)

* HammingTester.java
  * Test cases for Hamming.java
