package shopping.dao;

import java.util.List;
import shopping.model.CartItem;

public interface ICart {

	public void addItem(Long userId, CartItem item);
    public List<CartItem> getItems(Long userid);

}
