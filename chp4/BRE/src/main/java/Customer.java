public class Customer {
    private final String jobTitle;
    private final String name;

    Customer(final String jobTitle, final String name){
        this.jobTitle = jobTitle;
        this.name = name;
    }

    public String getJobTitle(){
        return this.jobTitle;
    }

    public String getName() {
        return this.name;
    }
}
