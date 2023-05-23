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
    public List<Account> listAll(){
        List<Account> list = new ArrayList<>();
        
        try {
            String strSelect = "select * from accounts";
            Connection cnn = (new DBContext()).connection;
            PreparedStatement pstm =cnn.prepareStatement(strSelect);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2)
                        , rs.getString(3), rs.getDouble(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("listAll: " + e.getMessage());
        }
        return list;
    }
    public boolean checkAccount(String account,String password){
        try {
            String strSelect = "select * from accounts where Username=? and Password=? ";
            Connection cnn = (new DBContext()).connection;
            PreparedStatement pstm =cnn.prepareStatement(strSelect);
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
}
