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
public class Staff_salary {
    private String Staff_ID;
    private String Staff_name;
    private float Salary;

    public Staff_salary(String Staff_ID, String Staff_name, float Salary) {
        this.Staff_ID = Staff_ID;
        this.Staff_name = Staff_name;
        this.Salary = Salary;
    }

    public String getStaff_ID() {
        return Staff_ID;
    }

    public String getStaff_name() {
        return Staff_name;
    }

    public float getSalary() {
        return Salary;
    }
}
