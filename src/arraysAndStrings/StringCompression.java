package arraysAndStrings;

public class StringCompression {
    static String compress(String s){
        StringBuilder ans=new StringBuilder();
        int len=s.length();
        for(int i=0;i<len;){
            char ch=s.charAt(i);
            ans.append(ch);
            int temp=0;
            while(i<len && ch==s.charAt(i)){
                temp++;
                i++;
            }
            ans.append(temp);
        }
        if(ans.toString().length()==len) return s;
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaassssssdddddaaad"));
    }
}
