package handling;

public class Employee {

    static Employee employee;
    public String login, password, name, surname, email;

    private Employee() {
    }

    public static Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }

        return employee;
    }
    
}
