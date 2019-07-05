package crackingCodingInterview.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringExercise {
    public static void main(String[] args) {
        System.out.println(nonRepChar("GeeksforGeeks"));
        System.out.println(nonRepChar1("Geek"));
        System.out.println(oneEdit("Gees","Gee"));
        System.out.println(oneEdit("Geesf","Geeksf"));
        System.out.println(oneEdit("Peak","Geek"));
        System.out.println(oneEdit("Peek","Geek"));
        longestCommon("abcdefghi","badefgab");
        System.out.println("Palindrome: " + isPalindrome(19991));
    }

    static char nonRepChar(String str){
        if(str.isEmpty()) return '0';
        List<CharOcc> occList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(occList.isEmpty()){
                occList.add(new CharOcc(c));
                continue;
            }
            boolean increased = false;
            for (CharOcc charOcc:occList) {
                if(charOcc.getC() == c){
                    increased = true;
                    charOcc.setOccurrance(charOcc.getOccurrance() +1);
                    break;
                }
            }

            if (increased == false) occList.add(new CharOcc(c));
        }

        for(CharOcc charOcc : occList){
            if(charOcc.getOccurrance() == 1){
                return charOcc.getC();
            }
        }
        return '0';
    }
    static Character nonRepChar1(String str){
        for (int i = 0; i < str.length(); i++) {
            boolean existed = false;
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)){
                    existed = true;
                    break;

                }
            }
            if(existed == false) return str.charAt(i);
        }
        return '0';
    }
    static class CharOcc{
        private char c;
        private int occurrance;
        public CharOcc(char c){
            this.c = c;
            occurrance = 1;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getOccurrance() {
            return occurrance;
        }

        public void setOccurrance(int occurrance) {
            this.occurrance = occurrance;
        }
    }
    static boolean oneEdit(String str1, String str2){
        //Nếu giống nhau thì return luôn false
        if(str1.equals(str2)) return false;
        //String2 is always longer than String1 for better manipulation
        if(str1.length() > str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int editTimes = 0;
        int n = str2.length() > str1.length()? str2.length():str1.length();
        if(str2.length() - str1.length() > 1) return  false;
        for (int i = 0; i < n; i++) {
            //Nếu chạy đến length - 1 thì 100% là one edit, bởi vì đã loại trường hợp 2 string giống hệt nhau, suy ra ký tự cuối chắc chắn khác nhau
            if(i == str1.length()-1) return true;

            //So sánh từng chữ đôi một  trong 2 string
            if(str1.charAt(i) != str2.charAt(i)){
                if(i == str1.length()-1) return true;
                //Nếu độ dài bằng nhau -> chắc chắn sai 1 chữ -> phủ tất cả các chữ từ 0 đến i giống hệt nhau ở 2 string, rồi tiếp tục kiểm tra từ i đến hết
                if(str1.length() == str2.length()){
                    //Lấy phần rightside của string1 từ vị trí conflict i
//                    string 1 = copy string 2 từ đầu 0 đến vị trí conflict +1
//                            sau đó ghép str1 với right side
                    String rightside= str1.substring(i+1);
                    str1 = str2.substring(0,i+1);
                    str1 = str1.concat(rightside);
                    editTimes++;
                    if(editTimes > 1) return false;
                }

                //Nếu độ dài không bằng nhau -> thiếu 1 chữ, chèn vào
                else if (str1.charAt(i ) == str2.charAt(i + 1)) {
                    String rightside = str1.substring(i);
                    str1 = str2.substring(0, i+1);
                    str1= str1.concat(rightside);
                    editTimes++;
                    if(editTimes > 1) return false;
                }

            }
        }
        if(editTimes > 1) return false;
        else return true;
    }
    static void longestCommon(String str1, String str2){
        List<String> listCommon = new ArrayList<>();
        if(str1.length() > str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                boolean flag = false; //increase performance
                int m = i, n = j;
                while(str1.charAt(m) == str2.charAt(n)){
                    flag = true;
                    m++;
                    n++;
                    if(m>str1.length() -1 || n > str2.length()-1) break;
                }
                if(flag == false) continue;
                listCommon.add(str1.substring(i, m));
            }
        }

        System.out.println();
        System.out.println();

    }

    static boolean isPalindrome(int n){
        if(n<2) return false;
        for (int i = 2; i < n; i++) {
            if(n%i == 0) return false;
        }
        String str = String.valueOf(n);
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length/2; i++) {
            if(charArr[i] != charArr[charArr.length-i-1]) return false;
        }
        return true;
    }

}

