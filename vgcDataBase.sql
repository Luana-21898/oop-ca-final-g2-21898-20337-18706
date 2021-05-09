DROP DATABASE IF EXISTS vgc;

CREATE DATABASE vgc;

USE vgc;

 /* creating student table */
create table Student (
studentId INTEGER NOT NULL AUTO_INCREMENT,
studentName VARCHAR(100) NOT NULL,
password VARCHAR(10) NOT NULL,
contactPhone VARCHAR(20) NOT NULL,
semester VARCHAR(10) NOT NULL,
classRoomId VARCHAR(10) NOT NULL,
PRIMARY KEY(studentId)
 );

/*creating Lecturer table */
create table Lecturer (
lecturerId INTEGER NOT NULL AUTO_INCREMENT,
lecturerName VARCHAR(100) NOT NULL,
password VARCHAR(10) NOT NULL,
contactPhone VARCHAR(20) NOT NULL,
PRIMARY KEY(lecturerId)
);

/*creating admin table */
create table Admin (
adminId INTEGER NOT NULL AUTO_INCREMENT,
adminName VARCHAR(100) NOT NULL,
password VARCHAR(10) NOT NULL,
contactPhone VARCHAR(20) NOT NULL,
PRIMARY KEY(adminId)
);

/*creating course table */
create table Course (
courseId INTEGER NOT NULL AUTO_INCREMENT,
courseName VARCHAR(100) NOT NULL,
enrollFor VARCHAR(20) NOT NULL,
creditHours VARCHAR(20) NOT NULL,
lecturerId INTEGER NOT NULL,
PRIMARY KEY(courseId),
FOREIGN KEY(lecturerId) REFERENCES Lecturer(lecturerId)
);

/*creating ClassRoom table */
create table ClassRoom (
classRoomId VARCHAR(10) NOT NULL,
PRIMARY KEY(classRoomId)
);

  /*creating Attendance table */
 create table Attendance (
 id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
 studentId INTEGER NOT NULL,
 status VARCHAR(20) NOT NULL,
 currentDate DATE NOT NULL,
 courseId INTEGER NOT NULL,
 lecturerId INTEGER NOT NULL,
 classRoomId VARCHAR(10) NOT NULL,
 FOREIGN KEY(courseId) REFERENCES Course(courseId),
 FOREIGN KEY(lecturerId) REFERENCES lecturer(lecturerId),
 FOREIGN KEY(studentId) REFERENCES Student(studentId)
 );

/*creating Announcement table */
create table Announcement (
id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
details VARCHAR(20) NOT NULL,
semester VARCHAR(10) NOT NULL
);

/*creating Enrollment table */
create table Enrollment (
id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
studentId INTEGER NOT NULL,
lecturerId INTEGER NOT NULL,
courseId INTEGER NOT NULL,
classRoomId VARCHAR(10) NOT NULL,
FOREIGN KEY(courseId) REFERENCES Course(courseId),
FOREIGN KEY(lecturerId) REFERENCES lecturer(lecturerId),
FOREIGN KEY(studentId) REFERENCES Student(studentId)
);

/*creating Fee Invoice table */
create table FeeInvoice (
id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
studentId INTEGER NOT NULL,
fee INTEGER NOT NULL,
installment INTEGER NOT NULL,
remaining INTEGER NOT NULL,
status VARCHAR(20) NOT NULL,
dueDate DATE NOT NULL,
FOREIGN KEY(studentId) REFERENCES Student(studentId)
);

/*creating Exam Result table */
create table ExamResult (
id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
studentId INTEGER NOT NULL,
lecturerId INTEGER NOT NULL,
courseId INTEGER NOT NULL,
grade VARCHAR(1) NOT NULL,
FOREIGN KEY(studentId) REFERENCES Student(studentId),
FOREIGN KEY(lecturerId) REFERENCES lecturer(lecturerId),
FOREIGN KEY(courseId) REFERENCES Course(courseId)
);

/*creating Assignment Result table */
create table AssignmentResult (
id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
assignmentDetails VARCHAR(20) NOT NULL,
studentId INTEGER NOT NULL,
lecturerId INTEGER NOT NULL,
courseId INTEGER NOT NULL,
totalMarks DOUBLE NOT NULL,
obtainedMarks DOUBLE NOT NULL,
FOREIGN KEY(studentId) REFERENCES Student(studentId),
FOREIGN KEY(lecturerId) REFERENCES lecturer(lecturerId),
FOREIGN KEY(courseId) REFERENCES Course(courseId)
 );

SELECT * FROM admin;
SELECT * FROM announcement;
SELECT * FROM assignmentresult;
SELECT * FROM attendance;
SELECT * FROM classroom;
SELECT * FROM course;
SELECT * FROM enrollment;
SELECT * FROM examresult;
SELECT * FROM feeinvoice;
SELECT * FROM lecturer;
SELECT * FROM student;

insert into admin (adminId, adminName, password, contactPhone)
values (21898, 'Luana', 12345, '000000');

insert into lecturer (lecturerId, lecturerName,	password, contactPhone)
values (59197, 'Pratik Douglas', 59197, '804054850');

insert into course (courseId, courseName, enrollFor, creditHours, lecturerId)
values (11, 'Computer Fundamentals', 'Year 1', 38 , 59197);

