package concurrency.RunnableThread;

public class PayrollTaskThread extends Thread {
    private String employeeName;

    PayrollTaskThread(String employeeName){
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
        PayrollTaskThread emp1 = new PayrollTaskThread("Sameer");
        PayrollTaskThread emp2 = new PayrollTaskThread("Fahad");

        emp1.start();
        emp2.start();
    }
}
