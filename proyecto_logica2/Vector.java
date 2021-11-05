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
            if (vector[i] instanceof Animal) {
                if (((Animal) vector[i]).getCode().equalsIgnoreCase(code)) {
                    if (((Animal) vector[i]).getAdopted()) {
                        return SearchAdoptedPet(code);
                    }

                    return vector[i];
                }
            }

            if (vector[i] instanceof Adopter) {
                if (((Adopter) vector[i]).getId().equalsIgnoreCase(code)) {
                    return vector[i];
                }
            }

            if (vector[i] instanceof AdoptionRequest) {
                if (((AdoptionRequest) vector[i]).getCode().equalsIgnoreCase(code)) {
                    return vector[i];
                }
            }
        }

        return null;
    }

    public Object SearchAdoptedPet(String code) {
        Object adoption = null;

        for (int j = 0; j < count; j++) {
            if (vector[j] instanceof AdoptionRequest) {
                if (((AdoptionRequest) vector[j]).getPet().getCode().equalsIgnoreCase(code)) {
                    if (((AdoptionRequest) vector[j]).getDonation() == FindGreaterDonation(code).getDonation()) {
                        adoption = vector[j];
                    }
                }
            }
        }

        return adoption;
    }

    public boolean Remove(String code) {
        int pos = -1;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof Animal) {
                if (((Animal) vector[i]).getCode().equalsIgnoreCase(code)) {
                    pos = i;
                }
            }
            if (vector[i] instanceof Adopter) {
                if (((Adopter) vector[i]).getId().equalsIgnoreCase(code)) {
                    pos = i;
                }
            }
            if (vector[i] instanceof AdoptionRequest) {
                if (((AdoptionRequest) vector[i]).getCode().equalsIgnoreCase(code)) {
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
        AdoptionRequest greaterAdoption = FindGreaterDonation(code);

        if (greaterAdoption != null) {
            greaterAdoption.getPet().setAdopted(true);
            return true;
        }

        return false;
    }

    public AdoptionRequest FindGreaterDonation(String code) {
        double greater = -1;
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof AdoptionRequest && ((AdoptionRequest) vector[i]).getPet().getCode().equalsIgnoreCase(code)) {
                if (((AdoptionRequest) vector[i]).getDonation() > greater) {
                    greater = ((AdoptionRequest) vector[i]).getDonation();
                    index = i;
                }
            }
        }

        if (index != -1) {
            return ((AdoptionRequest) vector[index]);
        }

        return null;
    }

    public Animal[] AvailablePets(String petType) {
        int amount = 0;

        for (int i = 0; i < count; i++) {
            if (vector[i].getClass().getName().endsWith(petType) && !((Animal) vector[i]).getAdopted()) {
                amount++;
            }
        }

        if (amount == 0) {
            return null;
        }

        Animal[] pets = null;
        int index = 0;

        if (petType.equalsIgnoreCase("Dog")) {
            pets = new Dog[amount];
        }
        if (petType.equalsIgnoreCase("Cat")) {
            pets = new Cat[amount];
        }
        if (petType.equalsIgnoreCase("Fish")) {
            pets = new Fish[amount];
        }

        for (int j = 0; j < count; j++) {
            if (vector[j].getClass().getName().endsWith(petType) && !((Animal) vector[j]).getAdopted()) {
                pets[index] = ((Animal) vector[j]);
                index++;
            }
        }

        return pets;
    }

    public Animal[] PetsOfPerson(String clientCode) {
        int amount = 0;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof AdoptionRequest) {
                boolean isAdopted = ((AdoptionRequest) vector[i]).getPet().getAdopted();

                if (isAdopted && ((AdoptionRequest) vector[i]).getClient().getId().equalsIgnoreCase(clientCode)) {
                    String petCode = ((AdoptionRequest) vector[i]).getPet().getCode();

                    if (((AdoptionRequest) vector[i]).getDonation() == FindGreaterDonation(petCode).getDonation()) {
                        amount++;
                    }
                }
            }
        }

        if (amount == 0) {
            return null;
        }

        Animal[] pets = new Animal[amount];
        int index = 0;

        for (int j = 0; j < count; j++) {
            if (vector[j] instanceof AdoptionRequest) {
                boolean isAdopted = ((AdoptionRequest) vector[j]).getPet().getAdopted();

                if (isAdopted && ((AdoptionRequest) vector[j]).getClient().getId().equalsIgnoreCase(clientCode)) {
                    String petCode = ((AdoptionRequest) vector[j]).getPet().getCode();

                    if (((AdoptionRequest) vector[j]).getDonation() == FindGreaterDonation(petCode).getDonation()) {
                        pets[index] = ((AdoptionRequest) vector[j]).getPet();
                        index++;
                    }
                }
            }
        }

        return pets;
    }

    public Animal MostDemandedPet() {
        int greater = 0;
        Animal pet = null;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof AdoptionRequest) {
                String code = ((AdoptionRequest) vector[i]).getPet().getCode();
                int requests = CountRequests(code);

                if (requests > greater) {
                    greater = requests;
                    pet = ((AdoptionRequest) vector[i]).getPet();
                }
            }
        }
        
        return pet;
    }

    public Animal LeastDemandedPet() {
        int least = 1000;
        Animal pet = null;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof AdoptionRequest) {
                String code = ((AdoptionRequest) vector[i]).getPet().getCode();
                int requests = CountRequests(code);

                if (requests < least) {
                    least = requests;
                    pet = ((AdoptionRequest) vector[i]).getPet();
                }
            }
        }

        return pet;
    }

    public int CountRequests(String code) {
        int counter = 0;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof AdoptionRequest) {
                if (((AdoptionRequest) vector[i]).getPet().getCode().equalsIgnoreCase(code)) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public double TotalCollected() {
        double donations = 0;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof AdoptionRequest) {
                String code = ((AdoptionRequest) vector[i]).getPet().getCode();
                AdoptionRequest greaterAdoption = FindGreaterDonation(code);

                if (((AdoptionRequest) vector[i]).getDonation() == greaterAdoption.getDonation()) {
                    donations += ((AdoptionRequest) vector[i]).getDonation();
                }
            }
        }

        return donations;
    }

    public double AdoptedPetsPercent(String petType) {
        int adopted = 0, pets = 0;
        double percentage;

        for (int i = 0; i < count; i++) {
            if (vector[i] instanceof Animal) {
                if (((Animal) vector[i]).getClass().getName().endsWith(petType)) {
                    if (((Animal) vector[i]).getAdopted()) {
                        adopted++;
                    }
                    pets++;
                }
            }
        }

        percentage = ((double) adopted / pets) * 100;

        return percentage;
    }

    public double RescuedPetsPercent(String petType) {
        double percentage = 100 - AdoptedPetsPercent(petType);

        return percentage;
    }

}
