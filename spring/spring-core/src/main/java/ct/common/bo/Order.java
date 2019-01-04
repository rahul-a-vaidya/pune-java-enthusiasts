package ct.common.bo;

import java.util.Objects;

/**
 * This class represents a simple order message business Object
 * 
 * @author nikhil
 *
 */
public class Order implements Ord
{
	/**
	 * Buy Or Sell
	 */
	private Side side;

	/**
	 * The Amount that will be traded
	 */
	private long quantity;

	/**
	 * Price for the Order
	 */
	private double price;
	/**
	 * The Security ID or the Equity ID we want to Place the Order on
	 */
	private int instrumentId;

	/**
	 * Once the Order is Persisted it will have a Order ID
	 */
	private int orderId;

	/**
	 * for Each new , Modify or Cancel the Order will have a Unique TransactionID
	 */
	private int tranId;
	/**
	 * The client Order ID
	 */
	private String clOrdId;
	/**
	 * 'N' --> new
	 * 'M' --> modify
	 * 'X' --> Cancel
	 */
	private String orderState;
	
	public final String ORDER_TYPE = "SPOT";
	
	public Order(int orderId, int instId, Side side, long quantity, double px, String clOrderId)
	{
		Objects.requireNonNull(side);
		this.orderId = orderId;
		this.instrumentId = instId;
		this.side = side;
		this.quantity = quantity;
		this.price = px;
		this.clOrdId = clOrderId;
		this.orderState = "N";

	}

	
	public Order(int orderId, int instId, Side side, long quantity, double px, String clOrderId, String orderState)
	{
		Objects.requireNonNull(side);
		this.orderId = orderId;
		this.instrumentId = instId;
		this.side = side;
		this.quantity = quantity;
		this.price = px;
		this.clOrdId = clOrderId;
		this.orderState = orderState;

	}

	public enum Side
	{

		/**
		 * Buy form Client Perspective
		 */
		BUY,
		/**
		 * Sell Side from Client Perspective
		 */
		SELL;
		
		public static Side identifySide(String side)
		{
			return ("BUY".equalsIgnoreCase(side)? Side.BUY : Side.SELL);
		}

	}

	public long getQuantity()
	{
		return quantity;
	}

	public double getPrice()
	{
		return price;
	}

	public int getInstrumentId()
	{
		return instrumentId;
	}

	public Side getSide()
	{
		return side;
	}

	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

	public int getTranId()
	{
		return tranId;
	}

	public void setTranId(int tranId)
	{
		this.tranId = tranId;
	}

	public String getClOrdId()
	{
		return clOrdId;
	}

	public void setClOrdId(String clOrdId)
	{
		this.clOrdId = clOrdId;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + instrumentId;
		result = prime * result + orderId;
		result = prime * result + tranId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (quantity ^ (quantity >>> 32));
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (instrumentId != other.instrumentId)
			return false;
		if (orderId != other.orderId)
			return false;
		if (tranId != other.tranId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (side != other.side)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		return builder.append(" OrdId=").append(getOrderId()).append(" InstrumentId=").append(getInstrumentId()).append(" Side=").append(getSide())
				.append(" Price=").append(getPrice()).toString();
	}

	public String getOrderState()
	{
		return orderState;
	}

	public void setOrderState(String orderState)
	{
		this.orderState = orderState;
	}
	
	public String getOrderType()
	{
			return ORDER_TYPE;
	}
}
