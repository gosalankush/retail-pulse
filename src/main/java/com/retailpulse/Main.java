package com.retailpulse;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== RetailPulse Inventory System ===");
            System.out.println("1. View All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Update Product Details");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Low Stock Alerts");
            System.out.println("6. Sort Products by Price");
            System.out.println("7. Delete Product");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    productDAO.viewProducts();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter stock quantity: ");
                    int stock = scanner.nextInt();
                    
                    productDAO.addProduct(name, price, stock);
                    break;
                case 3:
                    System.out.print("Enter the product's name you want to update: ");
                    name = scanner.nextLine();

                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new stock quantity: ");
                    int newStock = scanner.nextInt();
                    scanner.nextLine();

                    productDAO.updateProducts(name, newPrice, newStock);
                    break;
                case 4:
                    System.out.print("Enter product's name you want to search: ");
                    name = scanner.nextLine();

                    productDAO.searchProducts(name);
                    break;
                case 5:
                    productDAO.lowstockProducts();
                    break;
                case 6:
                    System.out.println("\nBy which order you want to sort your products 'Ascending or Descending'?");
                    System.out .println("Enter 'a' for Asc or 'd' for Dsc: ");
                    String order = scanner.nextLine();

                    productDAO.sortProducts(order);
                    break;
                case 7:
                    System.out.print("Enter product's name you want to delete: ");
                    name = scanner.nextLine();

                    productDAO.deleteProducts(name);
                    break;
                case 8:
                    System.out.println("Exiting application. Goodbye!\n");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }
}