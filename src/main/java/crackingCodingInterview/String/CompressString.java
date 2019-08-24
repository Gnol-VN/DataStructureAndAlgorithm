package crackingCodingInterview.String;

public class CompressString {
    public static void main(String[] args) {
//        String src = "aabbbcccacacacaca";
//        String compressed = compress(src);
//        System.out.println(compressed);
        String src = "aaaaab";
        int n = src.length();
        char[] arr = src.toCharArray();
        String compress = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char char1 = arr[i];
            int count = 1;
            for (int j = i+1; j <n ; j++) {
                if(arr[j] == char1){
                    count++;
                    i = j;
                }
                else break;
            }
            stringBuilder.append(char1).append(count);
        }
        System.out.println(stringBuilder.toString());
        if(compress.length() > src.length()) System.out.println(false);
    }

    static String compress(String src){
        String result = "";
        String initString = src;
        StringBuffer stringBuffer = new StringBuffer();
        if(src.length() == 0) return null;
        int length = src.length();


        while(src.length() != 0){
            char c = src.charAt(0);
            int count = countSimilarity(1,0,src);
            stringBuffer.append(c);
            stringBuffer.append(count);
            src = src.substring(count);
        }

        result =  stringBuffer.toString();
        if(result.length() > initString.length()) return initString;
        else return result;
    }

    static int countSimilarity(int count, int index, String src){
        try{
            if(src.charAt(index) == src.charAt(index+1)){
                count++;
                index++;
                count = countSimilarity(count,index,src);
            }
            return count;
        }catch (Exception e){

        }
        return 1;
    }
}
