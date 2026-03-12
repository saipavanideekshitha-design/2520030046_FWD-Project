package DSA;
import java.util.*;

// Student Class
class Student {

    String name;
    String roll;
    int marks;

    // Constructor
    Student(String name, String roll, int marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    // Display student details
    void display() {
        System.out.println("Name: " + name + " | Roll: " + roll + " | Marks: " + marks);
    }
}

public class StudentRanking {

    // ArrayList for sorting students
    static ArrayList<Student> students = new ArrayList<>();

    // Searching (Linear Search)
    public static Student searchStudent(String roll) {

        for (Student s : students) {
            if (s.roll.equals(roll)) {
                return s;
            }
        }

        return null;
    }

    // Sorting (Bubble Sort - Descending Marks)
    public static void sortStudents() {

        for (int i = 0; i < students.size() - 1; i++) {

            for (int j = 0; j < students.size() - i - 1; j++) {

                if (students.get(j).marks < students.get(j + 1).marks) {

                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);

                }
            }
        }

        System.out.println("Students sorted by marks (Highest first).");
    }

    // Display Students with Rank
    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        int rank = 1;

        System.out.println("\nStudent Records:");

        for (Student s : students) {
            System.out.print("Rank " + rank + " - ");
            s.display();
            rank++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Stack
        Stack<Student> stack = new Stack<>();

        // Queue
        Queue<Student> queue = new LinkedList<>();

        // Heap (PriorityQueue)
        PriorityQueue<Student> heap = new PriorityQueue<>(new Comparator<Student>() {
            public int compare(Student a, Student b) {
                return b.marks - a.marks;
            }
        });

        int choice;

        do {

            System.out.println("\n===== Dynamic Student Ranking And Records =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Sort Students By Marks");
            System.out.println("5. Stack Pop (Undo Last Added)");
            System.out.println("6. Queue Remove (First Added)");
            System.out.println("7. Show Top Rank Student (Heap)");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    String roll = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    Student s = new Student(name, roll, marks);

                    students.add(s);
                    stack.push(s);
                    queue.add(s);
                    heap.add(s);

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:

                    displayStudents();
                    break;

                case 3:

                    System.out.print("Enter Roll Number To Search: ");
                    String searchRoll = sc.nextLine();

                    Student result = searchStudent(searchRoll);

                    if (result != null) {
                        System.out.println("Student Found:");
                        result.display();
                    } else {
                        System.out.println("Student Not Found.");
                    }

                    break;

                case 4:

                    sortStudents();
                    displayStudents();
                    break;

                case 5:

                    if (!stack.isEmpty()) {

                        Student removed = stack.pop();

                        students.remove(removed);
                        queue.remove(removed);
                        heap.remove(removed);

                        System.out.println("Removed using Stack:");
                        removed.display();

                    } else {
                        System.out.println("Stack is Empty.");
                    }

                    break;

                case 6:

                    if (!queue.isEmpty()) {

                        Student removed = queue.poll();

                        students.remove(removed);
                        stack.remove(removed);
                        heap.remove(removed);

                        System.out.println("Removed using Queue:");
                        removed.display();

                    } else {
                        System.out.println("Queue is Empty.");
                    }

                    break;

                case 7:

                    if (!heap.isEmpty()) {

                        Student top = heap.peek();

                        System.out.println("Top Rank Student:");
                        top.display();

                    } else {
                        System.out.println("No students available.");
                    }

                    break;

                case 8:

                    System.out.println("Program Closed.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}