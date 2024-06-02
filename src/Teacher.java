public class Teacher implements Comparable<Teacher> {
    String name, surname;
    TeacherCondition condition;
    int birth_year;
    double salary;
    String phone_number;
    String email;

    Teacher(String n, String sn, TeacherCondition c, int by, double s, String pn, String e) {
        name = n;
        surname = sn;
        condition = c;
        birth_year = by;
        salary = s;
        phone_number = pn;
        email = e;

    }

     void printing() {
        System.out.println("Teacher's data:");
        System.out.println("\tName: " + name);
        System.out.println("\tSurname: " + surname);
        System.out.println("\tCondition: " + condition);
        System.out.println("\tBirth year: " + birth_year);
        System.out.println("\tSalary: " + salary);
        System.out.println("\tPhone number: " + phone_number);
        System.out.println("\tEmail: " + email);

    }

    @Override
    public int compareTo(Teacher teacher) {
        if (this.surname.compareTo(teacher.surname) != 0)
            return this.surname.compareTo(teacher.surname);
        else return this.name.compareTo(teacher.name);
    }

}
