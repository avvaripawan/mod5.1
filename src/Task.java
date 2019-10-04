import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    //Fields
    private String name, description, status;
    private Date dueDate;

    //Constructor

    public Task(String name, String description, String status, Date dueDate) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }


    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String toString(){
        return (" Task Name: "+name+" Description: "+description+" Status: "+status+" Due Date: "+new SimpleDateFormat("dd/MM/yyyy").format(dueDate));
    }

}
