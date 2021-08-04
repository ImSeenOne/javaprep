package com.enroutesystems.IOStreamExamples;

import com.enroutesystems.annotationExamples.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class IOStreamExamples {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Cristian", "Ramirez", "24", "Addresssssssss", false);
        person.setActive(true);

        FileOutputStream out = new FileOutputStream("result.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fin = new FileInputStream("result.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            Person pr = (Person) ois.readObject();
            log.info(person.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
