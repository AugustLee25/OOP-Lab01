package DefaultPackage;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;
 //  Create the DigitalVideoDisc class and its attributes
    //9. Create accessors and mutators for the class DigitalVideoDisc
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    // temporarily add a setter for the attribute title of the DigitalVideoDisc class.
    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    //10. Create Constructor method
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        // increase the DVD number and assign it for the id value
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
}
