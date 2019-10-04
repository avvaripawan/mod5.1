import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ToDo {
    /Fields
    Task[] tasks;
    private int countTask;

    //Constructor
    public ToDo(){
        tasks = new Task[10];
        countTask = 0;
    }

    //methods

    /**
     * This method is used to add the task in the tasks array
     * @param task, we pass a task class object to this method as parameter.
     */
    public void addTask(Task task){
        tasks[countTask++] = task;
    }


    /**
     * This method takes the task name and based on the task name we remove the task from the tasks array.
     * @param taskName, this is a string and based on the task name we remove the task in the array.
     */
    public void remove(String taskName){
        for(int index = 0; index<countTask ; index++)
            if (tasks[index].getName().equalsIgnoreCase(taskName)){
                Task temp = tasks[index];
                // left shifting the object values.
                for (int temp_index = index; temp_index<countTask; temp_index++)
                    tasks[temp_index] = tasks[temp_index + 1];
                System.out.println(temp);
                countTask--;
            }
    }

    /**
     * This method updates the status based on the task if the name is not found or the task is already completedd it return null else
     * this method returns the task details.
     * @param taskName, this is a string and says which task to be updated
     * @return this returns a task class object after updating the status of the task.
     */
    public Task update(String taskName){
        for (int index = 0; index < countTask; index++)
            if(taskName.equalsIgnoreCase(tasks[index].getName())){
                if (tasks[index].getStatus().equalsIgnoreCase("incomplete") || tasks[index].getStatus().equalsIgnoreCase("processing")) {
                    tasks[index].setStatus("complete");
                    return tasks[index];
                }
            }
        return null;
    }

    /**
     * this method gives all the pending tasks
     * @return an array of tasks which are pending.
     */
    public Task[] getPendingTasks(){
        Task[] subarray = new Task[1];
        for (int index = 0; index<countTask; index++)
            if (tasks[index].getStatus().equalsIgnoreCase("incomplete") || tasks[index].getStatus().equalsIgnoreCase("processing")) {
                subarray[subarray.length - 1] = tasks[index];
                subarray = Arrays.copyOf(subarray, subarray.length + 1);
            }
        return subarray;
    }

    /**
     * This method gets the tasks on the given date. It searches for the tasks on the passed parameter date.
     * @param date, this is a Date object parameter where we pass the date in the form of the String.
     * @return this returns the tasks description which have the same date.
     */
    public Task[] getTasksOnDate(Date date){
        Task[] subarray = new Task[1];
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String searchDate = formatter.format(date);
        for (int index = 0; index<countTask; index++) {
            String dueDate = formatter.format(tasks[index].getDueDate());
            if (searchDate.equals(dueDate)) {
                subarray[subarray.length - 1] = tasks[index];
                subarray = Arrays.copyOf(subarray, subarray.length + 1);
            }
        }
        return subarray;
    }

    /**
     * This gets the task by the supplied name.
     * @param taskName, here task name is a String
     * @return this method returns the task details when the task name you are searching is found.
     */
    public Task getTaskByName(String taskName){
        for (int index = 0; index < countTask; index++){
            if (taskName.equalsIgnoreCase(tasks[index].getName()))
                return tasks[index];
        }
        System.out.println("task name not found!!");
        return null;
    }

    /**
     * This method prints all the tasks in the tasks array.
     */
    public void displayTasks(){
        for(int index = 0; index < countTask; index++)
            System.out.println(tasks[index]);
    }

    /**
     * This gets all the OverDue tasks from the array
     * @return this returns a Task class array which consists of all the overdue tasks.
     */
    public Task[] getOverDueTasks(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        Task subtasks[] = new Task[1];
        for (int index = 0; index<countTask; index++){
            if(tasks[index].getDueDate().before(today)){
                subtasks[subtasks.length - 1] = tasks[index];
                subtasks = Arrays.copyOf(subtasks, subtasks.length + 1);
            }
        }
        return subtasks;
    }
}
