package Enums;

enum Role {
    ADMIN("Full Access"),
    USER("Limited Access");

    private String description;

    Role(String description){
        this.description = description;
    }

    public String getDescription(){
        return  description;
    }
}

public class Enums {
    public static void main(String[] args){
        System.out.println(Role.ADMIN.getDescription());
        System.out.println(Role.USER.getDescription());
    }
}
