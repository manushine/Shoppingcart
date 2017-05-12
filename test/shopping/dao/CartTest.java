package shopping.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import shopping.model.CartItem;
import shopping.model.Product;

public class CartTest {

	
	@Test
	public void getitems_invalid_userid_returns_empty_list() {
		Cart c = new Cart();
		assertEquals(Collections.emptyList(),c.getItems(1234L));	
	}
	
	
	@Test
	public void getitems_valid_userid_returs_cartitem_list() {
		Cart c = new Cart();
		List<CartItem> list = new ArrayList<>();
 		CartItem citem = new CartItem(new Product("milk","Milk desc",2.0), 2);
 		c.addItem(1L,citem );
		list =c.getItems(1L);
		String s = list.get(0).getProduct().getName();
		
		assertEquals("Milk desc", s);
		
	}
	

	
}
