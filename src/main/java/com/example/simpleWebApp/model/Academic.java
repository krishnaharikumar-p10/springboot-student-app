package com.example.simpleWebApp.model;

public class Academic {

	private int studentId;
    private String course;
    private double cgpa;
    private boolean hasHonors;
    private boolean hasMinors;

    public Academic() {}

    public Academic(int studentId, String course, double cgpa, boolean hasHonors, boolean hasMinors) {
        this.studentId = studentId;
        this.course = course;
        this.cgpa = cgpa;
        this.hasHonors = hasHonors;
        this.hasMinors = hasMinors;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public boolean isHasHonors() {
        return hasHonors;
    }

    public void setHasHonors(boolean hasHonors) {
        this.hasHonors = hasHonors;
    }

    public boolean isHasMinors() {
        return hasMinors;
    }

    public void setHasMinors(boolean hasMinors) {
        this.hasMinors = hasMinors;
    }
    
	@Override
	public String toString() {
		return "Academic [studentId=" + studentId + ", course=" + course + ", cgpa=" + cgpa + ", hasHonors=" + hasHonors
				+ ", hasMinors=" + hasMinors + "]";
	}
}


