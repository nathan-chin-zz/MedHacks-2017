package com.example.android.medhacks2017;

import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Created by Nathan on 9/9/2017.
 */

public class User extends AppCompatActivity implements Serializable{
    private String uniqueCode;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;
    private String doctorFirst;
    private String doctorLast;
    private String doctorPhone;
    private String doctorEmail;
    private String password;
    final char[] CHARACTERS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
            'r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0','A',
            'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W',
            'X','Y','Z'};

    public User(){
        uniqueCode = randomCode();
        firstName = null;
        lastName = null;
        phoneNum = null;
        email = null;
        doctorFirst = null;
        doctorLast = null;
        doctorPhone = null;
        doctorEmail = null;
        password = null;
    }

    public User(String firstName, String lastName, String phoneNum, String email){
        uniqueCode = randomCode();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public User(String firstName, String lastName, String phoneNum, String email, String doctorFirst, String doctorLast, String doctorEmail, String doctorPhone){
        uniqueCode = randomCode();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.doctorFirst = doctorFirst;
        this.doctorLast = doctorLast;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
    }

    public void updateUser(String doctorFirst, String doctorLast, String doctorPhone, String doctorEmail){
        this.doctorFirst = doctorFirst;
        this.doctorLast = doctorLast;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
    }


    public String randomCode(){
        String code = "";
        int max = CHARACTERS.length - 1;
        for(int i = 0; i < 6; i++){
            int random = (int)(Math.random() * max)+ 1;
            code += CHARACTERS[random];
        }
        return code;
    }

    //Accessor methods

    public String getUniqueCode(){
        return uniqueCode;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public String getEmail(){
        return email;
    }

    public String getDoctorFirst(){
        return doctorFirst;
    }

    public String getDoctorLast(){
        return doctorLast;
    }

    public String getDoctorPhone(){
        return doctorPhone;
    }

    public String getDoctorEmail(){
        return doctorEmail;
    }

    public String getPassword() { return password; }

    //Mutator methods

    public void setUniqueCode(String change){
        uniqueCode = change;
    }

    public void setFirstName(String change){
        firstName = change;
    }

    public void setLastName(String change){
        lastName = change;
    }

    public void setPhoneNum(String change){
        phoneNum = change;
    }

    public void setEmail(String change){
        email = change;
    }

    public void setDoctorFirst(String change){
        doctorFirst = change;
    }

    public void setDoctorLast(String change){
        doctorLast = change;
    }

    public void setDoctorPhone(String change){
        doctorPhone = change;
    }

    public void setDoctorEmail(String change){
        doctorEmail = change;
    }

    public void setPassword(String change) { password = change; }

}