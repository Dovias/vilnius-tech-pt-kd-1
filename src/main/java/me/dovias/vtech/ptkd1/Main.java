package me.dovias.vtech.ptkd1;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    // TODO: Move to utilities package:
    public static String getEveryNthCharString(String string, int n) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if (index % n == 0) {
                builder.append(character);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Supplier<List<Animal>> deserializer = new AnimalFileDeserializer(new File("duomenys.txt"));

        List<Animal> animals = deserializer.get();
        for (Animal animal : animals.stream().sorted().toList()) {
            System.out.print(animal.getName().toUpperCase());
            System.out.print(" : ");
            System.out.print(Main.getEveryNthCharString(animal.getBreed(), 2));
            System.out.print(" : ");
            System.out.print(2019 - animal.getBirthYear()));
            System.out.printf(" %.2f", animal.getWeight());
            System.out.println();
        }

        Consumer<List<Animal>> serializer = new AnimalFileSerializer(new File("rezultatai.txt"));
        serializer.accept(animals.stream().filter(animal -> LocalDate.now().getYear() - animal.getBirthYear() < (int)animal.getWeight()).toList());
    }
}
