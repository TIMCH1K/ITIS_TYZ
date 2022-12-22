public class Fox extends Animal {
    @Override
    public void makeSound() {
        System.out.println("What does the Fox say?");
    }

    @Override
    public Animal makeChild() {
        System.out.println("Ваше животное создало потомство.");
        return new Fox();
    }
}