package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String ClientEmail = sc.nextLine();
        System.out.print("Birth date(DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(clientName, ClientEmail, birthDate);
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order");

        int numberItems = sc.nextInt();

        for (int i = 1; i <= numberItems; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            Double prodPrice = sc.nextDouble();

            Product product = new Product(nameProduct, prodPrice);

            System.out.print("Quantity: ");

            Integer quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, prodPrice, product);

            order.addItem(orderItem);

        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();

    }
}
