package proyecto_logica2;

public class Vector {

    private int size;
    private int count;
    private Object vector[];

    public Vector(int size) {
        this.size = size;
        this.count = 0;
        this.vector = new Object[this.size];
    }

    public boolean Add(Object data) {
        if (count < size) {
            vector[count] = data;
            count++;
            return true;
        }
        return false;
    }

    public Object Search(String code) {
        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof Animal animal) {
                if (animal.getCode().equalsIgnoreCase(code)) {
                    if (animal.getAdopted()) {
                        return SearchAdoptedPet(code);
                    }

                    return vector[i];
                }
            }

            if (vector[i] instanceof Adopter adopter) {
                if (adopter.getId().equalsIgnoreCase(code)) {
                    return vector[i];
                }
            }

            if (vector[i] instanceof AdoptionRequest adoptionRequest) {
                if (adoptionRequest.getCode().equalsIgnoreCase(code)) {
                    return vector[i];
                }
            }
        }

        return null;
    }

    public Object[] SearchAdoptedPet(String code) {
        var adoptedPet = new Object[2];

        for (int j = 0; j < count; j++) {
            if (((AdoptionRequest) vector[j]).getPet().getCode().equalsIgnoreCase(code)) {
                adoptedPet[0] = ((AdoptionRequest) vector[j]).getPet();
                adoptedPet[1] = ((AdoptionRequest) vector[j]).getClient();
            }
        }

        return adoptedPet;
    }

    public boolean Remove(String code) {
        int pos = -1;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof Animal animal) {
                if (animal.getCode().equalsIgnoreCase(code)) {
                    pos = i;
                }
            }
            if (vector[i] instanceof Adopter adopter) {
                if (adopter.getId().equalsIgnoreCase(code)) {
                    pos = i;
                }
            }
            if (vector[i] instanceof AdoptionRequest adoptionRequest) {
                if (adoptionRequest.getCode().equalsIgnoreCase(code)) {
                    pos = i;
                }
            }
        }

        if (pos != -1) {
            for (int j = pos; j < count - 1; j++) {
                vector[j] = vector[j + 1];
            }
            vector[count - 1] = null;
            count--;
            return true;
        }
        return false;
    }
    
    public boolean Adopt(String code) {
        double greater = -1;
        int index = -1;
        
        for (int i = 0; i < count; i++) {
            if (((AdoptionRequest) vector[i]).getPet().getCode().equalsIgnoreCase(code)) {
                if (((AdoptionRequest) vector[i]).getVoluntaryDonation() > greater) {
                    greater = ((AdoptionRequest) vector[i]).getVoluntaryDonation();
                    index = i;
                }
            }
        }
        
        if (index != -1) {
            ((Animal) vector[index]).setAdopted(true);
            return true;
        }
        
        return false;
    }

    public Animal[] AvailablePets(String petType) {
        int amount = 0, i = 0;

        while (i < amount) {
            if (String.valueOf(vector[i].getClass()).equals("class proyecto_logica2." + petType) && !((Animal) vector[i]).getAdopted()) {
                amount++;
            }

            i++;
        }

        Animal[] pets = new Animal[amount];
        int index = 0;

        for (int j = 0; j < amount; j++) {
            if (String.valueOf(vector[i].getClass()).equalsIgnoreCase("class proyecto_logica2." + petType) && !((Animal) vector[i]).getAdopted()) {
                pets[index] = ((Animal) vector[i]);
            }
        }

        return pets;
    }

    public Animal[] PetsOfPerson(String code) {
        int amount = 0, i = 0;

        while (i < count) {
            boolean isAdopted = ((AdoptionRequest) vector[i]).getPet().getAdopted();

            if (isAdopted && ((AdoptionRequest) vector[i]).getClient().getId().equalsIgnoreCase(code)) {
                amount++;
            }

            i++;
        }

        Animal[] pets = new Animal[amount];
        int index = 0;

        for (int j = 0; j < count; j++) {
            boolean isAdopted = ((AdoptionRequest) vector[j]).getPet().getAdopted();

            if (isAdopted && ((AdoptionRequest) vector[j]).getClient().getId().equalsIgnoreCase(code)) {
                pets[index] = ((AdoptionRequest) vector[j]).getPet();
                index++;
            }
        }

        return pets;
    }

    public Animal MostDemandedPet() {
        int greater = 0;
        Animal pet = null;

        for (int i = 0; i < count; i++) {
            String code = ((AdoptionRequest) vector[i]).getPet().getCode();
            int requests = CountRequests(code);

            if (requests > greater) {
                greater = CountRequests(code);
                pet = ((Animal) vector[i]);
            }
        }

        return pet;
    }

    public Animal LeastDemandedPet() {
        int least = 1000;
        Animal pet = null;

        for (int i = 0; i < count; i++) {
            String code = ((AdoptionRequest) vector[i]).getPet().getCode();
            int requests = CountRequests(code);

            if (requests < least) {
                least = CountRequests(code);
                pet = ((Animal) vector[i]);
            }
        }

        return pet;
    }

    public int CountRequests(String code) {
        int counter = 0;

        for (int i = 0; i < count; i++) {
            if (((AdoptionRequest) vector[i]).getPet().getCode().equalsIgnoreCase(code)) {
                counter++;
            }
        }

        return counter;
    }

    public double TotalCollected() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            if (((AdoptionRequest) vector[i]).getPet().getAdopted()) {
                total += ((AdoptionRequest) vector[i]).getVoluntaryDonation();
            }
        }

        return total;
    }

    public double AdoptedPetsPercent(String petType) {
        int adopted = 0, pets = 0;
        double percentage;

        for (int i = 0; i < count; i++) {
            if (String.valueOf(((Animal) vector[i]).getClass()).equals("class proyecto_logica2." + petType)) {
                if (((Animal) vector[i]).getAdopted()) {
                    adopted++;
                }
                pets++;
            }
        }

        percentage = ((double) (adopted / pets)) * 100;

        return percentage;
    }

    public double RescuedPetsPercent(String petType) {
        double percentage = 100 - AdoptedPetsPercent(petType);

        return percentage;
    }
}
