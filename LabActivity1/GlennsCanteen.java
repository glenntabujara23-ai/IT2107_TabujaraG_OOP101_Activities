import java.util.Scanner;
public class GlennsCanteen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menu items and prices
        String[] foodItems = {
            "Chicken Burger",
            "Mac n' Cheese",
            "Milk Shake",
            "Corndog",
            "Donut"
        };

        double[] prices = {
            80.00,
            120.00,
            100.00,
            70.00,
            90.00
        };

        int totalQuantity = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;

        char orderAgain = 'Y';

        System.out.println("===== CANTEEN MENU =====");
        for (int i = 0; i < foodItems.length; i++) {
            System.out.printf("%d. %-15s - Php%.2f%n",
                    i + 1, foodItems[i], prices[i]);
        }

        while (orderAgain == 'Y') {

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            // Check if order is valid
            if (itemNumber < 1 || itemNumber > foodItems.length
                    || quantity < 1 || quantity > 10) {

                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

                System.out.print("\nDo you want to order again? (Y/N): ");
                orderAgain = input.next().toUpperCase().charAt(0);

                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().toUpperCase().charAt(0);

            double subtotal = prices[itemNumber - 1] * quantity;
            double discountRate;

            // Determine the highest applicable discount
            if (student == 'Y' && subtotal >= 500) {
                discountRate = 0.15;
            } else if (subtotal >= 500) {
                discountRate = 0.05;
            } else if (student == 'Y') {
                discountRate = 0.10;
            } else {
                discountRate = 0.00;
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            totalQuantity += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;

            System.out.printf("%nSubtotal: Php%.2f%n", subtotal);
            System.out.printf("Discount: Php%.2f%n", discount);
            System.out.printf("Order total: Php%.2f%n", orderTotal);

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);
        }

        // Final order summary
        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantity);
        System.out.printf("Total before discount: Php%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: Php%.2f%n",
                totalDiscount);
        System.out.printf("Final amount: Php%.2f%n",
                finalAmount);

        System.out.println("Thank you for ordering!");

        input.close();
    }
}