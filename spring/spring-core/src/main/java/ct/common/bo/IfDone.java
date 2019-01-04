package ct.common.bo;

/**
 * Complex Orders which extend Order to provide parent Child Order concept.
 * @author nikhil
 *
 */
public class IfDone extends Order
{	
	
	private Order child;
	
	public final String ORDER_TYPE = "IFDONE";

	public IfDone(int orderId, int instId, Side side, long quantity, double px, String clOrderId)
	{
		super(orderId, instId, side, quantity, px, clOrderId);
		
	}

	
	public void addChildOrder(int orderId, int instId, Side side, long quantity, double px, String clOrderId)
	{
		this.child = new Order (orderId, instId, side, quantity, px, clOrderId);
	}
	
	public Order getChild() 
	{
		return child;
	}
	
	public String getOrderType()
	{
			return ORDER_TYPE;
	}
}
