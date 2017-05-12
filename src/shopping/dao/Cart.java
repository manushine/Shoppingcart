package shopping.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import shopping.model.CartItem;

public class Cart implements ICart {

	public static Map<Long, List<CartItem>> shoppingCart = new LinkedHashMap<>();

	
	@Override
	public List<CartItem> getItems(Long userid) {
		List<CartItem> items = new ArrayList<>();

		if (shoppingCart.containsKey(userid)) {
			items = shoppingCart.get(userid);
		}
		return items;
	}
	
	
	@Override
	public void addItem(Long userid, CartItem item) {
		boolean newCartItem = true;
		List<CartItem> userItems = getItems(userid);
		String newProductId = item.getProduct().getProductId();
		
		if (!userItems.isEmpty()) {
			for (CartItem citem : userItems) {
				if (citem.getProduct().getProductId() ==  newProductId) {
					newCartItem = false;
					citem.incrementQuantity(item.getQuantity());
					return;
				}
			}
			if (newCartItem)
				userItems.add(item);
		} else {
			userItems.add(item);
			shoppingCart.put(userid, userItems);
		}

	}
	
	public double totalCost(Long userid) {
		double totalAmt = 0.0;
		List<CartItem> userItems = getItems(userid);

		if (!userItems.isEmpty()) {
			for (CartItem c : userItems) {
				totalAmt += c.getTotal();
			}
		}
		return totalAmt;
	}
}
