package inventory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface InventoryTitle {

	@WebMethod
	String sayHelloWorld(String name);

	@WebMethod
	int add(int x, int y);

	@WebMethod
	int subract(int x, int y);

	@WebMethod
	User getUser();

	@WebMethod
	String setReservation(String title, Integer quantity);

	@WebMethod
	String releaseReservation(String title, Integer quantity);

	@WebMethod

	int getAvailiability(String title);
}
