Author: Julian Yan  
Date: 1/22/2019  
Title: Hamming Code  

Contents: 
* Hamming.java 
  * String randomLowercaseString(int length)
    * Creates a random combination of lowercase letters the same length as the given int.
  * String randomLowercaseStringII(int length)
    * Creates a random combination of lowercase letters the same length as the given int using a StringBuilder.
  * String corrupt(String ciphertext, int bitPosition)
    * Replace a value in the given String at the given bitPosition with its opposite value (0 to 1 and 1 to 0).
  * String encode(String originalMessage) 
    * Encodes a message using a String of 4 bits via Hamming code.
  * String decode(String ciphertext)
    * Decodes a message with at most one-bit in the given String flipped.

* HammingTester.java
  * Test cases for Hamming.java