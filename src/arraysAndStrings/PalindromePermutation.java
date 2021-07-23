package arraysAndStrings;

public class PalindromePermutation {
    //book solution
    static boolean isPermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    /* Create a bit vector for the string. For each letter with value i, toggle the 7 * ith bit. */
    static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /* Toggle the ith bit in the integer. */
    static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= mask;
        }
        return bitVector;
    }


    /* Check that exactly one bit is set by subtracting one from the integer and ANDing it with the original integer. */
    static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }


    //my solution
    public static boolean isPalindromePermutation(String s) {
        s = s.toLowerCase();
        s = removeAllSpaces(s);
        int[] letterOccurrence = new int[32];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            letterOccurrence[s.charAt(i) - 'a']++;
        }
        if (len % 2 == 0) { //even length-> no character can occur odd times
            for (int i = 0; i < 32; i++) {
                if (letterOccurrence[i] % 2 != 0) return false;
            }
        } else { //odd length-> only one character can occur odd time
            boolean oneCharWithOddOccurenceExists = false;
            for (int i = 0; i < 32; i++) {
                if (letterOccurrence[i] % 2 != 0 && oneCharWithOddOccurenceExists == true) return false;
                if (letterOccurrence[i] % 2 != 0) oneCharWithOddOccurenceExists = true;
            }
        }
        return true;
    }



    static String removeAllSpaces(String s) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("   Ta  Act Coa    A"));
    }
}
