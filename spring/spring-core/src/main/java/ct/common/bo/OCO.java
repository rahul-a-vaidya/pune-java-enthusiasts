package ct.common.bo;

public class OCO extends Order

{
	public final String ORDER_TYPE = "OCO";
	private Order child;

	public OCO(int orderId, int instId, Side side, long quantity, double px, String clOrderId)
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
