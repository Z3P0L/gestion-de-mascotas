package proyecto_logica2;


public class Dog extends Animal {
    private String breed;
    private double size;

    public Dog(String breed, double size, String code, String name, int age) {
        super(code, name, age);
        this.breed = breed;
        this.size = size;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    
    
}
