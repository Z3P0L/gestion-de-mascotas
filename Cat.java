package proyecto_logica2;


public class Cat extends Animal {
    private int maxlifes;

    public Cat(int maxlifes, String code, String name, int age) {
        super(code, name, age);
        this.maxlifes = maxlifes;
    }

    public int getMaxlifes() {
        return maxlifes;
    }

    public void setMaxlifes(int maxlifes) {
        this.maxlifes = maxlifes;
    }
    
}
