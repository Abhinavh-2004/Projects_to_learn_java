import java.sql.SQLOutput;
import java.util.*;

public class Hangman {
    public static final String[] choices = {
            "apple", "bread", "candy", "dance", "earth", "flame", "grape", "honey", "igloo", "jolly",
            "knock", "lemon", "mango", "nacho", "ocean", "piano", "queen", "robot", "smile", "tiger",
            "ultra", "vivid", "waltz", "xenon", "yacht", "zebra", "adobe", "brave", "chaos", "drift",
            "eagle", "fiber", "giant", "happy", "index", "jumps", "kites", "lucky", "music", "noble",
            "olive", "pearl", "quiet", "rough", "stone", "trail", "under", "valve", "whale", "xerox",
            "youth", "zesty", "abode", "blaze", "cloud", "drove", "early", "fable", "grill", "harry",
            "ivory", "jelly", "karma", "laser", "mocha", "ninja", "orbit", "party", "quill", "raven",
            "shear", "trout", "upper", "voice", "wider", "xylan", "yield", "zonal", "angel", "blush",
            "creek", "dealt", "elope", "frost", "glide", "hover", "irate", "jewel", "knave", "leech",
            "metal", "niche", "otter", "prime", "quack", "rider", "shiny", "trust", "unity", "viper"
    };
    private static int charCount = 0;




    public static String chooseChoice(){
        Random rand = new Random();
        int index = rand.nextInt(choices.length);
        return choices[index];
    }

    public static int getCharCount(){
        return charCount;
    }



    public static void displayCharacter(char ch, char[] computer,char[] userValid){
        for(int i = 0 ; i < computer.length; i++){
            if(ch == computer[i]){
                userValid[i] = computer[i];
                charCount++;

            }

        }
        System.out.println(userValid);
    }

    public  static  void printHanger(int chances){

        if(chances == 5){
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n");
        }
        if(chances == 4){
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n");
        }
        if(chances == 3){
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n");
        }
        if(chances == 2){
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n");
        }
        if(chances== 1){
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========\n");
        }
        if(chances == 0){
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "=========\n");
        }
    }



    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        String comp;
        comp = chooseChoice();

        char[] computer = comp.toCharArray();
        for(char ch: computer){
            if(!(set.contains(ch))){
                set.add(ch);
            }
        }
        Scanner inp = new Scanner(System.in);
        int chances = 6;
        char[] userValid = new char[comp.length()];
        Arrays.fill(userValid, '_');
        int cCount = 0;
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========\n");
        while(chances > 0){

            cCount = getCharCount();
            if( cCount == computer.length){
                System.out.println("Bingo");
                break;
            }
            System.out.printf("Enter a character as guess: ");

            String user = inp.next();
            System.out.printf("\n");
            if(user.length() > 1){
                System.out.println("No, give me a character");
                continue;
            }
            if(set.contains(user.charAt(0))){
                displayCharacter(user.charAt(0),computer,userValid);
            }
            else {

                System.out.printf("%d chances left\n",chances-1);
                chances--;
                printHanger(chances);
            }
        }



    }
}
