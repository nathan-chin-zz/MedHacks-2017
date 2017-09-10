package com.example.android.medhacks2017;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "medhacks-mobilehub-1407218921-Users")

public class UsersDO {
    private String _userId;
    private String _doctorEmail;
    private String _doctorFirst;
    private String _doctorLast;
    private String _doctorPhone;
    private String _email;
    private String _firstName;
    private String _lastName;
    private String _phoneNum;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "doctorEmail")
    public String getDoctorEmail() {
        return _doctorEmail;
    }

    public void setDoctorEmail(final String _doctorEmail) {
        this._doctorEmail = _doctorEmail;
    }
    @DynamoDBAttribute(attributeName = "doctorFirst")
    public String getDoctorFirst() {
        return _doctorFirst;
    }

    public void setDoctorFirst(final String _doctorFirst) {
        this._doctorFirst = _doctorFirst;
    }
    @DynamoDBAttribute(attributeName = "doctorLast")
    public String getDoctorLast() {
        return _doctorLast;
    }

    public void setDoctorLast(final String _doctorLast) {
        this._doctorLast = _doctorLast;
    }
    @DynamoDBAttribute(attributeName = "doctorPhone")
    public String getDoctorPhone() {
        return _doctorPhone;
    }

    public void setDoctorPhone(final String _doctorPhone) {
        this._doctorPhone = _doctorPhone;
    }
    @DynamoDBAttribute(attributeName = "email")
    public String getEmail() {
        return _email;
    }

    public void setEmail(final String _email) {
        this._email = _email;
    }
    @DynamoDBAttribute(attributeName = "firstName")
    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(final String _firstName) {
        this._firstName = _firstName;
    }
    @DynamoDBAttribute(attributeName = "lastName")
    public String getLastName() {
        return _lastName;
    }

    public void setLastName(final String _lastName) {
        this._lastName = _lastName;
    }
    @DynamoDBAttribute(attributeName = "phoneNum")
    public String getPhoneNum() {
        return _phoneNum;
    }

    public void setPhoneNum(final String _phoneNum) {
        this._phoneNum = _phoneNum;
    }

}
