package ct.common.spring.example3;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ct.common.bo.Order;
import ct.common.bo.Order.Side;

public class TradeRepository implements RowMapper<Order>
{

	private static final Logger log = Logger.getLogger(TradeRepository.class);
	
	private static final String BUY = "buy";

	private JdbcTemplate jdbcTemplate = null;

	private static final String INSERT_QUERY = "INSERT INTO \"PUBLIC\".ORDERS (ORDERID, INSTRUMENTID,CLORDID,PRICE,QUANTITY,SIDE,ORDERSTATE) VALUES (?,?,?,?,?,?,?)";
	private static final String DELETE_QUERY = "DELETE FROM \"PUBLIC\".ORDERS WHERE ORDERID= ?";
	private static final String UPDATE_QUERY = "UPDATE \"PUBLIC\".ORDERS SET ORDERSTATE= ? WHERE ORDERID= ?";

	/**
	 * Create a new Order Single
	 * 
	 * @return
	 */
	public boolean createNOS(String ordId, String instId, String side, String quantity, String px, String clOrderId)
	{
		boolean inserted = false;
		try {

			Integer orderId = Integer.valueOf(ordId);
			Integer instrumentId = Integer.valueOf(instId);
			Long amt = Long.valueOf(quantity);
			Double price = Double.valueOf(px);

			Side s = (BUY.equalsIgnoreCase(side) ? Side.BUY : Side.SELL);

			Object[] inputs = new Object[] { orderId.intValue(), instrumentId, clOrderId, price, amt, s.toString(), "N" };
			int update = jdbcTemplate.update(INSERT_QUERY, inputs);

			inserted = (update > 0 ? true : false);
		} catch (Exception e) {
			log.info("[ Exception creating the order ]", e);

		}
		return inserted;
	}

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException
	{

		int ordId = rs.getInt("ORDERID");
		int instrumentId = rs.getInt("INSTRUMENTID");
		String clordId = rs.getString("CLORDID");
		Double price = rs.getDouble("PRICE");
		Long quantity = rs.getLong("QUANTITY");
		String sideAsString = rs.getString("SIDE");
		Order order = new Order(ordId, instrumentId, Side.identifySide(sideAsString), quantity, price.doubleValue(), clordId);
		return order;
	}

	public void deleteOrder(String ordId)
	{
		try {

			Object[] inputs = new Object[] { ordId };
			int update = jdbcTemplate.update(DELETE_QUERY, inputs);
		} catch (Exception ex) {
			log.warn("[exception Deleting Order]", ex);
		}
	}

	public void cancelOrder(String ordId)
	{
		try {

			Object[] inputs = new Object[] { "X", ordId };
			int update = jdbcTemplate.update(UPDATE_QUERY, inputs);
		} catch (Exception ex) {
			log.warn("[exception Cancelling Order=" + ordId + "]", ex);
		}
	}

	@Required
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
}
