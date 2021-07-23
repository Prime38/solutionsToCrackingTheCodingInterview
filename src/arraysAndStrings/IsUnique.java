package arraysAndStrings;

import java.util.Arrays;

//Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
//        cannot use additional data structures?
public class IsUnique {
//    public static boolean isUnique(String inputString){ //O(n^2)
//        int length=inputString.length();
//        for(int i=0;i<length-1;i++){ // n
//            for(int j=i+1;j<length;j++){ //n
//                if(inputString.charAt(i)==inputString.charAt(j)){
//                    return  false;
//                }
//            }
//        }
//        return true;
//    }
//    public static boolean isUnique(String inputString){
//        int length=inputString.length();
//        char[] tempArray=inputString.toCharArray();
//        Arrays.sort(tempArray);// nlogn
//        for(int i=0;i<length-1;i++){ // n
//            if(tempArray[i]==tempArray[i+1]){
//                return false;
//            }
//        }
//        return true;
//    }
//    boolean isUnique(String str) {//using boolean array
//        if (str.length() > 128) return false;//128 in case of ASCII
//
//        boolean[] char_set= new boolean[128];
//        for (int i= 0; i < str.length(); i++) {
//            int val= str.charAt(i);
//            if (char_set[val]) {//Already found this char in string
//                 return false;
//             }
//            char_set[val] = true;
//        }
//        return true;
//    }

    public static boolean isUnique(String str) {//using bit manipulation -> only valid for either uppercase or lowercase characters
        if (str.length() > 256) {
            return false;
        }
        long checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'A';
            System.out.println(checker+ " "+ val+" "+(1 << val)+" "+(checker & (1 << val))+" "+(checker | (1 << val)));
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("asdxghzcZv"));
    }

    void print(Object obj){
        System.out.println(obj);
    }
}
