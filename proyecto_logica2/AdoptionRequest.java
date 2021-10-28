package proyecto_logica2;

public class AdoptionRequest {
    private String code;
    private Adopter client;
    private Animal pet;
    private double donation;

    public AdoptionRequest(String code, Adopter client, Animal pet, double donation) {
        this.code = code;
        this.client = client;
        this.pet = pet;
        this.donation = donation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Adopter getClient() {
        return client;
    }

    public void setClient(Adopter client) {
        this.client = client;
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public double getDonation() {
        return donation;
    }

    public void setDonation(double donation) {
        this.donation = donation;
    }
    
    
}
