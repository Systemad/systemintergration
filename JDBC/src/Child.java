public class Child {

    private int id;
    private String name;
    private boolean nice;
    private String address;

    public Child(int id, String name, boolean nice, String address){
        this.id = id;
        this.name = name;
        this.nice = nice;
        this.address = address;
    }

    public Child(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNice() {
        return nice;
    }

    public void setNice(boolean nice) {
        this.nice = nice;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getNice(){
        return nice;
    }

    public void printOut(){
        if (name != null){
            System.out.println(this.name + " is " + (nice ? "Nice" : "Naughty"));
        }
        else{
            System.out.println("Not a valid name");
        }
    }
}