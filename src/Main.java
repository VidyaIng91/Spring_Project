import com.jdbc.dao.JdbcDaoImpl;
import com.jdbc.model.Circle;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = null;
		JdbcDaoImpl jdbc = new JdbcDaoImpl();
		circle = jdbc.getCircle(1);
		
		System.out.println("id :" +circle.getId());
		System.out.println("Name :"+circle.getName());
		
	}

}
