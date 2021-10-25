package proyecto_logica2;

public class Cat extends Animal {
    private int maxLifes;

    public Cat(String code, String name, int age, int maxLifes) {
        super(code, name, age);
        this.maxLifes = maxLifes;
    }

    public int getMaxLifes() {
        return maxLifes;
    }

    public void setMaxLifes(int maxLifes) {
        this.maxLifes = maxLifes;
    }
    
}
