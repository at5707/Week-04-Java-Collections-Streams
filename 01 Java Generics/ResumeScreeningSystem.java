import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;
    private int experienceYears;
    public JobRole(String candidateName,int experienceYears) {
        this.candidateName=candidateName;
        this.experienceYears=experienceYears;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public abstract String getRequiredSkills();
    @Override
    public String toString() {
        return getClass().getSimpleName()+": "+candidateName+" ("+experienceYears+"yrs)-Skills: "+getRequiredSkills();
    }
}
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name,int experienceYears) {
        super(name, experienceYears);
    }
    @Override
    public String getRequiredSkills() {
        return "Java, Data Structures, Algorithms";
    }
}
class DataScientist extends JobRole {
    public DataScientist(String name,int experienceYears) {
        super(name, experienceYears);
    }
    @Override
    public String getRequiredSkills() {
        return "Python, ML, Statistics";
    }
}
class ProductManager extends JobRole {
    public ProductManager(String name,int experienceYears) {
        super(name, experienceYears);
    }
    @Override
    public String getRequiredSkills() {
        return "Leadership, Agile, Product Vision";
    }
}
class Resume<T extends JobRole> {
    private T jobRole;
    public Resume(T jobRole) {
        this.jobRole=jobRole;
    }
    public T getJobRole() {
        return jobRole;
    }
    public void printResume() {
        System.out.println(jobRole);
    }
}
class ResumeProcessor {
    public static<T extends JobRole> void processSingleResume(Resume<T> resume) {
        System.out.println("Processing Resume for: "+resume.getJobRole().getClass().getSimpleName());
        resume.printResume();
    }
    public static void processAllResumes(List<? extends JobRole> jobRoles) {
        System.out.println("\n--- Screening Pipeline ---");
        for (JobRole role : jobRoles) {
            System.out.println("Screening "+role);
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume=new Resume<>(new SoftwareEngineer("Alice", 3));
        Resume<DataScientist> dsResume=new Resume<>(new DataScientist("Bob", 5));
        Resume<ProductManager> pmResume=new Resume<>(new ProductManager("Carol", 7));
        ResumeProcessor.processSingleResume(seResume);
        ResumeProcessor.processSingleResume(dsResume);
        ResumeProcessor.processSingleResume(pmResume);
        List<JobRole> jobRoles=new ArrayList<>();
        jobRoles.add(seResume.getJobRole());
        jobRoles.add(dsResume.getJobRole());
        jobRoles.add(pmResume.getJobRole());
        ResumeProcessor.processAllResumes(jobRoles);
    }
}