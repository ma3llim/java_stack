package practise_files;

public class TryCatch {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        try {
            j = 18 / i;
        } catch (Exception e) {
            System.out.println("Somethings Went Wrong...");
        }

        System.out.println(j);
        System.out.println("Bye");
    }
}
