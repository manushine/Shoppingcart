package shopping.controller;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")

public class Restfulcart extends Application {
	 @Override
	    public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<Class<?>>();
	        set.add(CartController.class);
	        return set;
	    }


}

