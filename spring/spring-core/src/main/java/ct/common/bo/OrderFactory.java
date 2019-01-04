package ct.common.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import ct.common.bo.Order.Side;

/**
 * This class gives random orders that can be used with various examples
 * @author nikhil
 */
public class OrderFactory
{
	private OrderFactory() 
	{
		
	}
	/**
	 * 
	 * @param howMany : number of Orders to be created and returned
	 * @return : a List of Orders randomly generated with Side and price
	 */
	public static List<Order> getRandomOrders(int howMany)
	{	
		final int securityID= 1000898;
		Random rand = new Random();
		List<Order> list = new ArrayList<>(); 
		for(int i=0; i< howMany; i++) 
		{
			
			Side side = rand.nextBoolean() == true? Side.BUY : Side.SELL;
			double px =  rand.nextDouble();
			double roundPx = Math.round(px *10000) /100;
			int ordId = i+ 1; 
			Order ord = new Order( ordId,securityID, side, 1000000,roundPx, UUID.randomUUID().toString());
			list.add(ord);
		}
		
		return list;
	}
}
