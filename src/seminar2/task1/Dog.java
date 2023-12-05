package seminar2.task1;

public class Dog extends Animal {
    private final boolean isDressed;

    public Dog(String name, int age, boolean isDressed) {
        super(name, age);
        this.isDressed = isDressed;
    }

    @Override
    public void makeSound() {
        System.out.println("Собака лает.");
    }

    public String dogStatus() {
        if (isDressed) {
            return "cобака дрессирована";
        } else {
            return "cобака не дрессирована";
        }
    }

    @Override
    public String toString() {
        return "Собака по кличке " + super.getName() + ", возраст " +
                super.getAge() + ", дрессировка: " + isDressed + " (" + dogStatus() + ")\n";
    }
}
