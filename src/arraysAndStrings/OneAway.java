package arraysAndStrings;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
//similar problem is EditDistance
//https://www.geeksforgeeks.org/edit-distance-dp-5/
public class OneAway {
    //book solution 2
    static boolean  oneEditAway(String first, String second){
        if(Math.abs(first.length()-second.length())>1) return false;
        /* Get shorter and longer string.*/
        String small,large;
        if(first.length()<second.length()){
            small=first;
            large=second;
        } else{
            small=second;
            large=first;
        }
        int i1=0,i2=0;
        boolean foundDiff=false;
        while(i2<large.length()&&i1<small.length()){
            if(small.charAt(i1)!=large.charAt(i2)){
                /* Ensure that this is the first difference found.*/
                if(foundDiff) return false;
                foundDiff=true;
                if(small.length()==large.length()){//on replace , move shorter pointer
                    i1++;
                }
            }else{
                i1++;
            }
            i2++;
        }
        return true;
    }

    //book solution 1
//    static boolean onEditAway(String first, String second){
//        if(first.length()==second.length()) oneEditReplace(first,second);
//        else if(first.length()+1==second.length()) oneEditInsert(first,second);
//        else if(first.length()==second.length()+1) oneEditInsert(second, first);
//        return false;
//    }

    static boolean oneEditReplace(String s1, String s2){
        boolean foundDiff=false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if (foundDiff) return false;
            }
            foundDiff=true;
        }
        return true;

    }
    //check if you can insert a character into s1 to make s2
    static boolean oneEditInsert(String small, String large){
        int i1=0,i2=0;
        while (i2<large.length()&& i1<small.length()){
            if(small.charAt(i1)!=large.charAt(i2)){
                if(i1!=i2) {return false;}
                i2++;
            }else{
                i1++;
                i2++;
            }
        }
        return true;
    }


    // my Solution
    static boolean oneAway(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (Math.abs(l1 - l2) > 1) return false;
        int[][] dp = new int[l2 + 1][l1 + 1];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if(i-1<0 && j-1<0){
                        dp[i][j] = 1;
                    }
                    else if (j - 1 < 0) {
                        dp[i][j] = Math.max(0, dp[i - 1][j]) + 1;
                    } else if (i - 1 < 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], 0) + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + 1;
                    }
                } else {
                    if(i-1<0 && j-1<0){
                        dp[i][j] = 0;
                    }
                    else if (j - 1 < 0 ) {
                        dp[i][j] = Math.max(0, dp[i - 1][j]) ;
                    } else if (i - 1 < 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], 0) ;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        if (Math.min(l1, l2) - dp[l1 - 1][l2 - 1] > 1) return false;
        else return true;
    }

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "bale"));
    }
}
