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
        //operat�r nummer
        System.out.println("//PlEaSe WrItE yOuR oPeRaToR nUmBeR:");
        dtoset.setOperatorId(Integer.parseInt(readLine()));
        //operat�rs navn findes i databasen
        // Navnet vises p� v�gten.
        System.out.println("iS tHiS nAmE cOrReCt?:");
        if (readLine().equals("no")) {
            System.out.println("!!WRONG!! pLeAsE tYpE iN a VaLiD nUmBeR:");
        } else {
            //g� videre i programmet
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

        //metode til at f� af vide hvis der stadigv�k er ting p� v�gten
        //if else statement vedr om v�gten er == 0
        //hvis v�gten er nul s� nul stilles v�gten.

        placeContainer();
    }

    private void placeContainer() {
        System.out.println("Please place an empty container. \n Please type 'OK' when done.");
        readLine();
        if (!(readLine().equals("OK")) && !(readLine().equals("ok")) && !(readLine().equals("Ok"))) {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, bye bish");
        }
        //hvis v�gten viser tal - brug if else statement med responds
        //v�gten registeres

        System.out.println("The weight will self destruct in...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("3...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("2...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("1...");
        TimeUnit.SECONDS.toSeconds(2);
        //v�gten nulstilles bagefter
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

        //hvis v�gten viser tal - brug if else statement med responds
        //Netto v�gten registeres

        //v�gten nulstilles
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

//Indtast operat�r nummer
//      - indtaster nummer

 */