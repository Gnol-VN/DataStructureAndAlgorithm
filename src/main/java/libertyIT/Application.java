package libertyIT;

public class Application {
    public static void main(String[] args) {
        System.out.println(solution(0, 0, 1));
    }

    /*
    Algorithm: take a character with the maximum available repetition.
    If two preceding characters are identical, take a character with the second maximum available repetition
     */
    public static String solution(int A, int B, int C) {
        // Init a string builder
        StringBuilder s = new StringBuilder();

        //1. Append the first character to the string builder
        char character = findMaxRepitition(A, B, C);
        s.append(character);
        if (character == 'a') A--;
        if (character == 'b') B--;
        if (character == 'c') C--;
        if(A+B+C==0) return s.toString();

        //2. Append the second character to the string builder
        character = findMaxRepitition(A, B, C);
        s.append(character);
        if (character == 'a') A--;
        if (character == 'b') B--;
        if (character == 'c') C--;
        if(A+B+C==0) return s.toString();

        //3. Create a loop to gradually append the maximum available repetition
        int i = 2;
        while (A > 0 || B > 0 || C > 0) {
            if (s.charAt(i - 2) != s.charAt(i - 1)) {
                character = findMaxRepitition(A, B, C);
                if(character == 'd' ) return s.toString();
                s.append(character);
                if (character == 'a') A--;
                if (character == 'b') B--;
                if (character == 'c') C--;
                i++;
            } else {
                character = findSecondMaxRepitition(A, B, C, s.charAt(i-2));
                if (character == 'a' && A == 0) return s.toString();
                if (character == 'b' && B == 0) return s.toString();
                if (character == 'c' && C == 0) return s.toString();
                if(character == 'd' ) return s.toString();
                s.append(character);
                if (character == 'a') A--;
                if (character == 'b') B--;
                if (character == 'c') C--;
                i++;
            }
        }
        return s.toString();
    }

    public static char findMaxRepitition(int A, int B, int C) {
        if (A >= B && A >= C)
            return 'a';
        if (B >= A && B >= C)
            return 'b';
        if (C >= A && C >= B)
            return 'c';
        return 'd';
    }

    public static char findSecondMaxRepitition(int A, int B, int C, char character) {
        if (character == 'a') A = -1;
        if (character == 'b') B = -1;
        if (character == 'c') C = -1;
        if (A >= B && A >= C)
            return 'a';
        if (B >= A && B >= C)
            return 'b';
        if (C >= A && C >= B)
            return 'c';
        return 'd';

    }
}
