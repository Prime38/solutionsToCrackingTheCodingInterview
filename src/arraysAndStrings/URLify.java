package arraysAndStrings;

public class URLify {
    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
                }
            }

        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength]='\0';
        for (i = trueLength - 1; i >= 0; i-- ) {
            if (str[i] == ' ') {
                str[index- 1] ='0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
                } else {
                str[index - 1] = str[i];
                index--;
                }
            }
        }


    public static String urlify(String s){
        s=s.trim();
        char[] chars=s.toCharArray();
        int len=s.length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<len;i++){
            if(chars[i]!=' '){
                ans.append(chars[i]);
            }else{
                ans.append("%20");
                while(chars[i+1]==' '){
                    i++;
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(urlify("Mr    John Smith  "));
    }
}
