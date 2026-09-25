Question 1:
Advanced Problem-Solving Approach using linear and non-linear collections.An online shopping system must maintain products, quickly search products by ID, and process orders according to priority.


  PROGRAM:
import java.util.*;

// Class representing a Product
class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product[ID=" + id + ", Name=" + name + ", Price=$" + price + "]";
    }
}

// Class representing an Order with priority comparison
class Order implements Comparable<Order> {
    private String orderId;
    private String productId;
    private int priority; // Lower value = higher priority (e.g., 1 = Urgent, 2 = High, 3 = Regular)

    public Order(String orderId, String productId, int priority) {
        this.orderId = orderId;
        this.productId = productId;
        this.priority = priority;
    }

    public String getOrderId() { return orderId; }
    public String getProductId() { return productId; }
    public int getPriority() { return priority; }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Order[ID=" + orderId + ", ProductID=" + productId + ", Priority=" + priority + "]";
    }
}

// Online Shopping System Class
public class OnlineShoppingSystem {
    // Non-linear collection for fast O(1) product lookups by ID
    private Map<String, Product> productCatalog;
    
    // Linear collection (Priority Queue) to process orders by priority
    private PriorityQueue<Order> orderQueue;

    public OnlineShoppingSystem() {
        productCatalog = new HashMap<>();
        orderQueue = new PriorityQueue<>();
    }

    // Maintain & Add Products
    public void addProduct(Product product) {
        productCatalog.put(product.getId(), product);
        System.out.println("Added Product: " + product);
    }

    // Quick Search by Product ID
    public Product searchProduct(String id) {
        return productCatalog.get(id);
    }

    // Place an Order
    public void placeOrder(Order order) {
        if (productCatalog.containsKey(order.getProductId())) {
            orderQueue.add(order);
            System.out.println("Order Placed: " + order);
        } else {
            System.out.println("Failed to place order. Product ID " + order.getProductId() + " not found!");
        }
    }

    // Process Orders according to Priority
    public void processNextOrder() {
        Order nextOrder = orderQueue.poll();
        if (nextOrder != null) {
            Product product = searchProduct(nextOrder.getProductId());
            System.out.println("Processing " + nextOrder + " for " + product);
        } else {
            System.out.println("No pending orders to process.");
        }
    }

    public static void main(String[] args) {
        OnlineShoppingSystem system = new OnlineShoppingSystem();

        System.out.println("--- 1. Maintaining Products ---");
        system.addProduct(new Product("P101", "Laptop", 999.99));
        system.addProduct(new Product("P102", "Smartphone", 499.99));
        system.addProduct(new Product("P103", "Headphones", 79.99));

        System.out.println("\n--- 2. Fast Product Search ---");
        Product p = system.searchProduct("P102");
        System.out.println("Search Result for 'P102': " + (p != null ? p : "Not Found"));

        System.out.println("\n--- 3. Placing Orders with Priorities ---");
        // Priority: 1 (Urgent/VIP), 2 (Express), 3 (Standard)
        system.placeOrder(new Order("O001", "P101", 3)); // Standard
        system.placeOrder(new Order("O002", "P103", 1)); // Urgent/VIP
        system.placeOrder(new Order("O003", "P102", 2)); // Express

        System.out.println("\n--- 4. Processing Orders (By Priority) ---");
        system.processNextOrder(); // Should process O002 (Priority 1)
        system.processNextOrder(); // Should process O003 (Priority 2)
        system.processNextOrder(); // Should process O001 (Priority 3)
    }
} 
SAMPLE INPUT:
  Product 1: ID = "P101", Name = "Laptop", Price = $999.99
Product 2: ID = "P102", Name = "Smartphone", Price = $499.99
Product 3: ID = "P103", Name = "Headphones", Price = $79.99

Search Query: Product ID = "P102"

Order 1: Order ID = "O001", Product ID = "P101", Priority = 3 (Standard)
Order 2: Order ID = "O002", Product ID = "P103", Priority = 1 (Urgent/VIP)
Order 3: Order ID = "O003", Product ID = "P102", Priority = 2 (Express)

  SAMPLE OUTPUT:
--- 1. Maintaining Products ---
Added Product: Product[ID=P101, Name=Laptop, Price=$999.99]
Added Product: Product[ID=P102, Name=Smartphone, Price=$499.99]
Added Product: Product[ID=P103, Name=Headphones, Price=$79.99]

--- 2. Fast Product Search ---
Search Result for 'P102': Product[ID=P102, Name=Smartphone, Price=$499.99]

--- 3. Placing Orders with Priorities ---
Order Placed: Order[ID=O001, ProductID=P101, Priority=3]
Order Placed: Order[ID=O002, ProductID=P103, Priority=1]
Order Placed: Order[ID=O003, ProductID=P102, Priority=2]

--- 4. Processing Orders (By Priority) ---
Processing Order[ID=O002, ProductID=P103, Priority=1] for Product[ID=P103, Name=Headphones, Price=$79.99]
Processing Order[ID=O003, ProductID=P102, Priority=2] for Product[ID=P102, Name=Smartphone, Price=$499.99]
Processing Order[ID=O001, ProductID=P101, Priority=3] for Product[ID=P101, Name=Laptop, Price=$999.99]
