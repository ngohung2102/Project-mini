package dao;

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package DAO;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import Model.Category;
//import Model.Product;
//
//public class ProductDAO extends DBContext {
//
//    public List<Product> getProductsByCid(int cid) {
//        CategoryDAO w = new CategoryDAO();
//        List<Product> list = new ArrayList<>();
//        String sql = "SELECT * FROM products WHERE cid=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, cid);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Category c = w.getCategoryById(rs.getInt("cid"));
//                Product p = new Product(rs.getInt("id"), rs.getString("name"),
//                        rs.getInt("quantity"), rs.getInt("rate"), rs.getInt("price"),
//                        rs.getString("url_picture"), rs.getString("description"), c,
//                        rs.getString("username"));
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
//
//    public List<Product> getProductsByUser(String username) {
//        CategoryDAO w = new CategoryDAO();
//        List<Product> list = new ArrayList<>();
//        String sql = "SELECT * FROM products WHERE username=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, username);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Category c = w.getCategoryById(rs.getInt("cid"));
//                Product p = new Product(rs.getInt("id"), rs.getString("name"),
//                        rs.getInt("quantity"), rs.getInt("rate"), rs.getInt("price"),
//                        rs.getString("url_picture"), rs.getString("description"), c, username);
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
//
//    public Product getProduct(int id) {
//        CategoryDAO w = new CategoryDAO();
//        String sql = "SELECT * FROM products WHERE id=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Category c = w.getCategoryById(rs.getInt("cid"));
//                Product p = new Product(rs.getInt("id"), rs.getString("name"),
//                        rs.getInt("quantity"), rs.getInt("rate"), rs.getInt("price"),
//                        rs.getString("url_picture"), rs.getString("description"), c,
//                        rs.getString("username"));
//                return p;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    public List<Product> getAll() {
//        CategoryDAO w = new CategoryDAO();
//        List<Product> list = new ArrayList<>();
//        String sql = "SELECT * FROM products";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Category c = w.getCategoryById(rs.getInt("cid"));
//                Product p = new Product(rs.getInt("id"), rs.getString("name"),
//                        rs.getInt("quantity"), rs.getInt("rate"), rs.getInt("price"),
//                        rs.getString("url_picture"), rs.getString("description"), c,
//                        rs.getString("username"));
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
//
//    public int getIdMax() {
//        CategoryDAO w = new CategoryDAO();
//        List<Product> list = new ArrayList<>();
//        String sql = "SELECT MAX(id) as result1 FROM products";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                int i = rs.getInt("result1");
//                return i;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return 0;
//    }
//
//    public int insert(Product c) {
//        String sql = "INSERT INTO products(id,name,url_picture,price,rate,cid,description,quantity,username)"
//                + " VALUES (?,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, c.getId());
//            st.setString(2, c.getName());
//            st.setString(3, c.getImage());
//            st.setInt(4, c.getPrice());
//            st.setInt(5, c.getRate());
//            st.setInt(6, c.getCategory().getId());
//            st.setString(7, c.getDescription());
//            st.setInt(8, c.getQuantity());
//            st.setString(9, c.getUsername());
//            st.executeUpdate();
//            return 1;
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return 0;
//    }
//
//   public void update(Product c) {
//        String sql = "UPDATE products SET name=?, url_picture=?, price=?, rate=?, cid=?, description=?, quantity=? WHERE id=? AND username=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, c.getName());
//            st.setString(2, c.getImage());
//            st.setInt(3, c.getPrice());
//            st.setInt(4, c.getRate());
//            st.setInt(5, c.getCategory().getId());
//            st.setString(6, c.getDescription());
//            st.setInt(7, c.getQuantity());
//            st.setInt(8, c.getId());
//            st.setString(9, c.getUsername());
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void delete(int id) {
//        String sql = "DELETE FROM products WHERE id=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        ProductDAO d = new ProductDAO();
//        
//        System.out.println(d.getIdMax());
//    }
//}
