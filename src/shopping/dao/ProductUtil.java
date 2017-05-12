package shopping.dao;

import java.util.ArrayList;
import java.util.List;

import shopping.model.Product;

public class ProductUtil {

	private static List<Product> products;

	static {

		products = populateDummyProducts(); // Populate with in-memory data
	}

	public static Product findByProductId(String id) {

		for (Product product : products) {
			if (product.getProductId().equals(id)) {
				return product;
			}
		}

		return null;
	}

	private static List<Product> populateDummyProducts() {
		products = new ArrayList<Product>();
		products.add(new Product("milk", "Milk 1 Pint", 1.0));
		products.add(new Product("bread", "Sliced Bread", 2.0));
		return products;
	}

}
