package org.example.model;

public class User {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final int age;
    private final String address;
    private final String country;
    private final Boolean newsletterEnabled;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
        this.address =builder.address;
        this.country = builder.country;
        this.newsletterEnabled = builder.newsletterEnabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", newsletterEnabled=" + newsletterEnabled +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public Boolean getNewsletterEnabled() {
        return newsletterEnabled;
    }

    public static class Builder{
        String name;
        String email;
        String phoneNumber;
        int age;
        String address;
        String country;
        Boolean newsletterEnabled;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder country(String country){
            this.country = country;
            return this;
        }
        public Builder newsletterEnabled(Boolean newsletterEnabled){
            this.newsletterEnabled = newsletterEnabled;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}