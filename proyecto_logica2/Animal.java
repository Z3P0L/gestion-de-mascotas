package proyecto_logica2;

public abstract class Animal {
    private String code;
    private String name;
    private int age;
    private boolean adopted;

    public Animal(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.adopted = false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean getAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
    
}
