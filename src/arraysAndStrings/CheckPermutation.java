package arraysAndStrings;

import java.util.Arrays;

public class CheckPermutation {
//    static boolean isPermutation(String s1, String s2){
//        int len1=s1.length(),len2=s2.length();
//        if(len1!=len2) return false;
//        char[] charS1=s1.toCharArray(); //n
//        char[] charS2=s2.toCharArray(); //n
//        Arrays.sort(charS1);//nlogn
//        Arrays.sort(charS2);//nlogn
//        for(int i=0;i<len1;i++){ //n
//            if(charS1[i]!=charS2[i]) return false;
//        }
//        return true;
//    }

    static boolean isPermutation(String s1, String s2){
        int len1=s1.length(),len2=s2.length();
        if(len1!=len2) return false;
        int[] intS1=new int[130];
        int[] intS2=new int[130];
        for(int i=0;i<len1;i++){    //n
            intS1[(int)s1.charAt(i)]++;
            intS2[(int)s2.charAt(i)]++;
        }
        for(int i=0;i<128;i++){     //n
            if (intS1[i]!=intS2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("asdfsafsa","fdaassfas"));
    }
}
