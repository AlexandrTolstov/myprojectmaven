package ru.geekbrain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.geekbrain.domain.Address;
import ru.geekbrain.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person1 = new Person("Alexandr", "Snegerev",
                new Address("Almaty", "Abay", 10), 25,
                new ArrayList<>(Arrays.asList("25146-22156", "1553664-541", "552655144")));
        Person person2 = new Person("Valeriy", "Arapov",
                new Address("Volgograd", "Pushkina", 21), 32,
                new ArrayList<>(Arrays.asList("165461-54651", "5457-54548", "36247-36254")));
        Person person3 = new Person("Vova", "Lavrov",
                new Address("Volgograd", "Pushkina", 21), 32,
                new ArrayList<>(Arrays.asList("165461-54651", "5457-54548", "36247-36254")));

        Gson gson1 = new Gson();
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting();
        Gson gson3 = gsonBuilder.create();

        String personToJson1 = gson1.toJson(person1);
        String personToJson2 = gson2.toJson(person2);
        String personToJson3 = gson3.toJson(person3);

        Person JsonToPerson1 = gson1.fromJson(personToJson1, Person.class);

        System.out.printf("Simple JSON: %s\n", personToJson1);
        System.out.printf("\nPretty JSON: %s\n", personToJson2);
        System.out.printf("\nJSON without expose field: %s\n", personToJson3);

        System.out.printf("\nperson1 equals JsonToPerson1: %s\n", person1.equals(JsonToPerson1));

        System.out.println(person1);
    }
}
