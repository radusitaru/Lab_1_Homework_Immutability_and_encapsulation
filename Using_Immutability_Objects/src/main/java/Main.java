import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Project project = new Project("Test", 15, new ArrayList<>(List.of(Project.Category.Electronics)), "Its just a test1");
        Project project2 = new Project("Test2", 25, new ArrayList<>(List.of(Project.Category.Clothes)), "Its just a test2");
        Project project3 = new Project("Test3", 35, new ArrayList<>(List.of(Project.Category.DYI)), "Its just a test3");
        Project project4 = new Project("Test4", 45, new ArrayList<>(List.of(Project.Category.Food)), "Its just a test4");
        System.out.println(project);
        System.out.println(project2);
        System.out.println(project3);
        System.out.println(project4);

        //No getter, no setter method, object is immutable & encapsulated.

    }
}
