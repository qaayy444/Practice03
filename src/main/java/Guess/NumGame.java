package Guess;

import java.util.Random;
import java.util.Scanner;

public class NumGame {
    public static void main(String[] args) {
        //在kotlin裡面，in為關鍵字，使用時需在in兩旁加入重音符號=`in`
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int input=0;
        int answer=random.nextInt(10)+1; //1~10
        System.out.println(answer);
        while (input!=answer)
        {
            System.out.println("Plz input num");
            input=scanner.nextInt();
            if(input>answer)
                System.out.println("Lower");
            else if(input<answer)
                System.out.println("Higher");
        }
        System.out.println("Final Answer!");
    }

}
