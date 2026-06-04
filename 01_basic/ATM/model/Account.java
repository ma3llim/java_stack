package ATM.model;

enum accountType {
    SavingsAccount,
    CurrentAccount;
}

public class Account {
    private String bankNumber;
    private String name;
    private String contactNumber;
    private String phoneNumber;
    private String address;
    private double balance;

    public Account(String bankNumber, String name, String contactNumber, String phoneNumber, String address, double balance) {
        this.bankNumber = bankNumber;
        this.name = name;
        this.contactNumber = contactNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = balance;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

