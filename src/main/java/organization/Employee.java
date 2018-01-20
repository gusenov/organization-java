package organization;  // Пакет – organization.

/**
 * Публичный класс {@link Employee} - работник некоторой организации.
 * Класс не хранит явным образом номер или имя подразделения и организации, в которой работает работник.
 */
public class Employee {
    // Статичные публичные константы:
    public static final String DEFAULT_POSITION = "инженер";
    public static final Double DEFAULT_SALARY = 30000.0;

    // Приватные поля класса (доступные только внутри класса):

    /**
     * Каждый работник характеризуется именем.
     */
    private String firstName;

    /**
     * Каждый работник характеризуется фамилией.
     */
    private String lastName;

    /**
     * Каждый работник занимает определенную должность.
     */
    private String position;

    /**
     * Каждый работник получает определенное жалование.
     */
    private Double salary;

    // Публичные методы и конструкторы (доступные всем другим классам):

    /**
     * Конструктор может принимать имя и фамилию.
     * @param firstName имя.
     * @param lastName фамилия.
     */
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Использование значений по-умолчанию:
        // (должность – инженер, жалование – 30к руб.)
        this.setPosition(Employee.DEFAULT_POSITION);
        this.setSalary(Employee.DEFAULT_SALARY);
    }

    /**
     * Конструктор может принимать имя, фамилию, должность, жалование.
     * @param firstName имя.
     * @param lastName фамилия.
     * @param position должность.
     * @param salary жалование.
     */
    public Employee(String firstName, String lastName, String position, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    /**
     * Метод получения имени.
     * @return имя.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Метод изменения имени.
     * @param firstName новое имя.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Метод получения фамилии.
     * @return фамилия.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Метод изменения фамилии.
     * @param lastName новая фамилия.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Метод получения должности.
     * @return должность.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Метод изменения должности.
     * @param position новая должность.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Метод получения жалования.
     * @return жалование.
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Метод изменения жалования.
     * @param salary новое жалование.
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
