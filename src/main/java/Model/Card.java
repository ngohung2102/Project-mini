/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PC
 */
@lombok.AllArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Card {
    private int id;
    private String seri;
    private String code;
    private double price;
    private boolean isBuy;
    private Date expirationDate;
    private int transactionId;
    private int productId;
    private Date createdAt;
}
