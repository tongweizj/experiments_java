public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testPets();
    }

    static void testPets(){
        Pet pet1 = new Pet("peter","Dog",3);
//        System.out.println(pet1);

        Pet pet2 = new Pet("wang","Dog",13);
//        System.out.println(pet2);

        PetStore branch1 = new PetStore("Jay's Pets");
        PetStore branch2 = new PetStore("Robin's Pets");

        branch1.addPet(new Pet("ali","Dog",12));
        branch1.addPet(pet1);
        branch1.addPet(pet2);

//        branch1.showDetails();
//        branch2.showDetails();
//        branch2.showDetails("cat");

        branch2.buyPet("cat","kitty");
        branch2.buyPet("Dog","Buddy");
    }
}