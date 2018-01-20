package organization;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Отдельный класс для тестирования конструкторов и вызовов методов {@link Department}.
 */
public class TestDepartment {
    @Test
    public void testDepartment() {
        Department department = new Department("Отдел снабжения");
        assertEquals("Отдел снабжения", department.getName());
        assertEquals(0, department.getEmployeesCount());
        assertEquals(0, department.getEmployeesSalary(), 0);
    }

    @Test
    public void test() {
        Department department = new Department("Отдел разработки ПО");

        Employee teamLeader = new Employee("Владимир", "Соколов", "ведущий разработчик", 100000.0);
        department.hireEmployee(teamLeader);
        assertEquals(teamLeader, department.getEmployeeByName("Соколов", "Владимир"));

        Employee javaDev = new Employee("Артемий", "Королев", "Java–разработчик", 60000.0);
        department.hireEmployee(javaDev);
        assertEquals(javaDev, department.getEmployeeByName("Королев", "Артемий"));

        Employee techWriter = new Employee("Иван", "Виноградов", "технический писатель", 40000.0);
        department.hireEmployee(techWriter);
        assertEquals(techWriter, department.getEmployeeByName("Виноградов", "Иван"));

        Employee sysAdm = new Employee("Кирилл", "Зайцев", "системный администратор", 45000.0);
        department.hireEmployee(sysAdm);
        assertEquals(sysAdm, department.getEmployeeByName("Зайцев", "Кирилл"));

        Employee uxDesigner = new Employee("Антон", "Орехов", "UX дизайнер", 37250.0);
        department.hireEmployee(uxDesigner);
        assertEquals(uxDesigner, department.getEmployeeByName("Орехов", "Антон"));

        Employee juniorDev = new Employee("Филипп", "Орехов", "младший программист", 30000.0);
        department.hireEmployee(juniorDev);
        assertEquals(juniorDev, department.getEmployeeByName("Орехов", "Филипп"));

        assertEquals(6, department.getEmployeesCount());
        assertEquals(100000.0 + 60000.0 + 40000.0 + 45000.0 + 37250.0 + 30000.0, department.getEmployeesSalary(), 0);

        Employee[] sortedEmployees = department.getSortedEmployees();
        assertArrayEquals(new Employee[]{ techWriter, sysAdm, javaDev, uxDesigner, juniorDev, teamLeader }, department.getSortedEmployees());

        department.fireEmployee("Орехов", "Филипп", "младший программист");

        assertEquals(5, department.getEmployeesCount());
        assertEquals(100000.0 + 60000.0 + 40000.0 + 45000.0 + 37250.0, department.getEmployeesSalary(), 0);
    }
}