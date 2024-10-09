package me.dovias.vtech.ptkd1;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.function.Consumer;

public class AnimalFileSerializer implements Consumer<List<Animal>> {
    private final File file;

    public AnimalFileSerializer(File file) {
        this.file = file;
    }

    @Override
    public void accept(List<Animal> animals) {
        final Map<String, List<Animal>> serializedAnimals = new HashMap<>();
        for (Animal animal : animals) {
            String breed = animal.getBreed();
            serializedAnimals.putIfAbsent(breed, new ArrayList<>());
            serializedAnimals.get(breed).add(animal);
        }

        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, List<Animal>> entry : serializedAnimals.entrySet()) {
                writer.append(entry.getKey()).append(":").append("\n");
                for (Animal animal : entry.getValue()) {
                    writer.append(animal.getName()).append(", ")
                        .append(Integer.toString(animal.getBirthYear())).append(", ")
                        .append(Float.toString(animal.getWeight())).append("\n");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
