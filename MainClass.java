package linkedlist;

public class MainClass {
    public static void main(String[] args) {
        LinkedList p = new LinkedList();
        Person var = null;
        
        // Let's fill the list with ten people
        for (int i = 0; i < 10; i++) {
            var = new Person(i, "TestName" + i, "TestLastName" + i);
            p.insert(var, var.id);
        }
        
        // Search for the person with id = 6
        var = (Person) p.search(6);
        if (var != null)
            System.out.println("Found it: " + var.name);
        else
            System.out.println("Record not found.");
    }
}