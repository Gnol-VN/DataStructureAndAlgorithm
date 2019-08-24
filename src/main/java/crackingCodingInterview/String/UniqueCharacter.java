package crackingCodingInterview.String;


public class UniqueCharacter {
    public static void main(String[] args) {
        String a = "Long Do";
        if(a.length() > 256) System.out.println("False because ASCII only contains 256 unique character");
        System.out.println(isUnique1(a));
        System.out.println(isUnique2(a));
    }

    //Solution 1: Compare every character of the string to every other character of the string
    //O(n^2)
    static boolean isUnique1( String a){
        char[] charArr = a.toCharArray();
        for (int i = 0; i < charArr.length -1; i++) {
            for (int j = i+1; j < charArr.length ; j++) {
                if(charArr[i] == charArr[j]){
                    return false;
                }
            }
        }
        return true;
    }

    //Solution 2: Make a boolean array
    //O(n)
    static boolean isUnique2(String a){
        int[] charset = new int[256];
        for (int i = 0; i < a.length(); i++) {
            int val = a.charAt(i);
            if(charset[val] != 0){
                return false;
            }
            charset[val] = val;
        }
        return true;
    }
}

