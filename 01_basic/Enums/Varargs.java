package Enums;

class Sums {
    private int total;

    Sums(int... numbers){
        this.total = 0;

        for(int number: numbers){
            total+=number;
        }
    }

   public int getTotal(){
        return total;
   }
}
public class Varargs {
    public static void main(String[] args){
        Sums s = new Sums(1, 2, 3);
        Sums s2 = new Sums(10, 20);
        Sums s3 = new Sums();

        System.out.println(s.getTotal());
        System.out.println(s2.getTotal());
        System.out.println(s3.getTotal());
    }
}
