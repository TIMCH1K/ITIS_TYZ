public class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("МУУУУУУ");
    }

    @Override
    public Animal makeChild() {
        System.out.println("Ваше животное создало потомство.");
        return new Cow();
    }
}