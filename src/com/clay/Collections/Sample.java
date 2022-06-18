package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {

	private static final Comparator<Demo> nameSort = Comparator.comparing(Demo::getName);
	private static final Comparator<Demo> addressSort = Comparator.comparing(Demo::getAddress);
	private static final Comparator<Demo> ageSort = Comparator.comparingInt(Demo::getAge);

	public static void main(String[] args) {

		List<Demo> myList = new ArrayList<>();
		myList.add(new Demo("Ron", "Street1", 21));
		myList.add(new Demo("Harry", "Church Street4", 23));
		myList.add(new Demo("Jon", "Park Street", 18));
		myList.add(new Demo("Ana", "Monaco str.", 22));

		myList.stream().forEach(System.out::println);
		System.out.println();
		Collections.sort(myList, nameSort);
		myList.stream().forEach(System.out::println);
		System.out.println();
		Collections.sort(myList, addressSort);
		myList.stream().forEach(System.out::println);
		System.out.println();
		Collections.sort(myList, ageSort);
		myList.stream().forEach(System.out::println);

	}

}

class Demo {
	private String name;
	private String address;
	private int age;

	public Demo(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Demo [name=" + name + ", address=" + address + ", age=" + age + "]";
	}

	
}