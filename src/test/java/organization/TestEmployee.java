package organization;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Отдельный класс для тестирования конструкторов и вызовов методов {@link Employee}.
 */
public class TestEmployee {
    @Test
    public void testEmployee() {
        Employee employee = new Employee("Александр", "Суворов");
        assertEquals("Александр", employee.getFirstName());
        assertEquals("Суворов", employee.getLastName());
        assertEquals("инженер", employee.getPosition());
        assertEquals(Employee.DEFAULT_SALARY, employee.getSalary(), 0);

        employee = new Employee("Юрий", "Федоров", "программист", 75000.0);
        assertEquals("Юрий", employee.getFirstName());
        assertEquals("Федоров", employee.getLastName());
        assertEquals("программист", employee.getPosition());
        assertEquals(75000.0, employee.getSalary(), 0);
    }

    @Test
    public void testSet() {
        Employee employee = new Employee("Виктория", "Крылова", "бухгалтер", 30000.0);

        employee.setFirstName("Викторина");
        employee.setLastName("Орлова");
        employee.setPosition("старший бухгалтер");
        employee.setSalary(49000.0);

        assertEquals("Викторина", employee.getFirstName());
        assertEquals("Орлова", employee.getLastName());
        assertEquals("старший бухгалтер", employee.getPosition());
        assertEquals(49000.0, employee.getSalary(), 0);
    }
}
