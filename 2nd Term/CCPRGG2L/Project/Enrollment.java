import java.util.Scanner;

    class User {
        String username;
        String password;
        String role;
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }   
}


    class Course {
        String courseCode;
        String courseTitle;
        int units;

    public Course(String courseCode, String courseTitle, int units) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.units = units;
}
    
    public String getCourseCode() {
        return courseCode;
}
    public String getCourseTitle() {
        return courseTitle;
}
    public int getUnits() {
        return units;
    }
}
    class EnrollmentSystem {
        User[] users = new User[10];
            int userCount = 0;
        Course[] courses = new Course[10];
            int courseCount = 0;
        Scanner sc = new Scanner(System.in);
        
    public void registerAccount() {
        System.out.println("| REGISTER ACCOUNT |");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter role (student/admin): ");
        String role = sc.nextLine();
        users[userCount++] = new User(username, password, role);
        System.out.println("\n Account registered successfully!");
    }
    
    public boolean login(String username, String password) {
        for (int i = 0; i < userCount; i++) {
        if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
        return true;
    }
}
return false;
}
    //ADMIN - Add Courses
    public void addCourse() {
        System.out.println("| ADD COURSE |");
        System.out.print("Enter course code: ");
            String courseCode = sc.nextLine();
        System.out.print("Enter course title: ");
            String courseTitle = sc.nextLine();
        System.out.print("Enter units: ");
            int units = sc.nextInt();
            
        courses[courseCount++] = new Course(courseCode, courseTitle, units);
            System.out.println("Course added successfully!");   
    }
    
    //ADMIN / STUDENT - View Courses *Enlist courses first using the admin before entering as student
    public void viewCourses() {
        System.out.println("List of Courses: ");
    for (int i = 0; i < courseCount; i++) {
        System.out.println(courses[i].getCourseCode() + " - " + courses[i].getCourseTitle() + " (" + courses[i].getUnits() + " units)");
    }
}
    //Course Code Example :CRPPGL
    public void enroll() {
        System.out.print("Enter course code: ");
        String courseCode = sc.nextLine();
        int courseIndex = -1;
        
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equals(courseCode)) {
            courseIndex = i;
        break;
        }
    }
    if (courseIndex == -1) {
        System.out.println("Course not found.");
    return;
    }
    
        System.out.println("You have enrolled in: " + courses[courseIndex].getCourseTitle());
}
}
    //ENROLLMENT FRONT
    public class Enrollment {
        
        //REGISTRATION MODULE
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            EnrollmentSystem es = new EnrollmentSystem();
        while (true) {
            System.out.println("Welcome to the XYZ University Enrollment System");
            System.out.println("[1] Register Account");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.print("\nEnter choice: ");
        int choice = sc.nextInt();
        
        //LOGIN
        if (choice == 1) {
            es.registerAccount();
        } 
        else if (choice == 2) {
            
            System.out.println("| LOGIN ACCOUNT |");
            System.out.print("Enter username: ");
                String username = sc.next();
            System.out.print("Enter password: ");
                String password = sc.next();
            boolean isValid = es.login(username, password);
            
        if (!isValid) {
            System.out.println("Invalid username or password.");
        } 
        else {
            User user = null;
            
        for (int i = 0; i < es.userCount; i++) {
        
            if (es.users[i].getUsername().equals(username) && es.users[i].getPassword().equals(password)) {
            user = es.users[i];
        break;
        }
}
        //ADMIN/FACULTY MODULE        
        if (user.getRole().equals("admin")) {

        while (true) {
            System.out.println("\nWelcome, Admin");
            System.out.println("[1] Add Course");
            System.out.println("[2] View Courses");
            System.out.println("[3] Logout");
            System.out.print("Enter choice: ");
        int adminChoice = sc.nextInt();

        if (adminChoice == 1) {
            es.addCourse();
        } 
        else if (adminChoice == 2) {
            es.viewCourses();
        } 
        else if (adminChoice == 3) {
            break;
        }
    }      
} 
        
        //STUDENT MODULE
        else if (user.getRole().equals("student")) {
        while (true) {
            System.out.println("\nWelcome, Student");
            System.out.println("[1] Enroll");
            System.out.println("[2] View Courses");
            System.out.println("[3] Logout");
            System.out.print("Enter choice: ");
        int studentChoice = sc.nextInt();
        
        if (studentChoice == 1) {
            es.enroll();
        } 
        else if (studentChoice == 2) {
            es.viewCourses();
        } 
        else if (studentChoice == 3)
        {
        break;
        }
    }
}
}
} 
    else if (choice == 3) {
        System.out.println("Goodbye!");
        break;
    }
}
}
}

