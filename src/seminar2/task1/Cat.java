package seminar2.task1;

public class Cat extends Animal {
    private boolean hasWool;

    public Cat(String name, int age, boolean hasWool) {
        super(name, age);
        this.hasWool = hasWool;
    }

    @Override
    public void makeSound() {
        System.out.println("Кошка мяукает.");
    }

    public String catView() {
        if (hasWool) {
            return "кошка лохматая";
        } else {
            return "кошка лысая";
        }
    }

    @Override
    public String toString() {
        return "Кошка по кличке " + super.getName() + ", возраст " +
                super.getAge() + ", шерсть: " + hasWool + " (" + catView() + ")\n";
    }
}
