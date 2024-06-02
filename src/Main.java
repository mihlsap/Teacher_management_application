import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Creating new teachers
        Teacher teacher = new Teacher("John", "Watson", TeacherCondition.PRESENT, 1988, 7597.87, "982 432 041", "johnwatson93@ex.com");
        Teacher teacher1 = new Teacher("Ronald", "Brown", TeacherCondition.ILL, 1995, 8897.87, "996 486 897", "ronald.brown.352@ex.com");
        Teacher teacher2 = new Teacher("Hugh", "Green", TeacherCondition.DELEGATION, 1985, 12887.87, "394 657 801", "hughgreen.352@ex.com");
        Teacher teacher3 = new Teacher("Joshua", "May", TeacherCondition.ABSENT, 1999, 11457.95, "304 642 124", "joshua.may_21@ex.com");
        Teacher teacher4 = new Teacher("William", "Sparrow", TeacherCondition.ILL, 1991, 10827.53, "312 865 537", "sparrow_william_91@ex.com");
        Teacher teacher5 = new Teacher("Ronald", "Bennett", TeacherCondition.DELEGATION, 1987, 14051.98, "463 789 338", "bennettwilliam.52@ex.com");

        // Creating new class
        ClassTeacher teachers = new ClassTeacher("Class", 5);

        // Adding teachers to a class
        teachers.addTeacher(teacher);
        teachers.addTeacher(teacher1);
        teachers.addTeacher(teacher2);
        teachers.addTeacher(teacher3);

        // Creating new ClassContainer
        ClassContainer classes = new ClassContainer();

        // Adding classes to a ClassContainer
        classes.addClass("class1", 5);
        classes.addClass("class3", 10);

        // Assigning already created class to a ClassContainer with a new name
        classes.assignClass("class2", teachers);

        // Showing summary of classes added to ClassContainer
        System.out.println("\nSummary of classes:");
        classes.summary();

        // Adding teachers to a class in ClassContainer
        System.out.println("\nAdding teachers to a class in ClassContainer:");
        classes.groups.get("class2").addTeacher(teacher4);
        classes.groups.get("class2").addTeacher(teacher5);
        System.out.println("\nSummary of classes after adding teachers to a group:");
        classes.summary();

        // Listing empty classes in ClassContainer
        ArrayList<ClassTeacher> empty_classes = classes.findEmpty();
        System.out.println("\nEmpty classes:");
        for (ClassTeacher classTeacher : empty_classes)
            System.out.println("\t" + classTeacher.name_of_group);

        // Removing class from ClassContainer
        System.out.println("\nAfter deleting class:");
        classes.removeClass("class3");
        classes.summary();

        // Listing teachers data
        System.out.println("\nTeachers in class2:");
        classes.groups.get("class2").summary();

        // Increasing salary of a teacher
        System.out.println("\nSalary of " + teacher1.name + " " + teacher1.surname + " before increase = " + teacher1.salary);
        classes.groups.get("class2").increaseSalary(teacher1, 5292.91);
        System.out.println("Salary of " + teacher1.name + " " + teacher1.surname + " after increase = " + teacher1.salary);

        // Removing teacher from a class
        System.out.println("\nAfter removing teacher " + teacher1.name + " " + teacher1.surname + ":");
        classes.groups.get("class2").removeTeacher(teacher1);
        classes.groups.get("class2").summary();

        // Changing condition of a teacher
        System.out.println("\nCondition of " + teacher2.name + " " + teacher2.surname + " before change = " + teacher2.condition);
        classes.groups.get("class2").changeCondition(teacher2, TeacherCondition.PRESENT);
        for (Teacher t : classes.groups.get("class2").teacherList) {
            if (Objects.equals(t, teacher2))
                System.out.println("Condition of " + t.name + " " + t.surname + " after change = " + t.condition);
        }

        // Searching for a teacher with a given name in a class
        System.out.println("\nFound teacher:");
        classes.groups.get("class2").search("Watson").printing();

        // Searching for teachers whose names or surnames contain given text
        System.out.println("\nResults of partial search:");
        for (Teacher t : classes.groups.get("class2").searchPartial("o"))
            t.printing();

        // Counting teachers being in a given condition
        System.out.println("\nNumber of present teachers = " + classes.groups.get("class2").countByCondition(TeacherCondition.PRESENT));

        // Sorting teachers by name
        System.out.println("\nTeachers sorted by name:");
        for (Teacher t : classes.groups.get("class2").sortByName())
            t.printing();

        // Sorting teachers by salary
        System.out.println("\nTeachers sorted by salary:");
        for (Teacher t : classes.groups.get("class2").sortBySalary())
            t.printing();

        // Returning teacher with a highest salary
        System.out.println("\nTeacher with a highest salary:");
        classes.groups.get("class2").max().printing();
    }
}