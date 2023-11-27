/*
* File name : Student
* Author : Bryan Nnadi
* Description of class : Student object
*/
package application;

public class Student {
    private String studentNum;
    private String studentName;
    private String programmeCode;
    private int entryYear;

    public Student() {
        this.studentNum = " ";
        this.studentName = " ";
        if (!programmeCode.substring(0, 2).equals("TU")) {
            this.programmeCode = "ERROR";
            System.out.println("Invalid programme code. Programme code must start with 'TU'.");
        } else {
            this.programmeCode = programmeCode;
        }

        if (entryYear < 2015 || entryYear > 2021) {
            this.entryYear = 0;
            System.out.println("Invalid year. Entry year must be between 2015 and 2021.");
        } else {
            this.entryYear = entryYear;
        }
    }

    public Student(String studentNum, String studentName, String programmeCode, int entryYear) {
        this.studentNum = studentNum;
        this.studentName = studentName;

        if (!programmeCode.substring(0, 2).equals("TU")) {
            this.programmeCode = "ERROR";
            System.out.println("Invalid programme code. Programme code must start with 'TU'.");
        } else {
            this.programmeCode = programmeCode;
        }

        if (entryYear < 2015 || entryYear > 2021) {
            this.entryYear = 0;
            System.out.println("Invalid year. Entry year must be between 2015 and 2021.");
        } else {
            this.entryYear = entryYear;
        }
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
       
            this.programmeCode = programmeCode;
        
    }

    public int getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(int entryYear) {
       
            this.entryYear = entryYear;
        
    }

    public boolean isSamePerson(Student otherStudent) {
        if (otherStudent == null) {
            return false;
        }
        return this.studentNum.equals(otherStudent.getStudentNum());
    }

    public boolean isStudentNumberGreaterThan(Student otherStudent) {
        return this.studentNum.compareTo(otherStudent.getStudentNum()) > 0;
    }

    public boolean isStudentNumberLessThan(Student otherStudent) {
        return this.studentNum.compareTo(otherStudent.getStudentNum()) < 0;
    }

    @Override
    public String toString() {
        return "Student Number: " + studentNum +
                "\nStudent Name: " + studentName +
                "\nProgramme Code: " + programmeCode +
                "\nEntry Year: " + entryYear + "\n";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return studentNum.equals(student.studentNum);
    }
    
}



