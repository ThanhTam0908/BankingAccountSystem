/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingAccountSystem.Tool_Group;

/**
 *
 * @author HATTORI BAMBI
 */
public class Password_To_String {
   public static String convert(char[] chars) {
        char[] passwordTemp = chars;
        Character[] characters = new Character[passwordTemp.length];
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordTemp.length; i++){
            characters[i] = passwordTemp[i];
        }

        for (Character c: characters){
            password.append(c.toString());
        }
        return password.toString();
    } 
}
