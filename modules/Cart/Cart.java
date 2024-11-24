package  SimplifiedShoppingCartSystem.modules.Cart;

import SimplifiedShoppingCartSystem.modules.Item


public class Cart extends Item
{
    private static float totalPrice;
    private static float totalPriceWithTax;
    static float TAX_RATE = 7;

    //specific attribute
    Item[] incartItems;
    private int cartId;
    private int incartItemsnumber;

    //default onstructor
    public Cart(){
        cartId++;
        incartItemsnumber = 0;
        totalPrice=0;
    }

    //method to remove an item from the cart
    private void removeFromCart(Item itemToBeRemoved)
    {
        if(incartItemsnumber>=1) {

            int i;
            int index=0;

            for (i = 0; i < incartItems.length; i++) {
                if (itemToBeRemoved == incartItems[i]) {
                    index = i;
                }
            }
            Item[] incartArrayCopy = new Item[incartItems.length - 1];
            //creating new array and modifying the original

            for (int j = 0; j < incartItems.length; j++) {
                if (i != index) {
                    incartArrayCopy[j] = incartItems[j];
                }
            }
            //recopying the modified code

            for (int h = 0; h < incartItems.length; h++) {
                incartItems[h] = incartArrayCopy[h];
            }

            //whenever the item is removed from the cart, the number of item in stock increases
             setInstock(1);
            incartItemsnumber--;
        }
        else {
            System.out.println("There is no item in the cart to remove.");
        }
        }


    // implementation for abstract method from the supper class

    public int increaseInStockQuantity(){

    };


    public int decreaseInStockQuantity(){

    };


    //method to calculate total price of items
    public float getTotalPrice() {
        return totalPrice;
    }





    //method for adding items
    int i=0;//item array index

    //adding individual item of  Item class
    public void addIteminCart(Item individualItem)
    {
        if(getInstock()>=1) {
            incartItems[i] = individualItem;
            totalPrice += individualItem.getItemPrice();
            setInstock(-1);
            incartItemsnumber++;
            i++;
        }
        else{
            System.out.println("There is no item in the stock");
        }
    }

}