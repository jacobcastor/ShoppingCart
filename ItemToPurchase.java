/**
 * This class is for use in an ITSC 1213 activity
 * @author Geoffrey Grimaud
 * @version October 12, 2020
 *
 */
public class ItemToPurchase 
{
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	private String itemDescription;
	
	public ItemToPurchase()
	{
		itemName = "none";
		itemPrice = 0;
		itemQuantity = 0;
		itemDescription = "none";
	}

	public ItemToPurchase(String name, int price, int quantity, String description)
	{
		this.itemName = name;
		this.itemPrice = price;
		this.itemQuantity = quantity;
		this.itemDescription = description;
	}

	/**
	 * Prints the item's name, quantity, individual price, and total price(quantity * price)
	 */
	public void printItemCost()
	{
		System.out.println(this.getName() + " " + this.getQuantity() + " @ $" + this.getPrice() + " = $" + (this.getPrice() * this.getQuantity()));
	}

	/**
	 * Prints the item's name and description
	 */
	public void printItemDescription()
	{
		System.out.println(this.getName() + ": " + this.getDescription());
	}
	/**
	 * Returns the item's name
	 * @return this item's name
	 */
	public String getName() 
	{
		return itemName;
	}

	/**
	 * Replaces the name of this item
	 * @param itemName replacement name for the item
	 */
	public void setName(String itemName) 
	{
		this.itemName = itemName;
	}

	/**
	 * Returns the item's price
	 * @return this item's price
	 */
	public int getPrice() {
		return itemPrice;
	}


	/**
	 * Replaces the price of this item
	 * @param itemPrice replacement price for the item
	 */
	public void setPrice(int itemPrice) 
	{
		this.itemPrice = itemPrice;
	}

	/**
	 * Returns the quantity of this item
	 * @return this item's quantity
	 */
	public int getQuantity() 
	{
		return itemQuantity;
	}


	/**
	 * Replaces the quantity of this item
	 * @param itemQuantity replacement quantity for the item
	 */
	public void setQuantity(int itemQuantity) 
	{
		this.itemQuantity = itemQuantity;
	}


	/**
	 * Returns the description of this item
	 * @return this item's description
	 */
	public String getDescription() 
	{
		return this.itemDescription;
	}

	/**
	 * Replaces the description of this item
	 * @param itemDescription replacement description for the item
	 */
	public void setDescription(String itemDescription) 
	{
		this.itemDescription = itemDescription;
	}

//	@Override
//	public String toString()
//	{
//		return itemName + " " + itemQuantity + " @ $" + itemPrice;
//	}
	

}
