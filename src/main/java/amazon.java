import java.util.ArrayList;
import java.util.Arrays;

public class amazon {
    // with exactly k unique characters
    int countkDist(String inputString, int num)
    {
        int returnResult = 0;
        int cnt[] = new int[26];
        for (int i = 0; i < inputString.length(); i++)
        {
            int dist_count = 0;
            Arrays.fill(cnt, 0);
            for (int j=i; j<inputString.length(); j++)
            {
                if (cnt[inputString.charAt(j) - 'a'] == 0)
                    dist_count++;
                cnt[inputString.charAt(j) - 'a']++;
                if (dist_count == num)
                    returnResult++;
            }
        }
        return returnResult;
    }

    // Driver Program
    public static void main(String[] args)
    {
        amazon ob = new amazon();
        String ch = "abafg";
        int k = 2;
        System.out.println(ob.countkDist(ch, k));
    }
}