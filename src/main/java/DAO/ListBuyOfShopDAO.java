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
//import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
//import Model.ListByOfShop;
//import Model.HistoryBuy;
//
//public class ListBuyOfShopDAO extends DBContext {
//
//    public List<ListByOfShop> getHistsByUser(String username) {
//        HistoryDAO htd = new HistoryDAO();
//        List<ListByOfShop> list = new ArrayList<>();
//        String sql = "SELECT * FROM ListByOfShop WHERE usernameshop=?";
//        try (PreparedStatement st = connection.prepareStatement(sql)) {
//            st.setString(1, username);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                HistoryBuy hb = htd.getBuyId(rs.getInt("historybuyid"));
//                ListByOfShop p = new ListByOfShop(rs.getInt("id"), hb,
//                        rs.getString("usernameshop"), rs.getString("address2"),
//                        rs.getString("country"), rs.getString("city"), rs.getString("zipcode"));
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return list;
//    }
//
//    public ListByOfShop getById(int id) {
//        HistoryDAO htd = new HistoryDAO();
//        String sql = "SELECT * FROM ListByOfShop WHERE id=?";
//        try (PreparedStatement st = connection.prepareStatement(sql)) {
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                HistoryBuy hb = htd.getBuyId(rs.getInt("historybuyid"));
//                ListByOfShop p = new ListByOfShop(rs.getInt("id"), hb,
//                        rs.getString("usernameshop"), rs.getString("address2"),
//                        rs.getString("country"), rs.getString("city"), rs.getString("zipcode"));
//                return p;
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    public List<ListByOfShop> getAll() {
//        HistoryDAO htd = new HistoryDAO();
//        List<ListByOfShop> list = new ArrayList<>();
//        String sql = "SELECT * FROM ListByOfShop";
//        try (PreparedStatement st = connection.prepareStatement(sql)) {
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                HistoryBuy hb = htd.getBuyId(rs.getInt("historybuyid"));
//                ListByOfShop p = new ListByOfShop(rs.getInt("id"), hb,
//                        rs.getString("usernameshop"), rs.getString("address2"),
//                        rs.getString("country"), rs.getString("city"), rs.getString("zipcode"));
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return list;
//    }
//
//    public int getIdMax() {
//        String sql = "SELECT MAX(id) as result1 FROM ListByOfShop";
//        try (PreparedStatement st = connection.prepareStatement(sql)) {
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                int i = rs.getInt("result1");
//                return i;
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
//
//    public int insert(int ids, int hb, String er, String s3, String s5, String s6,String s7) {
//        String sql = "INSERT INTO ListByOfShop (id, historybuyid, usernameshop, address2, country, city, zipcode)"
//                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement st = connection.prepareStatement(sql)) {
//            st.setInt(1, ids);
//            st.setInt(2, hb);
//            st.setString(3, er);
//            st.setString(4, s3);
//            st.setString(5, s5);
//            st.setString(6, s6);
//            st.setString(7, s7);
//            st.executeUpdate();
//            return 1;
//        } catch (SQLException e) {
//            // In case of data truncation error due to input values that exceed the column size,
//            // print out a more specific error message
//            if (e instanceof MysqlDataTruncation) {
//                System.out.println("Input value(s) too long for column(s)");
//            } else {
//                System.out.println(e.getMessage());
//            }
//        }
//        return 0;
//    }
//
//    public void update(ListByOfShop c) {
//    String sql = "UPDATE ListByOfShop SET historybuyid=?, usernameshop=?, address2=?, country=?, city=?, zipcode=? WHERE id=?";
//    try (PreparedStatement st = connection.prepareStatement(sql)) {
//        st.setInt(1, c.getHistorybuy().getId());
//        st.setString(2, c.getUsernameshop());
//        st.setString(3, c.getAddress1());
//        st.setString(4, c.getCountry());
//        st.setString(5, c.getCity());
//        st.setString(6, c.getZipcode());
//        st.setInt(7, c.getId());
//        int rowsAffected = st.executeUpdate();
//        if (rowsAffected == 0) {
//            System.out.println("No record found with ID=" + c.getId());
//        } else {
//            System.out.println(rowsAffected + " row(s) updated");
//        }
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//    }
//}
//
//public static void main(String[] args) {
//    ListBuyOfShopDAO dao = new ListBuyOfShopDAO();
//
//    List<ListByOfShop> list = dao.getAll();
//    for (ListByOfShop p : list) {
//        System.out.println(p);
//    }
//}
//}
