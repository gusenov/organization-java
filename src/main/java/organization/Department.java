package organization;  // Пакет – organization.

import java.util.Arrays;
import java.util.Comparator;

/**
 * Публичный класс {@link Department} – подразделения некоторой организации.
 * Класс не хранит явным образом номер подразделения и имя организации, частью которой является
 */
public class Department {
    // Приватные поля класса (доступные только внутри класса):

    /**
     * Разные подразделения имеют разные имена.
     */
    private String name;

    /**
     * Класс хранит явным образом массив своих работников.
     */
    private Employee[] employees;

    // Публичные методы и конструкторы (доступные всем другим классам):

    /**
     * Конструктор может принимать имя подразделения (в этом случае количество работников = 0).
     * @param name имя подразделения.
     */
    public Department(String name) {
        this.name = name;
        this.employees = new Employee[0];
    }

    /**
     * Конструктор может принимать массив работников.
     * @param employees
     */
    public Department(Employee[] employees) {
        this.employees = employees;
    }

    /**
     * Метод получения имени подразделения.
     * @return имя подразделения.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод изменения имени подразделения.
     * @param name новое имя подразделения.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод, возвращающий общее число работников подразделения.
     * @return общее число работников подразделения.
     */
    public int getEmployeesCount() {
        return this.employees.length;
    }

    /**
     * Метод, возвращающий суммарную зарплату всех работников, относящихся к данному подразделению.
     * @return суммарная зарплата всех работников, относящихся к данному подразделению.
     */
    public double getEmployeesSalary() {
        double employeesSalary = 0;
        for (Employee employee : this.employees) {
            employeesSalary += employee.getSalary();
        }
        return employeesSalary;
    }

    /**
     * Метод, возвращающий ссылку на работника по фамилии и имени.
     * @param lastName фамилия.
     * @param firstName имя.
     * @return ссылка на работника.
     */
    public Employee getEmployeeByName(String lastName, String firstName) {
        for (Employee employee : this.employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Метод увольнения работника (принимает в качестве входных параметров фамилию, имя, должность работника,
     * которого нужно удалить, удаляет соответствующий этим данным элемент из массива работников).
     * @param lastName фамилия работника.
     * @param firstName имя работника.
     * @param position должность работника.
     */
    public void fireEmployee(String lastName, String firstName, String position) {
        for (int removedIdx = 0; removedIdx < this.employees.length; removedIdx++) {
            Employee employee = this.employees[removedIdx];
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)
                    && employee.getPosition().equals(position)) {

                Employee[] newEmployees = new Employee[this.employees.length - 1];
                System.arraycopy(this.employees, 0, newEmployees, 0, removedIdx);
                if (this.employees.length != removedIdx) {
                    System.arraycopy(this.employees, removedIdx + 1, newEmployees, removedIdx,
                            this.employees.length - removedIdx - 1);
                }
                this.employees = newEmployees;

                return;
            }
        }
    }

    /**
     * Метод приема работника на работу (принимает в качестве входных параметров ссылку на экземпляр класса {@link Employee},
     * расширяет массив работников путем добавления нового элемента в конец массива);
     * @param newEmployee ссылка на экземпляр класса {@link Employee}.
     */
    public void hireEmployee(Employee newEmployee) {
        Employee[] newEmployees = new Employee[this.employees.length + 1];
        System.arraycopy(this.employees, 0, newEmployees, 0, this.employees.length);
        newEmployees[this.employees.length] = newEmployee;
        this.employees = newEmployees;
    }

    /**
     * Метод, возвращающий массив работников отдела.
     * @return массив работников отдела.
     */
    public Employee[] getEmployees() {
        Employee[] resultEmployees = new Employee[this.employees.length];
        System.arraycopy(this.employees, 0, resultEmployees, 0, this.employees.length);
        return resultEmployees;
    }

    /**
     * Метод, возвращающий массив работников отдела, отсортированный по фамилиям (и если одинаковые фамилии – то по именам).
     * @return массив работников отдела, отсортированный по фамилиям (и если одинаковые фамилии – то по именам).
     */
    public Employee[] getSortedEmployees() {
        Employee[] sortedEmployees = this.getEmployees();
        Arrays.sort(sortedEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                if (employee1.getLastName().equals(employee2.getLastName())) {
                    return employee1.getFirstName().compareTo(employee2.getFirstName());
                }
                return employee1.getLastName().compareTo(employee2.getLastName());
            }
        });
        return sortedEmployees;
    }
}
