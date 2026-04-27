import java.util.Scanner;
public class WarehouseManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = "";
        OrderQueue oq = new OrderQueue();
        ShippingStack sp = new ShippingStack();
        while (!menu.equalsIgnoreCase("Q")){
            System.out.println("Menu:");
            System.out.println("(A) Add Order");
            System.out.println("(P) Process Order");
            System.out.println("(V) View Warehouse");
            System.out.println("(D) Dispatch Pallet");
            System.out.println("(Q) Quit");
            System.out.println("Enter choice: ");
            menu = sc.next();
            sc.nextLine();
            switch (menu.toUpperCase()){
                case "A":
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double Price = sc.nextDouble();
                    Order o = new Order(name, id, Price);
                    oq.enqueue(o);
                    System.out.println("Order #" + o.getOrderID() + " has been added to the Queue ");
                    break;
                case "P":
                    System.out.println("Loading...");
                    Order temp;
                    try {
                        temp = oq.dequeue();
                        sp.push(temp);
                        System.out.println("Order #" + temp.getOrderID() + "has been moved to the Shipping Stack");
                        break;
                    } catch (EmptyQueueException e) {
                        System.out.println("There is no order to process");
                    }
                    break;
                case "V":
                    System.out.println("Current Queue (Front to back): ");
                    Order nodePtr = new Order();
                    nodePtr = oq.getFront();
                    int i = 1;
                    while (nodePtr != null){
                        String s = nodePtr.toString();
                        System.out.println(i + "." + " " + s);
                        nodePtr = nodePtr.getLink();
                        i++;
                    }
                    System.out.println();
                    System.out.println("Current Stack (Top to Bottom)");
                    sp.printStack();
                    break;
                case "D":
                    System.out.println("Dispatching Pallet...");
                    int k = 1;
                    if (sp.isEmpty()){
                        System.out.println("Pallet is empty");
                        break;
                    }
                    while (!sp.isEmpty()){
                        System.out.println(k + "Dispatching Order " + sp.pop());
                        k++;
                    }
                    System.out.println("All items dispatched. Pallet is now empty");
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    break;
            }
        }
    }
}
