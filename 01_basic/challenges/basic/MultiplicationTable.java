package challenges.basic;

public class MultiplicationTable {
    public static void main(String[] args){
        int tableNumber = 4;
        for (int i = 1; i < 11; i++){
            System.out.println(tableNumber + " x " + i + " = " + (i*tableNumber));
        }
    }
}
