//gives reference for the class and interface
package uk.ac.uos.i2p.assignment;

//imports all of the utilities required for the code
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//declares the Contact Tracing Class, and implements the interface
public class ContactTracingImpl implements ContactTracing{
    //declares all of the maps used
    private Map<String, String> studentList;
    private  Map<String, String> courseList;
    private Map<String, String> emailList;
    private Map<String, String> studentCourseList;
    //first 4 methods for task 1, setting variables equal to information in MainClass.java
    public void loadStudentList(Map<String, String> studentEntry){
        studentList = studentEntry;
    }
    public void loadCourseList(Map<String, String> courseEntry){
        courseList = courseEntry;
    }
    public void loadEmailList(Map<String, String> emailEntry){
        emailList = emailEntry;
    }
    public void loadStudentCourseList(Map<String, String> studentCourseEntry){ studentCourseList = studentCourseEntry; }

    public List<String> findMatchingCourses(String inputStudentNumber){
        String returnValue = studentCourseList.get(inputStudentNumber);
        List<String> courseList = new ArrayList<String>();
        //validation around null return value
        if(returnValue != null){
            courseList.add(returnValue);
        }

        return courseList;
    }

    public List<String> findMatchingStudents(List<String> matchingCourseList){
        List<String> matchingStudents = new ArrayList<String>();
        //for loop, looping through each matching course ID
        matchingCourseList.forEach((courseID)->{
            studentCourseList.forEach((studentID, secondCourseID)->{
                if(secondCourseID == courseID){
                    matchingStudents.add(studentID);
                }
            });
        });

        return matchingStudents;
    }

    public List<String> contactTracing(String inputStudentNumber) {
        List<String> matchingEmails = new ArrayList<String>();
        List<String> matchingCourseList = findMatchingCourses(inputStudentNumber);
        List<String> studentIDList = findMatchingStudents(matchingCourseList);

        //removing already positive student so he doesn't flag up again
        studentIDList.remove(studentIDList.indexOf(inputStudentNumber));

        System.out.println("Course ID: \n" + matchingCourseList.get(0));
        System.out.println("Contact traced for given course: \n" + studentIDList.get(0));
        System.out.println("Matched this student: \n" + inputStudentNumber);

        emailList.forEach((studentNumber, emailAddress) -> {
            if (studentNumber == studentIDList.get(0)) {
                matchingEmails.add(emailAddress);
            }
        });
        return matchingEmails;
    }
}
