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

    public static void insert(HashSet<String> hs)
    {
        System.out.println("Enter the task to add");
        String task=pro.nextLine().trim().toLowerCase();
        if(task.isEmpty())
        {
            System.out.println("Task Cannot be Empty");
            return;
        }
        if(hs.contains(task))
        {
            System.out.println("Task already Present");
            return;
        }
        hs.add(task);
        save(hs, FILE_NAME);
        System.out.println("Task Successfully Added");
    }
    public static void delete(HashSet<String> hs)
    {
        System.out.println("Enter the task to delete");
        String task=pro.nextLine().trim().toLowerCase();
        if(!hs.contains(task))
        {
            System.out.println("Task Not present");
            return;
        }
        hs.remove(task);
        save(hs, FILE_NAME);
        System.out.println("Task Successfully Deleted");
    }
    public static void display(HashSet<String> hs) 
    {
        if (hs.isEmpty()) 
        {
            System.out.println("No tasks available.");
        } 
        else
        {
            System.out.println("Current Tasks:");
            for (String task : hs) 
            {
                System.out.println("- " + task);
            }
        }
    }
    public static void load(HashSet<String> hs, String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                if (!line.trim().isEmpty())
                    hs.add(line.trim().toLowerCase());
            }
        }
        catch (FileNotFoundException e)
        {
            
        }
        catch (IOException e)
        {
            System.out.println("Error reading from file.");
        }
    }

    public static void save(HashSet<String> hs, String fileName)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            for (String task : hs)
                bw.write(task + "\n");
        }
        catch (IOException e)
        {
            System.out.println("Error saving to file.");
        }
    }


    public static void main(String[] args) 
    {
        String str;
        LinkedHashSet<String> hs=new LinkedHashSet<>();
        load(hs, FILE_NAME); // load tasks on startup
        do
        {
            
            System.out.println("What Would You Like To do Today:\n1.Add a Task \n2.Remove a Task \n3.Display Tasks");
            str=pro.nextLine();
            if(str.equalsIgnoreCase("Add a Task")||str.equals("1"))
            {
                insert(hs);
            }

            else if(str.equalsIgnoreCase("Remove a Task")||str.equals("2"))
            {
                delete(hs);
            }
            else if(str.equalsIgnoreCase("Display Tasks")||str.equals("3"))
            {
                display(hs);
            }
            else
            {
                System.out.println("Invalid Input!");
            }
            System.out.println("Type Exit or -1 to exit the program or Anything to continue");
            str=pro.nextLine();
        }while(!(str.equalsIgnoreCase("Exit")||str.equalsIgnoreCase("-1")));
        System.out.println("Byee! Come Back Soon");
    
    }
}
