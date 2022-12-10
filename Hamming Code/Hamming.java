// Keep this line. This tells Java to include the classes you need.
import java.util.*;

/*
 * Author: Julian Yan
 * Date: 1/22/19
 * File: Hamming.java 
 *
 * Included below are methods that will corrupt a 7 piece String with a 
 * pattern of 0's and 1's based on the given number position, encode a 4 piece 
 * String based off the Hamming Code and decode a 7 piece String based off the 
 * Hamming Code. 
 */

/** Use the Hamming class to corrupt, encode and decode Strings based off the 
 *  Hamming Code algorithm.
 */
public class Hamming {

	// Hamming bit position constants
	private static final int BIT_1P = 1;
	private static final int BIT_2P = 2;
	private static final int BIT_3 = 3;
	private static final int BIT_4P = 4;
	private static final int BIT_5 = 5;
	private static final int BIT_6 = 6;
	private static final int BIT_7 = 7;

	private static int[] parityIndices = {1, 2, 4};
	private static int[] nonParityIndices = {3, 5, 6, 7};

    // String creator non-magic numbers
    private static final int STARTING_RANGE = 25;
    private static final int RANGE_SHIFTER = 97;

    // Coded message length
    private static final int LENGTH_OF_CODED = 7;

    // Divide by 2
    private static final int HALF = 2;

    // Length of an uncoded message
    private static final int LENGTH_OF_MESSAGE = 4;

    // Positions in an uncoded message
    private static final int POSITION_1 = 0;
    private static final int POSITION_2 = 1;
    private static final int POSITION_3 = 2;
    private static final int POSITION_4 = 3;

    /** 
     * Creates a random combination of lowercase letters the same length as 
     * the given int.
     * 
     * @param int length that is the length of the new String
     * @return String the newly created random combination of lowercase 
     *               letters
     */

	public static String randomLowercaseString(int length) {
		Random rand = new Random();
        String finalString = "";
        for (int i = 0; i < length; i++) { 
            // Setting the range of the random
            int randInRange = rand.nextInt(STARTING_RANGE) + RANGE_SHIFTER;
            char randLetter = (char)randInRange;
            finalString = finalString + randLetter;
        }
		return finalString;
	}

     /** 
     * Creates a random combination of lowercase letters the same length as 
     * the given int using a StringBuilder.
     * 
     * @param int length that is the length of the new String
     * @return String the newly created random combination of lowercase 
     *         letters
     */

