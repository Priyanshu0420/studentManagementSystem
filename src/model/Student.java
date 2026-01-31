package model;

public class Student {
    private  String student_name;
    private  int student_age;
    private  String course;
    private  String student_email;


    public Student(String student_name ,int student_age , String course ,  String student_email){
        this.student_name=student_name;
        this.student_age=student_age;
        this.course=course;
        this.student_email=student_email;

    }
    public void setname(String student_name){
        this.student_name=student_name;
    }

    public String getname(){
        return student_name;
    }

    public void setage(int student_age){
        this.student_age=student_age;
    }

    public int getage(){
        return student_age;
    }

    public void setcourse(String course){
        this.course=course;
    }

    public String getcourse(){
        return course;
    }

    public void setemail(String student_email){
        this.student_email=student_email;
    }
    public String getemail(){
        return student_email;
    }
}
