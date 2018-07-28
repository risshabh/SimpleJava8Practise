package collectionPractises;

public interface PersonFactory<P extends PersonBean> {
	P create(String fName,String lName);
}
