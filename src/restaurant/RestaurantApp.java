package restaurant;

// Main class to demonstrate collaboration
public class RestaurantApp {
    public static void main(String[] args) {
        // Creating customer
        Customer customer = new Customer("Alice");
        
        // Creating menu items
        MenuItem pizza = new MenuItem("Pizza", 8.99);
        MenuItem burger = new MenuItem("Burger", 5.49);
        MenuItem soda = new MenuItem("Soda", 1.99);
        
        // Customer adds items to their order
        customer.addToOrder(pizza);  // Collaborating with MenuItem and Order
        customer.addToOrder(burger); //addtoorder done by samSh
        customer.addToOrder(soda);
        
        // Customer places the order
        customer.placeOrder();  // Collaborating with Order to show order summary
    }
}
