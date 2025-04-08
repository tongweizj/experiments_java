public class Hiker {

    // attributes
    int hikerID;
    String name;
    String address;
    int age;
    int participatedNumber;

    // constructors
    // no parameters
    Hiker(){
        this.hikerID = (int) (Math.random()*3000);
        this.name = "N/A";
        this.address = "N/A";
        this.age = 0;
        this.participatedNumber = 0;
    }

    // 5 parameters
    Hiker(int hikerID,
          String name,
          String address,
          int age,
          int participatedNumber){
        this.hikerID = hikerID;
        this.name = name;
        this.address = address;
        this.age = age;
        this.participatedNumber = participatedNumber;
    }

    // 4 parameters
    Hiker(String name,
          String address,
          int age,
          int participatedNumber){
        this.hikerID = (int) (Math.random()*5000);
        this.name = name;
        this.address = address;
        this.age = age;
        this.participatedNumber = participatedNumber;
    }

    // 3 parameters
    Hiker(String name,
          String address,
          int age){
        this.hikerID = (int) (Math.random()*7000);
        this.name = name;
        this.address = address;
        this.age = age;
        this.participatedNumber = 0;
    }

    // 2 parameters
    Hiker(String name,
          int age){
        this.hikerID = (int) (Math.random()*11000);
        this.name = name;
        this.address = "N/A";
        this.age = age;
        this.participatedNumber = 0;
    }

    // 1 parameters
    Hiker(String name){
        this.hikerID = (int) (Math.random()*11000);
        this.name = name;
        this.address = "N/A";
        this.age = 0;
        this.participatedNumber = 0;
    }

    // getter
    public int getHikerID() {
        return hikerID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getParticipatedNumber() {
        return participatedNumber;
    }

    public int getAge() {
        return age;
    }

    // setter
    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHikerID(int hikerID) {
        this.hikerID = hikerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipatedNumber(int participatedNumber) {
        this.participatedNumber = participatedNumber;
    }

    @Override
    public String toString() {
        return "Hiker{" +
                "hikerID=" + hikerID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", participatedNumber=" + participatedNumber +
                '}';
    }
}
