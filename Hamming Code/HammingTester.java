public class HammingTester {
    public static void main (String[] args) {

        // corrupt and decode inputs
        String codeEx1 = "1010101";
        String codeEx2 = "1011111";
        String codeEx3 = "1100111";
        
        // encode inputs
        String encodeEx1 = "1101";
        String encodeEx2 = "1111";
        String encodeEx3 = "0110";

        // null inputs
        String nullEx1 = null;
        String nullEx2 = "11111111";
        String nullEx3 = "j111111";

        // corrupt testers

        if (!(Hamming.corrupt(codeEx1,1).equals("0010101"))) {
            // This informs the user that this test failed.
            System.out.println("[corruptEx1] FAILED.");
        }
        else {
            // This informs the user that this test passed.
            System.out.println("[corruptEx1] SUCCEEDED.");
        }

        if (!(Hamming.corrupt(codeEx2,2).equals("1111111"))) {
            System.out.println("[corruptEx2] FAILED.");
        }
        else {
            System.out.println("[corruptEx2] SUCCEEDED.");
        }

        if (!(Hamming.corrupt(codeEx3,3).equals("1110111"))) {
            System.out.println("[corruptEx3] FAILED.");
        }
        else {
            System.out.println("[corruptEx3] SUCCEEDED.");
        }

        if (!(Hamming.corrupt(nullEx1,4) == null)) {
            System.out.println("[corruptEx4] FAILED.");
        }
        else {
            System.out.println("[corruptEx4] SUCCEEDED.");
        }

        if (!(Hamming.corrupt(nullEx2,5) == null)) {
            System.out.println("[corruptEx5] FAILED.");
        }
        else {
            System.out.println("[corruptEx5] SUCCEEDED.");
        
        }

        if (!(Hamming.corrupt(nullEx3,6) == null)) {
            System.out.println("[corruptEx6] FAILED.");
        }
        else {
            System.out.println("[corruptEx6] SUCCEEDED.");        
        }       

        if(!(Hamming.corrupt(codeEx1,8) == null)) {
            System.out.println("[corruptEx7] FAILED.");
        }
        else {
            System.out.println("[corruptEx7] SUCCEEDED.");        
        }  
        
        // encode testers

        if (!(Hamming.encode(encodeEx1).equals("1010101"))) {
            System.out.println("[encodeEx1] FAILED.");
        }
        else {
            System.out.println("[encodeEx1] SUCCEEDED.");
        }

        if (!(Hamming.encode(encodeEx2).equals("1111111"))) {
            System.out.println("[encodeEx2] FAILED.");
        }
        else {
            System.out.println("[encodeEx2] SUCCEEDED.");
        }

        if (!(Hamming.encode(encodeEx3).equals("1100110"))) {
            System.out.println("[encodeEx3] FAILED.");
        }
        else {
            System.out.println("[encodeEx3] SUCCEEDED.");
        }

        if (!(Hamming.encode(nullEx1) == null)) {
            System.out.println("[encodeEx4] FAILED.");
        }
        else {
            System.out.println("[encodeEx4] SUCCEEDED.");
        }

        if (!(Hamming.encode(nullEx2) == null)) {
            System.out.println("[encodeEx5] FAILED.");
        }
        else {
            System.out.println("[encodeEx5] SUCCEEDED.");
        
        }

        if (!(Hamming.encode(nullEx3) == null)) {
            System.out.println("[encodeEx6] FAILED.");
        }
        else {
            System.out.println("[encodeEx6] SUCCEEDED.");        
        }  

        // decode testers

        if (!(Hamming.decode(codeEx1).equals("1101"))) {
            System.out.println("[decodeEx1] FAILED.");
        }
        else {
            System.out.println("[decodeEx1] SUCCEEDED.");
        }

        if (!(Hamming.decode(codeEx2).equals("1111"))) {
            System.out.println("[decodeEx2] FAILED.");
        }
        else {
            System.out.println("[decodeEx2] SUCCEEDED.");
        }

        if (!(Hamming.decode(codeEx3).equals("0110"))) {
            System.out.println("[decodeEx3] FAILED.");
        }
        else {
            System.out.println("[decodeEx3] SUCCEEDED.");
        }

        if (!(Hamming.decode(nullEx1) == null)) {
            System.out.println("[decodeEx4] FAILED.");
        }
        else {
            System.out.println("[decodeEx4] SUCCEEDED.");
        }

        if (!(Hamming.decode(nullEx2) == null)) {
            System.out.println("[decodeEx5] FAILED.");
        }
        else {
            System.out.println("[decodeEx5] SUCCEEDED.");
        
        }

        if (!(Hamming.decode(nullEx3) == null)) {
            System.out.println("[decodeEx6] FAILED.");
        }
        else {
            System.out.println("[decodeEx6] SUCCEEDED.");        
        }  
    }
}
