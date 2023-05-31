/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caoqu
 */
public class AccountDAO {

    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();

        try {
            String strSelect = "select * from accounts";
            Connection cnn = (new DBContext()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getBoolean(6)));
            }
        } catch (Exception e) {
            System.out.println("listAll: " + e.getMessage());
        }
        return list;
    }

    public boolean checkAccount(String account, String password) {
        try {
            String strSelect = "select * from accounts where Username=? and Password=? ";
            Connection cnn = (new DBContext()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("listAll: " + e.getMessage());
        }
        return false;
    }

    public void updateNewPass(String acc, String password) {
        try {
            String strSelect = "UPDATE accounts\n"
                    + "SET Password=? \n"
                    + "WHERE Username=? ;";
            Connection cnn = (new DBContext()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, password);
            pstm.setString(2, acc);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("updateNewPass: " + e.getMessage());
        }
    }

    public Account findAccount(String acc) {
        List<Account> list = listAll();
        for (Account a : list) {
            if (a.getUserName().equals(acc)) {
                return a;
            }
        }
        return null;

//        try {
//            String strSelect = "select * from accounts where username=?";
//            Connection cnn = (new DBContext()).connection;
//            PreparedStatement pstm = cnn.prepareStatement(strSelect);
//            pstm.setString(1, acc);
//            ResultSet rs = pstm.executeQuery();
//            if(rs.next()){
//                return new Account(rs.getString(1), rs.getString(2),
//                        rs.getString(3), rs.getDouble(4), rs.getInt(5),rs.getBoolean(6));
//            }
//        } catch (Exception e) {
//            System.out.println("findAccount: " + e.getMessage());
//        }
    }

    public void addAll(String account, String pass, String reciveEmail, double money, int roleID, boolean status) {
        try {
            String strSelect = "insert into accounts (Username,Password,email,Money,RoleID,status) \n"
                    + "value(?,?,?,?,?,?);";
            Connection cnn = (new DBContext()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, pass);
            pstm.setString(3, reciveEmail);
            pstm.setDouble(4, money);
            pstm.setInt(5, roleID);
            pstm.setBoolean(6, status);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("addAll: " + e.getMessage());
        }
    }

    public void updateStatusAccount(String username) {
        try {
            String strSelect = "UPDATE accounts\n"
                    + "SET status = 1\n"
                    + "WHERE username=?;";
            Connection cnn = (new DBContext()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("updateStatusAccount: " + e.getMessage());
        }
    }
}
