class Animal {
    void eat() {
        System.out.println("eats anything");
    }
}

class Deer extends Animal {
    @Override
    void eat() {
        System.out.println("eats only grass");
    }
}

public class method {
    public static void main(String[] args) {
        Animal a = new Animal();  // prints: Animal speaks
        Deer d = new Deer();        // prints: Dog barks

        Animal ref = new Deer();   // prints: Dog barks (runtime polymorphism)
        
        a.eat();
        d.eat();
        ref.eat();  // method overriding
    }
}
