package presentation;

import dal.IWeightDAO;
import dto.WeightDTO;
import logic.IController;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TUI implements IPresentation {

    private IController controller;
    private WeightDTO dtoset = new WeightDTO();
    private static Scanner keyboard = new Scanner(System.in);

    @Override
    public void setController(IController controller) {
        this.controller = controller;
    }


    private String readLine() {
        getOperatorNumber();
        return keyboard.nextLine();
    }

    private void getOperatorNumber() {
        readLine();
        //operatør nummer
        System.out.println("//PlEaSe WrItE yOuR oPeRaToR nUmBeR:");
        dtoset.setOperatorId(Integer.parseInt(readLine()));
        //operatørs navn findes i databasen
        // Navnet vises på vægten.
        System.out.println("iS tHiS nAmE cOrReCt?:");
        if (readLine().equals("no")) {
            System.out.println("!!WRONG!! pLeAsE tYpE iN a VaLiD nUmBeR:");
        } else {
            //gå videre i programmet
            getBatchNumber();
        }
    }

    //TODO: No logic in presentation implementation, can not have number 1000 and 9999 present here.
    private void getBatchNumber() {
        System.out.println("Please type in your batch number between 1000 and 9999");
        readLine();
        if (Integer.parseInt(readLine()) < 1000 && Integer.parseInt(readLine()) < 9999) {
            System.out.println("Please write a reasonable number between 1000 and 9999");
        } else {
            instructions();
        }
    }


    private void instructions() {
        System.out.println("Please any kind of objects off the weight \n Type 'OK' when you're done");
        readLine();
        if (!(readLine().equals("OK")) && !(readLine().equals("ok")) && !(readLine().equals("Ok"))) {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, byw bish");
        }

        //metode til at få af vide hvis der stadigvæk er ting på vægten
        //if else statement vedr om vægten er == 0
        //hvis vægten er nul så nul stilles vægten.

        placeContainer();
    }

    private void placeContainer() {
        System.out.println("Please place an empty container. \n Please type 'OK' when done.");
        readLine();
        if (!(readLine().equals("OK")) && !(readLine().equals("ok")) && !(readLine().equals("Ok"))) {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, bye bish");
        }
        //hvis vægten viser tal - brug if else statement med responds
        //vægten registeres

        System.out.println("The weight will self destruct in...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("3...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("2...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("1...");
        TimeUnit.SECONDS.toSeconds(2);
        //vægten nulstilles bagefter
        System.out.println("The weight now shows '0'");
        TimeUnit.SECONDS.toSeconds(2);
        nettoWeight();
    }

    private void nettoWeight() {
        System.out.println("Now let's play a game...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("Please place a container with a item of your choice inside it. \n Please type 'OK' when finished");
        readLine();
        if (!(readLine().equals("OK")) && !(readLine().equals("ok")) && !(readLine().equals("Ok"))) {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, bye bish");
        }

        //hvis vægten viser tal - brug if else statement med responds
        //Netto vægten registeres

        //vægten nulstilles
        System.out.println("Are you OK with the weight resetting? Then please type 'YES'");
        readLine();
        if (readLine().equals("YES") && readLine().equals("yes") && readLine().equals("Yes")) {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, bye bish");
        }
    }
}










 /*


    private void display_menu() {
        System.out.println("#######################");
        System.out.println("# Menu:               #   ");
        System.out.println("# 1.                  #   ");
        System.out.println("# 2.                  #   ?????????????????");
        System.out.println("# 3.                  #  ??  ??  ??  ??  ????????");
        System.out.println("# 4.                  #  ??  ? ?? ?  ? ?? ?????? ??");
        System.out.println("# 5.                  #  ?  ?? ? ??  ? ? ??????? ??");
        System.out.println("#                     #  ?  ?? ? ?? ???   ?????? ?? ");
        System.out.println("#                     #  ? ??  ?? ? ? ??  ?????? ??");
        System.out.println("#                     #  ? ??  ?? ? ? ??  ?????? ??");
        System.out.println("#                     #\n# Select:             #");
        System.out.println("#######################");


    }

}

//Indtast operatør nummer
//      - indtaster nummer

 */