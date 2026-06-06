package concurrency.RunnableThread;

public class PayrollTaskRunnable implements Runnable {
    private String employeeName;

    public PayrollTaskRunnable(String employeeName){
        this.employeeName = employeeName;
    }

    @Override
    public void run(){
        System.out.println(
                "Generating payroll for: " + employeeName + " | Thread" + Thread.currentThread().getName()
        );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Payroll Completed For: " + employeeName);
    }

    public static void main(String[] args){
        Runnable emp1 = new PayrollTaskRunnable("Sameer");
        Runnable emp2 = new PayrollTaskRunnable("Uday");
        Runnable emp3 = new PayrollTaskRunnable("Jeevan");
        Runnable emp4 = new PayrollTaskRunnable("Gokul");
        Runnable emp5 = new PayrollTaskRunnable("Fahad");
        Runnable emp6 = new PayrollTaskRunnable("Khaja");
        Runnable emp7 = new PayrollTaskRunnable("Khalid");

        Thread t1 = new Thread(emp1);
        Thread t2 = new Thread(emp2);
        Thread t3 = new Thread(emp3);
        Thread t4 = new Thread(emp4);
        Thread t5 = new Thread(emp5);
        Thread t6 = new Thread(emp6);
        Thread t7 = new Thread(emp7);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}
