package inventory;

import javax.jws.WebService;

import java.sql.Connection;
import java.sql.DriverManager;
import inventory.db.UpdateStock;
import inventory.db.TitleManager;

public class InventoryTitleImpl implements InventoryTitle {

	TitleManager cm = new TitleManager();

	@Override
	public String sayHelloWorld(String name) {
		// TODO Auto-generated method stub
		return "Hello " + name;
	}

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public int subract(int x, int y) {
		// TODO Auto-generated method stub
		return x - y;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		User u = new User();
		u.setId(1);
		u.setName("Kostas");
		return u;
	}

	@Override
	public String setReservation(String title, Integer quantity) {
		int stockControl = 0;
		int  newStock= 0;
		stockControl = cm.getOccurencesforTitle(title);
		System.out.println("availible stock to db is : " + stockControl);
		if ((stockControl > 0) && ((stockControl - quantity) >= 0)) {
			if (stockControl==1)
				newStock = 0;
			else if (stockControl>quantity)
				newStock = stockControl - quantity;
			UpdateStock c = new UpdateStock(title,newStock );

			Boolean res = cm.reserveFromStock(c);
			System.out.println("reserved from " + res);

			System.out.println("Result " + title);
		}
		else{
			String warning="Only "+stockControl+" Items Availiable";
			return warning;
		}
		return title+ "Availiable";
	}

	@Override
	public String releaseReservation(String title, Integer quantity) {
		int stockControl = 0;

		System.out.println("availible stock to db is : " + stockControl);
		stockControl = cm.getOccurencesforTitle(title);
		UpdateStock c = new UpdateStock(title, (stockControl + quantity));

		Boolean res = cm.reserveFromStock(c);
		System.out.println("released " + res + "for " + title);

		return title;
	}

	@Override
	public int getAvailiability(String title) {
		return cm.getOccurencesforTitle(title);
	}
	//

}
