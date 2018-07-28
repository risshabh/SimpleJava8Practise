package collectionPractises;

import java.util.HashMap;

public class HashMapDemo {

	static class Customer{
		private int customerId;
		private String firstName;
		private String lastName;

		public Customer(int custId,String fName,String lName){
			this.customerId=custId;
			this.firstName=fName;
			this.lastName=lName;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + customerId;
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			return result;
		}

		/*
		 * 
		 * (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 * public int hashCode(){
		 * final int const=31;
		 * int result=1;
		 * result=const*result+cusotmerId;
		 * result=const*result+((first==null)?0:first.hashCode());
		 * result=const*result+((last==null)?0:last.hashCode());
		 * return result;
		 */

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Customer other = (Customer) obj;
			if (customerId != other.customerId) {
				return false;
			}
			if (firstName == null) {
				if (other.firstName != null) {
					return false;
				}
			} else if (!firstName.equals(other.firstName)) {
				return false;
			}
			if (lastName == null) {
				if (other.lastName != null) {
					return false;
				}
			} else if (!lastName.equals(other.lastName)) {
				return false;
			}
			return true;
		}


	}

	public static void main(String[] args) {
		HashMapDemo demo=new HashMapDemo();
		Customer cust=new Customer(1, "Rishabh","Agarwal");
		HashMap<Customer,String> map=new HashMap<>();
		map.put(cust, "Rishabh");
		System.out.println(map.get(new Customer(1, "Rishabh","Agarwal")));
		System.out.println(map.get(cust));

	}

}
