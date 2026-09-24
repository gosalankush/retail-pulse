package com.retailpulse;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== RetailPulse Inventory System ===");
            System.out.println("1. Admin Account");
            System.out.println("2. User Account");
            System.out.println("3. Guest Mode");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int mchoice = scanner.nextInt();
            scanner.nextLine();

            if (mchoice == 1){
                boolean keepadminoptions =true;
                while (keepadminoptions) {
                    System.out.println("\n---Admin Account---");
                    System.out.println("1. View All Products");
                    System.out.println("2. Add New Product");
                    System.out.println("3. Update Product Details");
                    System.out.println("4. Search Product by Name");
                    System.out.println("5. Low Stock Alerts");
                    System.out.println("6. Sort Products by Price");
                    System.out.println("7. Sort Products by Stocks");
                    System.out.println("8. Delete Product");
                    System.out.println("9. Total Inventory Value Reports");
                    System.out.println("10. Back to Main Menu");
                    System.out.print("Choose an option: ");

                    int achoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (achoice) {
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
                            System.out .print("Enter 'a' for Asc or 'd' for Dsc: ");
                            String priceorder = scanner.nextLine();

                            productDAO.priceSort(priceorder);
                            break;
                        case 7:
                            System.out.println("\nBy which order you want to sort your products 'Ascending or Descending'?");
                            System.out .print("Enter 'a' for Asc or 'd' for Dsc: ");
                            String stockorder = scanner.nextLine();

                            productDAO.stockSort(stockorder);
                            break;

                        case 8:
                            System.out.print("Enter product's name you want to delete: ");
                            name = scanner.nextLine();

                            productDAO.deleteProducts(name);
                            break;
                        case 9:
                            productDAO.totalInventory();
                            break;
                        case 10:
                            System.out.println("Exiting back to Main Menu...");
                            keepadminoptions = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }else if(mchoice == 2){
                boolean keepuseroptions = true;
                while (keepuseroptions) {
                    System.out.println("\n---User Account---");
                    System.out.println("1. View All Products");
                    System.out.println("2. Search Product by Name");
                    System.out.println("3. Sort Products by Price");
                    System.out.println("4. Sort Products by Stocks");
                    System.out.println("5. Exit");
                    System.out.print("Choose an option: ");

                    int uchoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (uchoice) {
                        case 1:
                            productDAO.viewProducts();
                            break;
                        case 2:
                            System.out.print("Enter product's name you want to search: ");
                            String name = scanner.nextLine();

                            productDAO.searchProducts(name);
                            break;
                        case 3:
                            System.out.println("\nBy which order you want to sort your products 'Ascending or Descending'?");
                            System.out .print("Enter 'a' for Asc or 'd' for Dsc: ");
                            String priceorder = scanner.nextLine();

                            productDAO.priceSort(priceorder);
                            break;
                        case 4:
                            System.out.println("\nBy which order you want to sort your products 'Ascending or Descending'?");
                            System.out .print("Enter 'a' for Asc or 'd' for Dsc: ");
                            String stockorder = scanner.nextLine();

                            productDAO.stockSort(stockorder);
                            break;
                        case 5:
                            System.out.println("Exiting back to Main Menu...");
                            keepuseroptions = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }else if (mchoice == 3) {
                boolean keepguestoptions = true;
                while (keepguestoptions) {
                    System.out.println("\n---Guest Mode---");
                    System.out.println("1. View All Products");
                    System.out.println("2. Search Product by Name");
                    System.out.println("3. Sort Products by Price");
                    System.out.println("4. Sort Products by Stocks");
                    System.out.println("5. Exit");
                    System.out.print("Choose an option: ");

                    int gchoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (gchoice) {
                        case 1:
                            productDAO.viewProducts();
                            break;
                        case 2:
                            System.out.print("Enter product's name you want to search: ");
                            String name = scanner.nextLine();

                            productDAO.searchProducts(name);
                            break;
                        case 3:
                            System.out.println("\nBy which order you want to sort your products 'Ascending or Descending'?");
                            System.out .print("Enter 'a' for Asc or 'd' for Dsc: ");
                            String priceorder = scanner.nextLine();

                            productDAO.priceSort(priceorder);
                            break;
                        case 4:
                            System.out.println("\nBy which order you want to sort your products 'Ascending or Descending'?");
                            System.out .print("Enter 'a' for Asc or 'd' for Dsc: ");
                            String stockorder = scanner.nextLine();

                            productDAO.stockSort(stockorder);
                            break;
                        case 5:
                            System.out.println("Exiting back to Main Menu...");
                            keepguestoptions = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }else if(mchoice == 4){
                System.out.println("Exiting application. Goodbye!\n");
                scanner.close();
                System.exit(0);
            }else{
                System.out.println("Invalid option. Please try again.");
            } 
        }
    }
}