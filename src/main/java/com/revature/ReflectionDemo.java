package com.revature;

import java.lang.reflect.Field;

/**
 * Reflection is Java's API for code introspection (or meta-programming)
 * 
 * Reflection allows us to interact with Java objects in a meta-form.
 * 
 * The primary use case for Reflection is when you're writing code that
 * needs to interact with code that will be developed by people using
 * your code as a dependency.
 *
 *
 *
 */
public class ReflectionDemo {
	public static void reflector(Class c) {
		String name = c.getName();
		System.out.println(name);
		
		Field[] fields = c.getDeclaredFields();
		
		System.out.println(name + " has " + fields.length + " fields: ");
		String hello = "Hello";
		System.out.println(hello);
		for(Field field : fields) {

			System.out.printf("%10s - %-10s%n", field.getName(), field.getType().getName());
			if (field.getName() == "value") {
				try {
					field.setAccessible(true);
					field.set(hello, "Goodbye");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		System.out.println(hello);
	}
	
	public static void main(String[] args) {
		reflector(Clock.class);
	}
}

class Clock {
	byte secondHand;
	byte minuteHand;
	byte hourHand;
}
