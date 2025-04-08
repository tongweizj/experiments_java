import java.util.ArrayList;
import java.util.List;


// petStore, pet 是两个object，如果合在一起，会给将来带来很多麻烦。
// 比如 petID 这个参数，如果在pet里面生成，处理自动累加到id 就会变成麻烦。
public class PetStore {

    private String StoreName;
    private  static List<Pet> petList = new ArrayList<Pet>(){{
                add(new Pet("Buddy", "Dog", 1));
                add(new Pet("name","dog",11));
    }};

    public PetStore(String storeName) {
        StoreName = storeName;
    }
    public void addPet(Pet pet){
        petList.add(pet);
    }
/*
* method overloading
* one class having multiple methods with same name
* but different signature
*
* */
    public void showDetails(){
        System.out.println("\nList of pets at " + StoreName);
        for(Pet pet : petList){
            System.out.println(pet);
        }
    }

    public void showDetails(String type){
        boolean isHave = false;
        System.out.println("\nList of " + type + "at"  + StoreName );
        for(Pet pet : petList){
//            if(pet.getType().equals(type)) {
//                System.out.println(pet);
//            }
            if(pet.getType().equalsIgnoreCase(type)) { //可以或略输入时的大小写差异
                System.out.println(pet);
                isHave = true;
            }
        }
        if(!isHave){
            System.out.println("Sorry, our store don't have " + type);
        }
    }

    /*
     static method
     - associated with class instead of object
     - can be called
    * */
    public static void findPet(String name){
        /*
        local variable
        - associated with function
        - created when function is running
        - destroyed when function execution is complete
         */
        boolean isHave = false;
        System.out.println("\nList of " + name  );
        for(Pet pet : petList){
            if(pet.getName().equalsIgnoreCase(name)) { //可以或略输入时的大小写差异
                System.out.println(pet);
                isHave = true;
            }
        }
        if(!isHave){
            System.out.println("Sorry, our store don't have " + name);
        }
    }

    /*
    a function buyPet() to allow user to send pet name and type as parameter
    check if the petList has such a pet,
    if yes, show a message to the user and remove the pet from list
    if no, show a message to the use
     */

    public void buyPet(String type, String name){
        boolean isHave = false;
        System.out.println("\nBuy Pet of " +"name "+ name + "type " + type  );
//        Pet temp= null;
        for(Pet pet : petList){
            if(pet.getName().equalsIgnoreCase(name)
                    && pet.getType().equalsIgnoreCase(type)) { //可以或略输入时的大小写差异
                System.out.println(pet);
                isHave = true;
//                temp = pet;
                petList.remove(pet);
                break; // java 不能在loop时，修改变量。所以，remove 完就跳出loop
            }
        }

        if(!isHave){
            System.out.println("Sorry, our store don't have " + name);
        }
//        else{
//            petList.remove(temp);
//        }

    }
}
