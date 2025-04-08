public class Pet {
    private static int petIdCounter = 50;
    private int petId;
    /*
    instance variables
    - associated with instance/object of the class
    - all the objects of the class can have different values
    * */
    private String name;
    private String type;
    private int age;

    public Pet() {
        this.petId = petIdCounter + 1;
        this.name = "NA";
        this.type = "NA";
        this.age = 0;
        petIdCounter ++ ;
    }

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.petId = petIdCounter + 1;
        this.age = age;

        petIdCounter ++ ;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }


}
