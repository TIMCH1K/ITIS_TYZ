public class Main {
    public static void main(String[] args) {
        Animal foxxie = new Fox();
        Animal ottis = new Cow();
        foxxie.makeChild();
        foxxie.makeSound();
        ottis.makeChild();
        ottis.makeSound();

    }
}