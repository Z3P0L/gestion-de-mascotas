package proyecto_logica2;

public class Fish extends Animal {
    private String water;

    public Fish(String code, String name, int age, String water) {
        super(code, name, age);
        this.water = water;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }
    
}
