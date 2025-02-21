package kz.bitlab.techorda2025.secondProject.db;

import java.util.*;

public class DBManager {


    static List<Student> students = new ArrayList<>();
    private static Long id = 7L;

    static {
        Student st = Student.builder().id(1L).name("Madiyar").surname("Kypshakbayev").city("Astana").exam(49).build();
        st.setMark(setMarkAut(st.getExam()));

        Student st2 = Student.builder().id(2L).name("Asem").surname("Zhusipbek").city("Astana").exam(80).build();
        st2.setMark(setMarkAut(st2.getExam()));

        Student st3 = Student.builder().id(3L).name("Aisha").surname("Madiyarkyzy").city("Astana").exam(50).build();
        st3.setMark(setMarkAut(st3.getExam()));

        Student st4 = Student.builder().id(4L).name("Balzhan").surname("Madiyarkyzy").city("Astana").exam(69).build();
        st4.setMark(setMarkAut(st4.getExam()));

        Student st5 = Student.builder().id(5L).name("Bekzhan").surname("Madiyaruly").city("Kyzylorda").exam(79).build();
        st5.setMark(setMarkAut(st5.getExam()));

        Student st6 = Student.builder().id(6L).name("Anton").surname("Vasilievich").exam(125).build();
        st6.setMark(setMarkAut(st6.getExam()));

        Collections.addAll(students, st, st2, st3, st4, st5, st6);

    }



    public static String setMarkAut(int exam) {
        if(exam <= 100 && exam > 90) {
            return "A";
        } else if(exam < 90 && exam > 79) {
            return "B";
        } else if(exam < 80 && exam > 69) {
            return "C";
        } else if(exam < 70 && exam > 59) {
            return "D";
        } else if(exam < 60 && exam > 49) {
            return "E";
        } else if(exam < 50 && exam > 0) {
            return "F";
        } else {
            return "WRONG MARK";
        }
    }

    public static List<Student> getStudents() {
        return students;
    }
    public static Student getStudentById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public static void addSt(Student student) {
        student.setId(id);
        students.add(student);
        id++;
    }

    public static void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    static Map<Integer, String> cities = new HashMap<>();

    static {
        cities.put(1, "Almaty");
        cities.put(2, "Astana");
        cities.put(3, "Shymkent");
        cities.put(4, "Kyzylorda");
    }

    public static Map<Integer, String> getCities() {
        return cities;
    }

    public static void updateStudent(Student updatedStudent) {
        students.replaceAll(student -> student.getId().equals(updatedStudent.getId()) ? updatedStudent : student);
    }


}
