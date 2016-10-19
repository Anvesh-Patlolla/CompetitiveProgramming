package designpattern;

public class Person {
	private String name;
	private String address;

	private Person(String name, String address) {
		this.name = name;
		this.address = address;

	}

	public Person() {
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public static class Builder {
		private String name;
		private String address;

		public Builder(String name, String address) {
			this.name = name;
			this.address = address;
		}

		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public void build(Person person) {
			person.address = this.address;
			person.name = this.name;
		}

	}

	public static void main(String[] args) {
		Person person = new Person();
		Builder builder = new Builder();
		builder.address("addr");
		builder.name("testname");
		builder.build(person);
		System.out.println(person.address);
	}
}
