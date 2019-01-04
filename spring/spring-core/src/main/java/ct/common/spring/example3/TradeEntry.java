package ct.common.spring.example3;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;

public class TradeEntry implements TradeEntryMBean
{

	private TradeRepository tradeRepo = null;

	@ManagedOperation(description = "Book New Order in the System")
	@ManagedOperationParameters({
	@ManagedOperationParameter(name = "OrdID", description = "Numeric"),
	@ManagedOperationParameter(name = "InstrumentID", description = "Like a Security or Equity"),
	@ManagedOperationParameter(name = "Side", description = "String Buy or Sell any case"),
	@ManagedOperationParameter(name = "Quantity", description = "Numeric ex 1000000 (a million)"),
	@ManagedOperationParameter(name = "price", description = "Buy or sell Price"), 
	@ManagedOperationParameter(name = "ClientOrdID", description = "ClientsOrderID") 
	})
	@Override
	public void bookOrder(String orderId, String instId, String side, String quantity, String px, String clOrderIdString)
	{

		tradeRepo.createNOS(orderId, instId, side, quantity, px, clOrderIdString);
	}

	@Override
	public void cancelOrder(String ordId)
	{
		tradeRepo.cancelOrder(ordId);

	}

	@Required
	public void setTradeRepo(TradeRepository tradeRepo)
	{
		this.tradeRepo = tradeRepo;
	}

	@Override
	public void deleteOrder(String ordId)
	{
		tradeRepo.deleteOrder(ordId);
	}

}
