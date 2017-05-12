package shopping.model;

public class CartItem {

	private Product product;
	private int quantity;

	public CartItem(Product product, int quantity) {

		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void incrementQuantity(int increment) {
		quantity += increment;
	}

	public double getTotal() {
		double amount = quantity * product.getPrice();
		return amount;
	}
}
