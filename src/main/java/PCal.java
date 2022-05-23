import java.util.Scanner;

public class PCal {
    public static void main(String[] args) {
        loadCalc();
    }


public static void loadCalc(){

    Scanner scan = new Scanner(System.in);

    System.out.println("}}}}}Welcome to Ryan's paint calculator!{{{{{");
    System.out.println("Please mention the measurements of your wall:");

    //Below finds out user input.

    System.out.println("What is the length of your wall?");
    double len = Double.valueOf(scan.nextLine());
    System.out.println("What is the width of your wall?");
    double wid = Double.valueOf(scan.nextLine());
    System.out.println("What is the height of your wall?");
    double hei = Double.valueOf(scan.nextLine());

    System.out.println("The final cost of painting a wall that's " + len + " long, " + wid + " wide and " + hei + " high is: " + cost(len, wid, hei) + " pounds.");
    System.out.println("Would you like to measure another wall?");
    double answer = Double.valueOf(scan.nextLine());

    //Below checks if the user wants to restart the process.

    if (answer == 1) {
        System.out.println("The process will now restart...");
        loadCalc();
    } else {
        System.out.println("The program will now close.");
    }
}


    public static double cost(double len, double wid, double hei){

       //Below calculates cost of paint in comparison to gallons.

        double wArea;
        double pounds = 25; // cost of £ per gallon.
        wArea = 2*len*hei + 2*wid*hei;
        double paintQuantity = quantity(wArea);
        System.out.println("The wall size is " + wArea + " square ft, " + "you will require " + paintQuantity + " gallons.");
        double finalCost = pounds * paintQuantity;

        return wArea;
    }


    public static double quantity(double tArea){

       //Below finds out quantity of paint needed.

        Scanner scan = new Scanner(System.in);
        double sqfPG = 350; //Square foot per gallon I think.


        System.out.println("How many sockets are there on the wall?");
        double socketCount = Double.valueOf(scan.nextLine());
        socketCount = socketCount * 0.8; //average UK wall socket size.

        System.out.println("How many windows are there?");
        double windowCount = Double.valueOf(scan.nextLine());
        windowCount = windowCount * 13.5; //average UK window frame size.

        System.out.println("How many doors are there?");
        double doorCount = Double.valueOf(scan.nextLine());
        doorCount = doorCount * 0.72; //average UK door size.

        return tArea - socketCount - windowCount - doorCount/ sqfPG;
    }


}
