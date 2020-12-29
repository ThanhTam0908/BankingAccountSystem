/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Class;

/**
 *
 * @author HATTORI BAMBI
 */
public class Card {
    private String Card_ID;
    private String Card_name;

    public Card(String Card_ID, String Card_name) {
        this.Card_ID = Card_ID;
        this.Card_name = Card_name;
    }


    public String getCard_ID() {
        return Card_ID;
    }

    public String getCard_name() {
        return Card_name;
    }
    
}
