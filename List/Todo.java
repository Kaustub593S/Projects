package List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Todo
{
    public static Scanner pro=new Scanner(System.in);
    public static final String FILE_NAME = "tasks.txt";

    public static void insert(ArrayList<Task> tasks) 
    {
    System.out.println("Enter the task description:");
    String desc = pro.nextLine().trim();

    System.out.println("Enter the priority (High/Medium/Low):");
    String priority = pro.nextLine().trim();

    System.out.println("Enter the due date (YYYY-MM-DD):");
    String dueDate = pro.nextLine().trim();

    Task newTask = new Task(desc, priority, dueDate);

    if (tasks.contains(newTask)) 
    {
        System.out.println("Task already exists.");
        return;
    }

    tasks.add(newTask);
    save(tasks, FILE_NAME);
    System.out.println("Task Successfully Added.");
    }

    public static void delete(ArrayList<Task> tasks) 
    {
    System.out.println("Enter the description of the task to delete:");
    String desc = pro.nextLine().trim().toLowerCase();

    boolean removed = tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(desc));
    if (removed) 
    {
        save(tasks, FILE_NAME);
        System.out.println("Task deleted.");
    } 
    else 
    {
        System.out.println("Task not found.");
    }
    }

    public static void display(ArrayList<Task> tasks) 
    {
        if (tasks.isEmpty())
        {
            System.out.println("No tasks available.");
        } 
        else 
        {
            System.out.println("Tasks:");
            for (Task task : tasks) 
             System.out.println("- " + task);
            
        }
    }

    public static void load(ArrayList<Task> tasks, String fileName) 
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    Task task = new Task(parts[0], parts[1], parts[2]);
                    tasks.add(task);
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            // First run, file might not exist — ignore
        } 
        catch (IOException e) 
        {
            System.out.println("Error reading from file.");
        }
    }


    public static void save(ArrayList<Task> tasks, String fileName) 
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) 
        {
            for (Task task : tasks) 
            {
                bw.write(task.getDescription() + "|" + task.getPriority() + "|" + task.getDueDate() + "\n");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error saving to file.");
        }
    }



    public static void main(String[] args) 
    {
    ArrayList<Task> tasks = new ArrayList<>();
    load(tasks, FILE_NAME);

    String str;
    do 
    {
        System.out.println("What would you like to do?\n1. Add Task\n2. Remove Task\n3. Display Tasks");
        str = pro.nextLine();

        if (str.equalsIgnoreCase("1") || str.equalsIgnoreCase("Add Task"))
            insert(tasks);
        else if (str.equalsIgnoreCase("2") || str.equalsIgnoreCase("Remove Task"))
            delete(tasks);
        else if (str.equalsIgnoreCase("3") || str.equalsIgnoreCase("Display Tasks"))
            display(tasks);
        else
            System.out.println("Invalid Input!");

        System.out.println("Type Exit or -1 to quit, or anything else to continue.");
        str = pro.nextLine();
    } while (!(str.equalsIgnoreCase("exit") || str.equals("-1")));

    System.out.println("Bye! Come back soon.");
    }
}
