package base.ImplementBasicLinkedListOperations;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtStart(20);
        list.insertAtStart(10);

        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.printList();

        list.deleteFromBeginning();
        list.printList();

        list.deleteFromEnd();
        list.printList();

        System.out.println(list.search(30));
        System.out.println(list.search(100));
    }
}
