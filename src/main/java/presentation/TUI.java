package presentation;

import dal.IWeightDAO;
import dto.WeightDTO;
import logic.IController;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TUI implements IPresentation {

    private IController controller;
    //TODO: Does not need a DAO in current implementation
    private IWeightDAO daoset;
    private WeightDTO dtoset = new WeightDTO();
    //TODO: Should probably be private
    static Scanner keyboard = new Scanner(System.in);

    @Override
    public void setController(IController controller) {
        this.controller = controller;
    }


    public String readLine() {
        getOperatorNumber();
        return keyboard.nextLine();
    }

    public void getOperatorNumber() {
        Integer.parseInt(readLine());
        //operat�r nummer
        //                    TODO: My eyes
        System.out.println("//PlEaSe WrItE yOuR oPeRaToR nUmBeR:");
        dtoset.setOperatorId(Integer.parseInt(readLine()));
        //operat�rs navn findes i databasen
        // Navnet vises p� v�gten.
        System.out.println("iS tHiS nAmE cOrReCt?:");
        //TODO: Don't compare strings with ==
        if (readLine() == "no") {
            //TODO: Do you mean type in a valid ID?
            System.out.println("!!WRONG!! pLeAsE tYpE iN a VaLiD nAmE:");
        } else {
            //g� videre i programmet
            getBatchNumber();
        }
    }

    //TODO: No logic in presentation implementation, can not have number 1000 and 9999 present here.
    public void getBatchNumber() {
        System.out.println("Please type in your batch number between 1000 and 9999");
        Integer.parseInt(readLine());
        if (Integer.parseInt(readLine()) < 1000 && Integer.parseInt(readLine()) < 9999) {
            System.out.println("Please write a reasonable number between 1000 and 9999");
        } else {
            instructions();
        }
    }


    public void instructions() {
        System.out.println("Please any kind of objects off the weight \n Type 'OK' when you're done");
        //TODO: vvvvvvvv The truth is yellow
        Integer.parseInt(readLine());
        //TODO: No == or != operators on string comparisons
        if (readLine() != "OK" && readLine() != "ok" && readLine() != "Ok") {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, byw bish");
        } else {

        }

        //metode til at f� af vide hvis der stadigv�k er ting p� v�gten
        //if else statement vedr om v�gten er == 0
        //hvis v�gten er nul s� nul stilles v�gten.

        placeContainer();
    }

    public void placeContainer() {
        System.out.println("Please place an empty container. \n Please type 'OK' when done.");
        Integer.parseInt(readLine());
        if (readLine() != "OK" && readLine() != "ok" && readLine() != "Ok") {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, bye bish");
        } else {

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

    public void nettoWeight() {
        System.out.println("Now let's play a game...");
        TimeUnit.SECONDS.toSeconds(2);
        System.out.println("Please place a container with a item of your choice inside it. \n Please type 'OK' when finished");
        Integer.parseInt(readLine());
        if (readLine() != "OK" && readLine() != "ok" && readLine() != "Ok") {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, bye bish");
        } else {

        }

        //hvis v�gten viser tal - brug if else statement med responds
        //Netto v�gten registeres

        //v�gten nulstilles
        System.out.println("Are you OK with the weight resetting? Then please type 'YES'");
        Integer.parseInt(readLine());
        if (readLine() != "YES" && readLine() != "yes" && readLine() != "Yes") {
            System.out.println("Please take your business somewhere else, thank you for using 'hold 12' weight problem \n Have a nice day, bye bish");
        } else {

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