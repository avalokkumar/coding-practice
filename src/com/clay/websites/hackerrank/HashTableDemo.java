package websites.hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableDemo {

	private static List<LinkedList<Person>> hashtable = new ArrayList<>();	
	
	
	private static void add(Person p) {
		//TODO: calculate hash from p.id
		//TODO: convert hash to index
		//TODO: store value
		//hashtable.add(index, p);
	}
	
	private static void delete(String id) {
		//TODO: calculate hash from p.id
		//TODO: convert hash to index
		//TODO: iterate through the linked list if more than one value is present
		//TODO: match the id of person in linked list and delete if matches
	}
	
	private static void find(String id) {
		//TODO: get hashcode from id
		//TODO: convert hash to index
		//TODO: iterate through the linked list if more than one value is present
		//TODO: print if id matches
	}
	
}


class Person{
	String id;
	String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}