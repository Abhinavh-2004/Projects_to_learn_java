import java.util.Random;
import java.util.Scanner;

public class Game_RPS {
    public static String[] choices = {"Rock","Paper","Scissor"};

    public static String getChoice(){
        Random rand = new Random();
        int c = rand.nextInt(choices.length);
        return choices[c];

    }

    public static String getUserChoice() {
        Scanner inp = new Scanner(System.in);
        int user;


        while (true) {
            System.out.print("Enter a number between 1 and 3: ");
            user = inp.nextInt();

            if (user >= 1 && user <= 3) {
                break;
            } else {
                System.out.println("Enter a valid number between 1 and 3.");
            }
        }

        String res = choices[user - 1];
        return res;
    }

    public static void displayChoices(){
        for(int i=0; i < choices.length; i++){
            System.out.printf("%s\t",choices[i]);
        }
        System.out.printf("\n");
    }


    public static void main(String[] args){
        String option = "";
        do{
            String comp = getChoice();
            Scanner inside = new Scanner(System.in);
            displayChoices();

            //System.out.println("Enter 1,2 or 3");
            String userString = getUserChoice();


            if(comp.equals(userString)){
                System.out.printf("\n%s == %s\n",comp,userString);
                System.out.println("YOU LOST");
            }
            else{
                System.out.printf("\n%s != %s\n",comp,userString);
                System.out.printf("want to keep playing?: ");
                option = inside.nextLine();
            }
        }while(option.equals("yes") || option.equals("Yes") || option.equals("y") || option.equals("Y"));
    }

}
