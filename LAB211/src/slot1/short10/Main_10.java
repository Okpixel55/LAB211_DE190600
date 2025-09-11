/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1.short10;

import slot1.Validator;

/**
 *
 * @author ADMIN
 */
public class Main_10 {
    public static void main(String[] args) {

        int numberofarray = Validator.checkNum( "Enter number of array:", true);
        int searchvalue = Validator.checkNum( "Enter search value:", true);
        
        Short10_LinearSearch program = new Short10_LinearSearch();
        program.makeRandomArrayOnNumberAndSearch(numberofarray, searchvalue);
        
        
    }
}
