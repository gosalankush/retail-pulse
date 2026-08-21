package com.retailpulse;

import java.sql.*;

public class ProductDAO {

    public void addProduct(String name, double price, int stock) {
        String query = "INSERT INTO products (name, price, stock_quantity) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, stock);
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Success! New product added. Rows affected: " + rowsAffected);
            
        } catch (SQLException e) {
            System.err.println("Database error while adding product: " + e.getMessage());
        }
    }

    public void viewProducts() {
        String query = "SELECT * FROM products";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            System.out.println("\n--- Current Inventory Status ---");
            System.out.printf("%-5s | %-25s | %-10s | %-8s%n", "ID", "Product Name", "Price ($)", "Stock");
            System.out.println("---------------------------------------------------------");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock_quantity");
                
                System.out.printf("%-5d | %-25s | %-10.2f | %-8d%n", id, name, price, stock);
            }
            System.out.println("---------------------------------------------------------");
            
        } catch (SQLException e) {
            System.err.println("Database error while fetching products: " + e.getMessage());
        }
    }

    public void updateProducts(String searchName, double newPrice, int newStock){
        String sql = "UPDATE products SET price = ?, stock_quantity = ? WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDouble(1, newPrice);
            pstmt.setInt(2, newStock);
            pstmt.setString(3, searchName);

            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Product "+ searchName +" updated succesfully!");
            } else {
                System.out.println("No product found with the name "+ searchName);
            }
        } catch (SQLException e) {
            System.out.println("Database error while updating product: "+ e.getMessage());
        }
    }


    public void searchProducts(String searchName){
        String sql = "SELECT * FROM products WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, searchName);

            try (ResultSet rs = pstmt.executeQuery()) {
                
                if (rs.next()) {
                    System.out.println("\n--- Product Found ---");
                    System.out.printf("%-5s | %-25s | %-10s | %-8s%n", "ID", "Product Name", "Price ($)", "Stock");
                    System.out.println("---------------------------------------------------------");
            

                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock_quantity");

                    System.out.printf("%-5d | %-25s | %-10.2f | %-8d%n", id, name, price, stock);
                
                    System.out.println("---------------------------------------------------------");
               
                } else {
                    System.out.println("No product found with the name :" + searchName);
                }
            }
        } catch (SQLException e){
            System.out.println("Database error while searching product: " + e.getMessage());
        }
    }

    public void lowstockProducts(){
        String query = "SELECT * FROM products WHERE stock_quantity < 10";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
                
            try (ResultSet rs = stmt.executeQuery(query)) {
                    
                if (rs.next()){
                    System.out.println("\n--- Product Found ---");
                    System.out.printf("%-5s | %-25s | %-10s | %-8s%n", "ID", "Product Name", "Price ($)", "Stock");
                    System.out.println("---------------------------------------------------------");
            

                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock_quantity");

                    System.out.printf("%-5d | %-25s | %-10.2f | %-8d%n", id, name, price, stock);
                
                    System.out.println("---------------------------------------------------------");
               
                } else {
                    System.out.println("No products found with lower stocks.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error while fetching low-stock products: " + e.getMessage());
        }
    }

    public void deleteProducts(String searchName){
        String sql = "DELETE FROM products WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, searchName);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Product " + searchName + " deleted successfully!");
            } else {
                System.out.println("No product found with the name " + searchName);
            }

        } catch (SQLException e) {
            System.out.println("Database error while deleting product: " + e.getMessage());
        }
    }
}