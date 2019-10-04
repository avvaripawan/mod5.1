import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        menu();
    }

    static void menu(){
        ToDo td = new ToDo();
        Scanner sc = new Scanner(System.in);
        System.out.println("---Task OPS---");
        do {
            String name, description, status, date;
            System.out.println("1.add\n2.remove\n3.update status\n4.Display all pending tasks\n5.Display tasks based on date\n6.Display task based on name\n7.Display over due tasks\n8.print all tasks\n9.Exit");
            System.out.println("Enter the choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name: ");
                    name = sc.nextLine();
                    System.out.println("Enter the description: ");
                    description = sc.nextLine();
                    System.out.println("Enter the status: ");
                    status = sc.next();
                    System.out.println("Enter the date in string format[yyyy/MM/dd]: ");
                    date = sc.next();
                    td.addTask(new Task(name, description, status, new Date(date)));
                    break;
                case 2:
                    System.out.println("Enter the task to be removed. Enter task name: ");
                    name = sc.nextLine();
                    td.remove(name);
                    break;
                case 4:
                    Task[] pendingTasks = td.getPendingTasks();
                    for (int index = 0; index < pendingTasks.length && pendingTasks[index] != null; index++)
                        System.out.println(pendingTasks[index]);
                    break;
                case 5:
                    System.out.println("Enter the date in string [yyyy/MM/dd] format: ");
                    date = sc.next();
                    Task subtasks[] = td.getTasksOnDate(new Date(date));
                    for (int index = 0; index < subtasks.length && subtasks[index] != null; index++)
                        System.out.println(subtasks[index]);
                    break;
                case 3:
                    System.out.println("Enter the task whose status is to be updated. Enter task name: ");
                    name = sc.nextLine();
                    td.update(name);
                    break;
                case 6:
                    System.out.println("Get the task by name.Enter the name: ");
                    name = sc.nextLine();
                    System.out.println(td.getTaskByName(name));
                    break;
                case 7:
                    Task[] tasks = td.getOverDueTasks();
                    for (int index = 0; index < tasks.length && tasks[index] != null; index++)
                        System.out.println(tasks[index]);
                    break;
                case 8:
                    td.displayTasks();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }while(true);
    }
}
