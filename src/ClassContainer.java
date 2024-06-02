import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassContainer {
    Map<String, ClassTeacher> groups;
    ClassContainer() { groups = new HashMap<>(); }
    void addClass(String s, int i) {
        ClassTeacher classTeacher = new ClassTeacher(s, i);
        groups.put(s, classTeacher);
    }

    void assignClass(String s, ClassTeacher classTeacher) {
        classTeacher.name_of_group = s;
        groups.put(s, classTeacher);
    }

    void removeClass(String s) { groups.remove(s); }
    ArrayList<ClassTeacher> findEmpty() {
        ArrayList<ClassTeacher> empty = new ArrayList<>();
        for (ClassTeacher classTeacher : groups.values())
            if (classTeacher.teacherList.isEmpty())
                empty.add(classTeacher);
        return empty;
    }

    void summary() {
        System.out.println("Classes in ClassContainer:");
        for (ClassTeacher classTeacher : groups.values()) {
            System.out.println("\tGroup's data:");
            System.out.println("\t\tGroup's name: " + classTeacher.name_of_group);
            System.out.println("\t\tPercentage of group's occupancy: " + (((double)classTeacher.teacherList.size() / (double)classTeacher.max_number_of_teachers) * 100) + "%");
        }
    }
}
