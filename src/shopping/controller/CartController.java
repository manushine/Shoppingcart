package shopping.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import shopping.model.CartItem;
import shopping.model.Product;
import shopping.dao.Cart;
import shopping.dao.ProductUtil;

@Path("/")

public class CartController {
	Cart usercart = new Cart();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/usercart/{id: \\d+}")
	public Response getUserCart(@PathParam("id") long id) throws Exception {
		List<CartItem> userItems = usercart.getItems(id);
		if (userItems.isEmpty()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(new ObjectMapper().writeValueAsString(userItems), "application/json").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/totalcost/{id: \\d+}")
	public Response getUserCartTotal(@PathParam("id") long id) throws Exception {
		List<CartItem> userItems = usercart.getItems(id);
		if (userItems.isEmpty()){
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
		double amount = usercart.totalCost(id);
		return Response.ok(new ObjectMapper().writeValueAsString(amount), "application/json").build();
		}
		}
		
		

	@POST
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/usercart/{id: \\d+}/{pid}/{qty}")
	public Response addItems(@PathParam("id") long id, @PathParam("pid") String productid,
			@PathParam("qty") int quantity) {
		String msg = null;
		if (quantity <= 0) {
			msg = "Quantity'is missing.\n";
			return Response.status(Response.Status.BAD_REQUEST).entity(msg).type(MediaType.TEXT_PLAIN).build();
		}

		Product product = ProductUtil.findByProductId(productid);
		if (product == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		usercart.addItem(id, new CartItem(product, quantity));
		return Response.ok().build();

	}

}
