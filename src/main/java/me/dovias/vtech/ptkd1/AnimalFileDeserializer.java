package me.dovias.vtech.ptkd1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class AnimalFileDeserializer implements Supplier<List<Animal>> {
    private final File file;

    public AnimalFileDeserializer(File file) {
        this.file = file;
    }

    @Override
    public List<Animal> get() {
        List<Animal> animals = new ArrayList<>();
        try (Scanner scanner = new Scanner(this.file)) {
            String breed = null;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.endsWith(":")) {
                    breed = line.substring(0, line.length() - 1);
                    continue;
                }

                String[] data = line.split(", ");
                animals.add(new Animal(data[0], breed, Float.parseFloat(data[2]), Integer.parseInt(data[1])));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return animals;
    }
}
