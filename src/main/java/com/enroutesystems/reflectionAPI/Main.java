package com.enroutesystems.reflectionAPI;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.lang.reflect.*;

@Slf4j
public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        log.info("Java Reflection API Example");

        var person = new Person();
        Class<? extends Person> classObj = person.getClass();

        Field[] fields = classObj.getDeclaredFields();

        log.info("Getting field and field metadata from Class...");

        for(Field field : fields) {
            log.info("\tType: " + field.getType() + "\tName: '" + field.getName() + "'");
        }

        Field fieldAge = classObj.getDeclaredField("age");
        Field fieldName = classObj.getDeclaredField("name");

        log.info("Getting modfifiers...");

        log.info("\tName modifier: " + Modifier.toString(fieldName.getModifiers()));
        log.info("\tAge modifier: " + Modifier.toString(fieldAge.getModifiers()));

        fieldAge.set(person, 56);
        fieldName.setAccessible(true); // this allows us to acces to a field with a restrictive access modifier
        fieldName.set(person, "Perengano");


        log.info("\t" + person.toString());

        log.info("Getting methods and method metadata...");

        Method[] methods = classObj.getDeclaredMethods();

        for(Method method : methods) {
            log.info("\tName: '" + method.getName() + "'\tParams count: " + method.getParameterCount() + "\t Return type: " + method.getReturnType());
        }
        
        Method method = classObj.getDeclaredMethod("greet", String.class); // if we want to invoke the retrieved method we have to set the arguments we're going to pass

        log.info("Invoking method 'Person.greet()'");

        log.info("\tResult: " + (String) method.invoke(person, "Cristian"));

        log.info("Invoking method 'Person.sum(int x, int y)'");

        method = classObj.getDeclaredMethod("sum", Integer.TYPE, Integer.TYPE);

        log.info("\tResult: " + method.invoke(person, 5, 5).toString());

        Constructor<? extends Person> constr = classObj.getDeclaredConstructor(String.class, Integer.TYPE);
        Person newInstance = constr.newInstance("Carlos", 26);

        log.info("Invoking constructor with 2 params...");
        log.info("\tResulting object: " + newInstance);

    }
}