	public static String randomLowercaseStringII(int length) {
        Random rand = new Random();
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // Setting the range of the random
            int randInRange = rand.nextInt(STARTING_RANGE) + RANGE_SHIFTER;
            char randLetter = (char)randInRange;
            finalString = finalString.append(randLetter);
        }
		return finalString.toString();
	}

    /** 
     * Replace a value in the given String at the given bitPosition with
     * its opposite value (0 to 1 and 1 to 0).
     *  
     * @param String ciphertext given String 
     * @param int bitPosition position to corrupt (replace value)
     * @return String the new String with a corrupt value 
     *               
     */

	public static String corrupt(String ciphertext, int bitPosition) {

        if (ciphertext == null) {
            return null;
        }
       
        // If the given String is too long or too short
        if (ciphertext.length() != LENGTH_OF_CODED) {
            return null;
        }

        // If the given int is too big and goes out of bounds        
        if (bitPosition > LENGTH_OF_CODED){
            return null;
        }
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextAtIndex = ciphertext.charAt(i);
            // If the value of every character in ciphertext is not 0 or 1
            if (!(ciphertextAtIndex == '0' || ciphertextAtIndex == '1')) {
                return null; 
            }
        }

        StringBuilder corrupted = new StringBuilder(ciphertext);        

        if (ciphertext.charAt(bitPosition - 1) == '1') {
            corrupted.setCharAt((bitPosition - 1), '0');
        }
        
        if (ciphertext.charAt(bitPosition - 1) == '0') {
            corrupted.setCharAt((bitPosition - 1), '1');
        }

		return corrupted.toString();
	}

    /** 
     * Encodes a message using a String of 4 bits via Hamming.
     * 
     * @param String 4 bits represented by a character of "1" or "0"
     * @return String the newly encoded String of lenght 7
     */


	public static String encode(String originalMessage) {

        if (originalMessage == null) {
            return null;
        }

        // If the given String is too long or too short
        if (originalMessage.length() != LENGTH_OF_MESSAGE) {
            return null;
        }

        for (int i = 0; i < originalMessage.length(); i++) {
            char originalMessageAtIndex = originalMessage.charAt(i);
            // If the value of every character in ciphertext is not 0 or 1
            if (!(originalMessageAtIndex == '0' || 
                  originalMessageAtIndex == '1')) {
                return null; 
            }
        }
        
        StringBuilder encoded = new StringBuilder();
        encoded.setLength(LENGTH_OF_CODED);

        /* Set the values of the original message in their proper positions in
           the new encoded String
        */        
        encoded.setCharAt((BIT_3 - 1), originalMessage.charAt(POSITION_1));
        encoded.setCharAt((BIT_5 - 1), originalMessage.charAt(POSITION_2));
        encoded.setCharAt((BIT_6 - 1), originalMessage.charAt(POSITION_3));
        encoded.setCharAt((BIT_7 - 1), originalMessage.charAt(POSITION_4));

        // Takes individual values from the new encoded String
        char bit3Value = encoded.charAt((BIT_3 - 1));
        char bit5Value = encoded.charAt((BIT_5 - 1));
        char bit6Value = encoded.charAt((BIT_6 - 1));
        char bit7Value = encoded.charAt((BIT_7 - 1));

        /* Gets the total int value of the parity bits by adding the values in
           their corresponding positions 
        */
        int P1 = Character.getNumericValue(bit3Value) + 
                 Character.getNumericValue(bit5Value) + 
                 Character.getNumericValue(bit7Value);
        int P2 = Character.getNumericValue(bit3Value) + 
                 Character.getNumericValue(bit6Value) + 
                 Character.getNumericValue(bit7Value);
        int P4 = Character.getNumericValue(bit5Value) + 
                 Character.getNumericValue(bit6Value) + 
                 Character.getNumericValue(bit7Value);

        // If P1 is even
        if (P1 % HALF == 0) {
            encoded.setCharAt((BIT_1P - 1), '0');
        }
        else {
            encoded.setCharAt((BIT_1P - 1), '1');
        }
        
        // If P2 is even
        if (P2 % HALF == 0) {
            encoded.setCharAt((BIT_2P - 1), '0');
        }
        else {
            encoded.setCharAt((BIT_2P - 1), '1');
        }

        // If P4 is even
        if (P4 % HALF == 0) {
            encoded.setCharAt((BIT_4P - 1), '0');
        }
        else {
            encoded.setCharAt((BIT_4P - 1), '1');
        }

  		return encoded.toString();
	}

    /**
     * Decodes a message with at most one-bit in the given String flipped.
     *
     * @param String ciphertext the message that must be decoded
     * @return String decoded message
     */

	public static String decode(String ciphertext) {

        if (ciphertext == null) {
            return null;
        }
        
        // If the given String is too long or too short
        if (ciphertext.length() != LENGTH_OF_CODED) {
            return null;
        }
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextAtIndex = ciphertext.charAt(i);
            // If the value of every character in ciphertext is not 0 or 1
            if (!(ciphertextAtIndex == '0' || ciphertextAtIndex == '1')) {
                return null; 
            }
        }

        // Takes individual values from the new encoded String
        char bit1Value = ciphertext.charAt((BIT_1P - 1));
        char bit2Value = ciphertext.charAt((BIT_2P - 1));        
        char bit3Value = ciphertext.charAt((BIT_3 - 1));
        char bit4Value = ciphertext.charAt((BIT_4P - 1));        
        char bit5Value = ciphertext.charAt((BIT_5 - 1));
        char bit6Value = ciphertext.charAt((BIT_6 - 1));
        char bit7Value = ciphertext.charAt((BIT_7 - 1));

        // Gets the actual value in the bit positions
        int actualP1 = Character.getNumericValue(bit1Value);
        int actualP2 = Character.getNumericValue(bit2Value);
        int actualP4 = Character.getNumericValue(bit4Value);
        

        /* Gets the total int value of the parity bits by adding the values in
           their corresponding positions
        */
        int P1 = Character.getNumericValue(bit3Value) + 
                 Character.getNumericValue(bit5Value) + 
                 Character.getNumericValue(bit7Value);
        int P2 = Character.getNumericValue(bit3Value) + 
                 Character.getNumericValue(bit6Value) + 
                 Character.getNumericValue(bit7Value);
        int P4 = Character.getNumericValue(bit5Value) + 
                 Character.getNumericValue(bit6Value) + 
                 Character.getNumericValue(bit7Value);

        int corruptedPosition = 0;

        /* If the values corresponding to parity1 and the value in position 1 
           are BOTH even OR the values corresponding to parity1 and the value 
           in position 1 are BOTH odd
        */
        if ((P1 % HALF == 0 && actualP1 % HALF == 0) ||
            (P1 % HALF != 0 && actualP1 % HALF != 0)) {
            corruptedPosition = corruptedPosition;
        }    
        else {
            corruptedPosition = corruptedPosition + BIT_1P;
        }

        /* If the values corresponding to parity2 and the value in position 2 
           are BOTH even OR the values corresponding to parity2 and the value 
           in position 2 are BOTH odd
        */
        if ((P2 % HALF == 0 && actualP2 % HALF == 0) ||
            (P2 % HALF != 0 && actualP2 % HALF != 0)) {
            corruptedPosition = corruptedPosition;
        }    
        else {
            corruptedPosition = corruptedPosition + BIT_2P;
        }

        /* If the values corresponding to parity4 and the value in position 4 
           are BOTH even OR the values corresponding to parity4 and the value 
           in position 4 are BOTH odd
        */
        if ((P4 % HALF == 0 && actualP4 % HALF == 0) ||
            (P4 % HALF != 0 && actualP4 % HALF != 0)) {
            corruptedPosition = corruptedPosition;
        }    
        else {            
            corruptedPosition = corruptedPosition + BIT_4P;          
        }
        
        StringBuilder decodedString = new StringBuilder(ciphertext);
        decodedString.setLength(LENGTH_OF_CODED);

        if (corruptedPosition != 0) {
            if (ciphertext.charAt(corruptedPosition - 1) == '1') {
            decodedString.setCharAt((corruptedPosition - 1), '0');
            }

            if (ciphertext.charAt(corruptedPosition - 1) == '0') {
            decodedString.setCharAt((corruptedPosition - 1), '1');
            }
        }

        StringBuilder decodeMessage = new StringBuilder();
        decodeMessage.setLength(LENGTH_OF_MESSAGE);

        /* Set the values of the decoded message in their proper positions in
           the new encoded String
        */        
        decodeMessage.setCharAt(POSITION_1, decodedString.charAt(BIT_3 - 1));
        decodeMessage.setCharAt(POSITION_2, decodedString.charAt(BIT_5 - 1));
        decodeMessage.setCharAt(POSITION_3, decodedString.charAt(BIT_6 - 1));
        decodeMessage.setCharAt(POSITION_4, decodedString.charAt(BIT_7 - 1));

		return decodeMessage.toString();
	}    
    public static void main (String[] args){
        String test = corrupt("1111111",2);
        System.out.println(test);
    }
}
