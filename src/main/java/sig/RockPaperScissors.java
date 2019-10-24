package sig;

public class RockPaperScissors {
    public static void main(String[] args) {
        String G = "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP";
        char[] arr = G.toCharArray();
        int potentialScore = 0;
        int maxScore = 0;

        //Assume Franco plays Rock
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'R'){
                potentialScore++;
            }else if(arr[i] == 'S'){
                potentialScore+=2;
            }
        }
        if(potentialScore >=maxScore) maxScore = potentialScore;
        potentialScore = 0 ;

        //Assume Franco plays Scissor
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'S'){
                potentialScore++;
            }else if(arr[i] == 'P'){
                potentialScore+=2;
            }
        }
        if(potentialScore >=maxScore) maxScore = potentialScore;
        potentialScore = 0 ;

        //Assume Franco plays Paper
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P'){
                potentialScore++;
            }else if(arr[i] == 'R'){
                potentialScore+=2;
            }
        }
        if(potentialScore >=maxScore) maxScore = potentialScore;
        System.out.println(maxScore);
    }
}
