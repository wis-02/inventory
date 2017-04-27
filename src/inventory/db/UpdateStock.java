package inventory.db;

public class UpdateStock {

	private String title;
	private Integer quantity;

	
	public UpdateStock(String title, Integer quantity) {
		super();
		this.title = title;
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
