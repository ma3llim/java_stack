enum Status {
    Running, Failed, Pending, Success;
}

public class enums {
    public static void main(String[] args) {
        Status[] statuses = Status.values();
        for (Status s : statuses)
            System.out.println(s);
    }
}