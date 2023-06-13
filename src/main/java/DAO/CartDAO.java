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
//import Model.Cart;
//import Model.Product;
//
///**
// *
// * author asus
// */
//public class CartDAO extends DBContext {
//
//    public int getIdMaxCart() {
//        CartDAO w = new CartDAO();
//        List<Product> list = new ArrayList<>();
//        String sql = "SELECT MAX(id) as result1 FROM Cart";
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
//    public List<Cart> getCart(String username) {
//        ProductDAO w = new ProductDAO();
//        ArrayList<Cart> list = new ArrayList<Cart>();
//        String sql = "SELECT id, username, product_id, quantity FROM Cart WHERE username=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, username);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Product p = w.getProduct(rs.getInt("product_id"));
//                Cart c = new Cart(rs.getInt("id"), rs.getString("username"),
//                        rs.getInt("quantity"),
//                        p);
//                list.add(c);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
//
//    public Cart getCartByIdProcductAndUser(String username, int id) {
//        ProductDAO w = new ProductDAO();
//        String sql = "SELECT id, username, product_id, quantity FROM Cart WHERE username=? AND id=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, username);
//            st.setInt(2, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Product p = w.getProduct(rs.getInt("product_id"));
//                Cart c = new Cart(rs.getInt("id"), rs.getString("username"),
//                        rs.getInt("quantity"),
//                        p);
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    public Cart getCartById(int id) {
//        ProductDAO w = new ProductDAO();
//        String sql = "SELECT id, username, product_id, quantity FROM Cart WHERE id=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Product p = w.getProduct(rs.getInt("product_id"));
//                Cart c = new Cart(rs.getInt("id"), rs.getString("username"),
//                        rs.getInt("quantity"),
//                        p);
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//
//    }
//
//    public void updateCart(int id, String user, int procid, int quanti) {
//        String sql = "UPDATE Cart SET quantity = ? WHERE id=? AND username=? AND product_id=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, quanti);
//            st.setInt(2, id);
//            st.setString(3, user);
//            st.setInt(4, procid);
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void deleteCart(int id) {
//        String sql = "DELETE FROM Cart WHERE id=?";
//
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        CartDAO in = new CartDAO();
//        List<Cart> infor = new ArrayList<Cart>();
//        infor = in.getCart("admin");
//        for (Cart cart : infor) {
//            System.out.println(cart.toString() + "\n");
//        }
//    }
//
//    public void insert(Cart c) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//}
