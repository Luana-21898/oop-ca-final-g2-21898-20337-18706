package com.company;

public class TestDriver {
    public void run() {

        //Adding data
        Admin admin = new Admin("Luana", "França", "LF1206", "luana@admin.com",
                "luanafranca", "lf12345");


        Course bScInScienceInComputing = admin.createCourse("BSc in Science in Computing", "Level 7 NFQ",
                "Tues - Wed - Thu", "3 years", 4700);

        Course bachelorOfBusiness = admin.createCourse("Bachelor of Business", "Level 7 NFQ",
                "Mon - Wed - Fri", "3 years", 4200);


        FacultyMember facultyMember1 = admin.createFacultyMember("Alice", "Wang", "AW1234",
                "alice@college.ie", "alicewang", "aw12345", "Academic",
                "Computing Lecturer");

        FacultyMember facultyMember2 = admin.createFacultyMember("Arnold", "Smith", "AS1234",
                "arnold@college.ie", "arnoldsmith", "am12345", "Finance",
                "Financial Controller");


        Student student1 = admin.createStudent("Andrew", "Welsh", "AW1234",
                "andrew@student.ie", "andrewwelsh", "aw12345", bScInScienceInComputing);

        Student student2 = admin.createStudent("Catarina", "Simpson", "CS1234",
                "catarina@student.ie", "catarinasimpson", "cs12345", bachelorOfBusiness);

    }
}
