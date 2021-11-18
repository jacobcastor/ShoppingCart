/**
 * This class is for use with ShoppingCart.java and ItemToPurchase.java and acts as a main driver
 * 
 * @author Jacob Castor
 * @version June 3rd, 2021
 *
 */
// *********** NO TEST CODE IS NEEDED, ALL INFORMATION IS USER INPUT SO RUN CODE TO TEST**********

import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args) {

        Scanner userIn = new Scanner(System.in);

        //Stores the user's name and the date
        String userName;
        String date;

        //Used to determine if the program exits
        boolean userQuit = false;

        //Gets name and date
        System.out.println("Welcome to the Shopping Cart!");
        System.out.print("Please enter your name: ");
        userName = userIn.nextLine();
        System.out.print("Please enter the date: ");
        date = userIn.nextLine();

        //Creates shopping cart object based on name and date above
        ShoppingCart sc = new ShoppingCart(userName, date);

        //Loops until user quits the program (entering 6)
        while(!userQuit)
        {  
            //Variable for menu choice and displays the menu choices
            int menuChoice = 0;
            System.out.println("\n\nMENU");
            System.out.println("Please select a menu choice:\n" 
                                + "\t1. Add item\n"
                                + "\t2. Remove item\n"
                                + "\t3. Modify item\n"
                                + "\t4. Print item descriptions\n"
                                + "\t5. Print shopping cart\n"
                                + "\t6. Quit program\n");
            menuChoice = userIn.nextInt();
            userIn.nextLine();

            //Variable to store the name of the item that the user enters
            //Placed outside of switch to prevent errors
            String itemName;

            //Determines what to do based on the user's menu choice
            switch (menuChoice)
            {
                //Steps to add item
                case 1:
                    String name;
                    int price;
                    int quantity;
                    String description;

                    System.out.println("\nADD ITEM TO CART");
                    System.out.println("Enter the item name:");
                    name = userIn.nextLine();
                    System.out.println("Enter the item description:");
                    description = userIn.nextLine();
                    System.out.println("Enter the item price:");
                    price = userIn.nextInt();
                    System.out.println("Enter the item quantity:");
                    quantity = userIn.nextInt();

                    sc.addItem(name, price, quantity, description);
                    break;

                //Steps to remove item
                case 2:
                    System.out.println("\nREMOVE ITEM FROM CART");
                    System.out.println("Enter the name of item to remove:");
                    itemName = userIn.nextLine();
                    sc.removeItem(itemName);
                    break;
                
                //Steps to modify item
                case 3:
                    System.out.println("\nMODIFY ITEM IN CART");
                    System.out.println("Enter the name of item to remove:");
                    itemName = userIn.nextLine();
                    sc.modifyItem(itemName, userIn);
                    break;
                
                //Steps to print item descriptions
                case 4:
                    sc.printDescriptions();
                    break;
                
                //Steps to print the shopping cart
                case 5:
                    sc.printTotal();
                    break;

                //Quits program
                case 6:
                    userQuit = true;
                    break;
                
                //Displays if 1-6 isnt entered when prompted
                default:
                    System.out.println("\nInvalid input");
                    break;
            }
        }
    }
}
