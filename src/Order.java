public class Order {
    private String itemName;
    private int orderID;
    double price;
    private Order link;

    public Order(){
        this.itemName = null;
        this.orderID = 0;
        this.price = 0;
        this.link = null;
    }

    public Order(String itemName, int orderID, double price) {
        this.itemName = itemName;
        this.orderID = orderID;
        this.price = price;
    }
    //Getter method
    public String getItemName() {
        return itemName;
    }
    public int getOrderID() {
        return orderID;
    }
    public double getPrice() {
        return price;
    }
    public Order getLink() {
        return link;
    }
    //Setter method
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setLink(Order link) {
        this.link = link;
    }
    public String toString(){
        return "Order # " + this.orderID + ": " + this.itemName + " ($" + this.price + ")";
    }
}
