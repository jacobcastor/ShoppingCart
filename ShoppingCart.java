/**
 * This class is for the ShoppingCart class
 * 
 * @author Jacob Castor
 * @version June 3rd, 2021
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

    private String customerName;
    private String currentDate;
    ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();

    public ShoppingCart() 
    {
        this.customerName = "none";
        this.currentDate = "January 1, 2016";
    }

    public ShoppingCart(String name, String date) 
    {
        this.customerName = name;
        this.currentDate = date;
    }


    /** 
     *
     * Gets the customer name
     *
     * @return the customer name
     */
    public String getCustomerName() 
    {
        return this.customerName;
    }


    /** 
     *
     * Gets the date
     *
     * @return the date
     */
    public String getDate() 
    {
        return this.currentDate;
    }



    /** 
     *
     * Gets the number of items in cart
     *
     * @return the number of items in cart
     */
    public int getNumItemsInCart() 
    {   
        //loops through cartItems array list
        int numItems = 0;
        for(int i = 0; i < cartItems.size(); i++)
        {   
            //finds the quantity of each item and adds that to the total number of items
            numItems = numItems + cartItems.get(i).getQuantity();
        }

        return numItems;
    }


    /** 
     *
     * Gets the cost of cart
     *
     * @return the cost of cart
     */
    public int getCostOfCart() 
    {

        int total = 0;

        //loops through cartItems array list
        for(int i = 0; i < cartItems.size(); i++)
        {   
            //Multiplies the price and quantity of each item and adds it to the total cost
            total = total + (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
        }
        return total;
    }



    /** 
     *
     * Adds a new item to the cartItems ArrayList
     *
     * @param name  the name of the item
     * @param price  the price of the item
     * @param quantity  the quantity of the item
     * @param description  the description of the item
     */
    public void addItem(String name, int price, int quantity, String description) 
    {
        cartItems.add(new ItemToPurchase(name, price, quantity, description));
    }


    /** 
     *
     * Removes item from cartItems ArrayList
     *
     * @param itemName  the item name
     */
    public void removeItem(String itemName) 
    {   
        //boolean to check if the item was found
        boolean foundItem = false;

        //Loops through cartItems array list
        for(int i = 0; i < cartItems.size(); i++)
        {   
            //Checks to see if the passed in string is the name of an item in cartItems array
            if(cartItems.get(i).getName().equals(itemName))
            {   
                //Removes the item and marks as being found
                cartItems.remove(i);
                foundItem = true;
            }
        }
        //Executes if the item is never found
        if(!foundItem)
        {
            System.out.println("\nItem not found in cart");
        }
    }


    /** 
     *
     * Modify the fields of a passed in item
     *
     * @param itemName  the item name
     * @param userIn  the Scanner defined in ShoppingCartManager
     */
    public void modifyItem(String itemName, Scanner userIn) 
    {
        //boolean to check if the item was found
        boolean foundItem = false;

        //Stores the index of the found item
        int itemIndexNumber = -1;

        //Loops through cartItems array list
        for(int i = 0; i < cartItems.size(); i++)
        {
            //Checks to see if the passed in string is the name of an item in cartItems array
            if(cartItems.get(i).getName().equals(itemName))
            {
                //Marks as being found and stores the index number of where the item was found
                foundItem = true;
                itemIndexNumber = i;
            }
        }
        //Executes if the item is never found
        if(!foundItem)
        {
            System.out.println("\nItem not found in cart");
            return;
        }

        //Executes if the item is found
        if(foundItem)
        {   
            //Used to store the choice of the following sub-menu
            int choice = 0;

            //Sub-menu to modify item
            System.out.println("\nSelect an attribute to modify:\n"
                                + "\t1. Modify name\n"
                                + "\t2. Modify price\n"
                                + "\t3. Modify quantity\n"
                                + "\t4. Modify description\n");
            choice = userIn.nextInt();
            userIn.nextLine();

            //Decides what branch to execute based on the user's choice from the sub-menu
            switch (choice)
            {
                //Modify's the item name
                case 1:
                    System.out.print("\nEnter new item name: ");
                    String name = userIn.nextLine();
                    cartItems.get(itemIndexNumber).setName(name);
                    break;

                //Modify's the item price
                case 2:
                    System.out.print("\nEnter new item price: $");
                    int price = userIn.nextInt();
                    cartItems.get(itemIndexNumber).setPrice(price);
                    break;

                //Modify's the item quantity
                case 3:
                    System.out.print("\nEnter new item quantity: ");
                    int quantity = userIn.nextInt();
                    cartItems.get(itemIndexNumber).setQuantity(quantity);
                    break;
                
                //Modify's the item description
                case 4:
                    System.out.print("\nEnter new item description: ");
                    String description = userIn.nextLine();
                    cartItems.get(itemIndexNumber).setDescription(description);
                    break;

                //Executes if the user inputs an invalid number for the sub-menu
                default:
                    System.out.println("\nInvalid input");
                    break;
            }
        }
    }


    /** 
     *
     * Prints everything about the shopping cart inclding the items in it and the total price
     *
     */
    public void printTotal() 
    {
        //Executes if the array list is empty
        if(cartItems.size() == 0)
        {
            System.out.println("\nShopping cart is empty");
        }
        else
        {
            //Prints the customer name and date, along with the number of items in their cart
            System.out.println("\nOUTPUT SHOPPING CART"
                                + "\n" + this.getCustomerName() + "'s Shopping Cart - " + this.getDate()
                                + "\nNumber of Items: " + this.getNumItemsInCart() + "\n");
            
            //Loops through the cartItems array list and prints all of the items
            for(ItemToPurchase item : cartItems)
            {
                item.printItemCost();
            }

            //Displays the total for all of the items in the cart
            System.out.println("\nTotal: $" + this.getCostOfCart());
        }
    }


    /** 
     *
     * Prints the descriptions of the items
     *
     */
    public void printDescriptions() 
    {
        //Executes if the array list is empty
        if(cartItems.size() == 0)
        {
            System.out.println("\nShopping cart is empty");
        }
        else
        {
            //Prints the customer name and date
            System.out.println("\nOUTPUT ITEM DESCRIPTIONS\n" + this.getCustomerName() + "'s Shopping Cart - " + this.getDate() 
                                + "\n\nItem Descriptions");

            //Loops through cartItems array list and prints all of the items along with their descriptions
            for(ItemToPurchase item : cartItems)
            {
                item.printItemDescription();
            }
        }
    }
}
