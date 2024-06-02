import java.util.*;

public class ClassTeacher {
    String name_of_group;
    ArrayList<Teacher> teacherList;
    int max_number_of_teachers;

    ClassTeacher(String name, int max) {
        name_of_group = name;
        max_number_of_teachers = max;
        teacherList = new ArrayList<>();
    }

    void addTeacher(Teacher t) {
        if (teacherList.size() < max_number_of_teachers){
            for (Teacher teacher : teacherList)
                if (Objects.equals(teacher.name, t.name) && Objects.equals(teacher.surname, t.surname)){
                    System.out.println("Particular teacher has already been added to the group.");
                    return;
                }
            teacherList.add(t);
            System.out.println("Teacher " + t.name + " " + t.surname + " has been added to the group " + name_of_group + ".");
        }
        else System.out.println("Maximum number of teachers has been reached in group " + name_of_group + ". Cannot add new teacher.");
    }

    void increaseSalary(Teacher t, double number) {
        for (Teacher teacher : teacherList)
            if (teacher == t)
                teacher.salary += number;
    }

    void  removeTeacher(Teacher t){ teacherList.remove(t); }

    void changeCondition(Teacher t, TeacherCondition c) {
        for (Teacher teacher : teacherList)
            if (teacher == t)
                teacher.condition = c;
    }

    Teacher search(String s) {
        for (Teacher t : teacherList)
            if (Objects.equals(t.surname, s))
                return t;
        System.out.println("Teacher with a given surname does not belong to this group.");
        return null;
    }

    ArrayList<Teacher> searchPartial(String s) {
        ArrayList<Teacher> arrayList = new ArrayList<>();
        for (Teacher teacher : teacherList)
            if (teacher.name.contains(s) || teacher.surname.contains(s))
                arrayList.add(teacher);
        return arrayList;
    }

    int countByCondition(TeacherCondition c) {
        int number = 0;
        for (Teacher teacher : teacherList)
            if (teacher.condition == c)
                number++;
        return number;
    }

    void summary(){
        for (Teacher teacher : teacherList)
            teacher.printing();
    }

    ArrayList<Teacher> sortByName() {
        ArrayList<Teacher> teachers = teacherList;
        teachers.sort(Comparator.comparing(t -> t.surname));
        return teachers;
    }

    public static Comparator<Teacher> salaryComparator = new Comparator<Teacher>() {
        @Override
        public int compare(Teacher t1, Teacher t2) {
            return Double.compare(t2.salary, t1.salary);
        }
    };

    ArrayList<Teacher> sortBySalary() {
        ArrayList<Teacher> teachers = teacherList;
        teachers.sort(salaryComparator);
        return  teachers;
    }

    Teacher max() { return Collections.max(teacherList, (Comparator.comparingDouble(t -> t.salary))); }

}
