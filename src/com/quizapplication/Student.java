package com.quizapplication;

public class Student
{
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String mailId;
    private String mobileNumber;
    private String userName;
    private String password;

    public Student()
    {}

    public Student(String firstName, String lastName, String city, String mailId, String mobileNumber, String userName, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.mailId = mailId;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.password = password;
    }


    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getMailId()
    {
        return mailId;
    }
    public void setMailId(String mailId)
    {
        this.mailId = mailId;
    }
    public String getMobileNumber()
    {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}