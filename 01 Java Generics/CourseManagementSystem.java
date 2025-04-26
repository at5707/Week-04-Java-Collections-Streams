import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String courseName;
    private String department;
    public CourseType(String courseName,String department) {
        this.courseName=courseName;
        this.department=department;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getDepartment() {
        return department;
    }
    public abstract String getEvaluationMethod();
    @Override
    public String toString() {
        return courseName+" ("+department+")- "+getEvaluationMethod();
    }
}
class ExamCourse extends CourseType {
    public ExamCourse(String courseName,String department) {
        super(courseName, department);
    }
    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName,String department) {
        super(courseName, department);
    }
    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName,String department) {
        super(courseName, department);
    }
    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}
class Course<T extends CourseType> {
    private T courseType;
    public Course(T courseType) {
        this.courseType=courseType;
    }
    public T getCourseType() {
        return courseType;
    }
    @Override
    public String toString() {
        return courseType.toString();
    }
}
class CourseUtils {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println(c);
        }
    }
}
public class CourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> math=new Course<>(new ExamCourse("Mathematics 101", "Science"));
        Course<AssignmentCourse> history=new Course<>(new AssignmentCourse("World History", "Arts"));
        Course<ResearchCourse> aiResearch=new Course<>(new ResearchCourse("AI Thesis", "Engineering"));
        List<CourseType> catalog=new ArrayList<>();
        catalog.add(math.getCourseType());
        catalog.add(history.getCourseType());
        catalog.add(aiResearch.getCourseType());
        System.out.println("Course Catalog:");
        CourseUtils.displayAllCourses(catalog);
    }
}