package arraysAndStrings;

public class PalindromePermutation {
    public static boolean isPalindromePermutation(String s){
        s=s.toLowerCase();
        s=removeAllSpaces(s);
        int[] letterOccurrence=new int[32];
        int len=s.length();
        for(int i=0;i<len;i++){
            letterOccurrence[s.charAt(i)-'a']++;
        }
        if(len%2==0){ //even length-> no character can occur odd times
            for(int i=0;i<32;i++){
                if(letterOccurrence[i]%2!=0) return false;
            }
        }else{ //odd length-> only one character can occur odd time
            boolean oneCharWithOddOccurenceExists=false;
            for(int i=0;i<32;i++){
                if(letterOccurrence[i]%2!=0 && oneCharWithOddOccurenceExists==true) return false;
                if(letterOccurrence[i]%2!=0 ) oneCharWithOddOccurenceExists=true;
            }
        }
        return true;
    }
    static String removeAllSpaces(String s){
        int len=s.length();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=' '){
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("   Ta  Act Coa    A"));
    }
}
