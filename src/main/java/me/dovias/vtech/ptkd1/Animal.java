package me.dovias.vtech.ptkd1;

public class Animal implements Comparable<Animal> {
    private final String name;
    private final String breed;
    private final float weight;
    private final int birthYear;

    public Animal(String name, String breed, float weight, int birthYear) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.birthYear = birthYear;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public float getWeight() {
        return this.weight;
    }

    public int getBirthYear() {
        return this.birthYear;
    }



    @Override
    public String toString() {
        return "Animal{" +
                "name='" + this.name + '\'' +
                ", breed='" + this.breed + '\'' +
                ", weight=" + this.weight +
                ", birthYear=" + this.birthYear +
                '}';
    }

    @Override
    public int compareTo(Animal animal) {
        if (this.getWeight() < animal.getWeight()) {
            return 1;
        } else if (this.getWeight() > animal.getWeight()) {
            return -1;
        } else if (this.getBirthYear() > animal.getBirthYear()) {
            return -1;
        } else if (this.getBirthYear() < animal.getBirthYear()) {
            return 1;
        }
        return this.getName().compareTo(animal.getName());
    }
}
