package esprit.canditature.dto;

public class Job {
    private int id;

    private String title;

    private String description;

    private boolean available;

    // Default constructor
    public Job() {
    }

    // Constructor with parameters
    public Job(String title, String description, boolean available) {
        this.title = title;
        this.description = description;
        this.available = available;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
