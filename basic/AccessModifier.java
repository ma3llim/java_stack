public class AccessModifier {
    public class Car {
        public String brand = "Toyota";

        public void start() {
            System.out.println("Car started");
        }
    }

    public class BankAccount {
        private double balance = 1000;

        public double getBalance() {
            return balance;
        }
    }

    class Animal {
        protected void sound() {
            System.out.println("Animal sound");
        }
    }

    class Dog extends Animal {
        void bark() {
            sound(); // ✅ allowed
        }
    }

    class Student {
        String name = "Sameer"; // default access
    }

    public static void main(String[] args) {
        /*
         * The 4 Access Modifiers
         * 1. public
         * 2. protected
         * 3. default (no keyword)
         * 4. private
         */
    }
}
