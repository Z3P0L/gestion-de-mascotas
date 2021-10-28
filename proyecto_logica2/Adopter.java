package proyecto_logica2;

public class Adopter {
    private String id;
    private String name;
    private int telephone;

    public Adopter(String id, String name, int telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
}
