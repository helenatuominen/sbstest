package net.burnandbury.sbstest.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.burnandbury.sbstest.ConsoleLogging;

/**
 * Simple stock management class based on challenge 4 requirements.
 * 
 * <pre>
 *  ..class returns what would have been the best days to buy and then sell the stock at a profit.
 * • Only a single stock can be held at one time.
 * • No stock is held at the start - e.g. the first action should be to buy stock.
 * • Buy and sell as many times as required to maximise profits.
 * 
 * The returned output needs to state the following data:
 * • All transactions listing the numeric days and prices that stock was bought and sold.
 * • The profit of each completed transaction.
 * • The total profit of all transactions.
 * • Note: All stocks must be sold by the end of the stock price history.
 * 
 *  As an example, using the following stock value history: 300, 250, 260, 310, 215, 280.
 *  Buy on day 2 @ 250, sell on day 4 @ 310, buy again on day 5 @ 215 and sell on day 6 @ 280.
 *  This would have returned a profit of 60 + 65 = 125.
 * </pre> 
 * 
 * @author Helena Tuominen
 *
 */
class StockHistory {

	/**
	 * A set of Transaction records, representing a historical view.
	 *
	 */
	record TransactionHistory(List<TransactionProfit> transactions) {		
		
		static final Logger logger = ConsoleLogging.getLogger(StockHistory.TransactionHistory.class);
		static final ObjectMapper mapper = new ObjectMapper();
		
		@JsonProperty(value = "total_profit", access = JsonProperty.Access.READ_ONLY)
		public Integer getTotalProfit() {
			return transactions.stream().collect(Collectors.summingInt(tx -> tx.profit));
		}
		
		/**
		 * Renders this TransactionHistory to a JSON string.
		 * @throws RuntimeException if the underlying Jackson API has a platform problems.
		 */
		public String toString() {
			try {
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			} catch (JsonProcessingException jex) {
				throw new RuntimeException(jex);
			}
		}
	}

	/**
	 * A buy/sell set of Transactions and associated profit.
	 */
	record TransactionProfit(Transaction bought, Transaction sold, Integer profit) {}

	/**
	 * A single Transaction record.
	 */
	record Transaction(Integer day, Integer value) {}
	
	/**
	 * Given an array of stock values representing a series of dates,
	 * provide a TransactionHistory representing the linear transactions with maximum profit.
	 * 
	 * @param the series of stock values.
	 * @return the maximised profit TransactionHistory
	 */
	static TransactionHistory getBestTransactions(int[] values) {		
        var txProfitList = new ArrayList<TransactionProfit>();
        Optional<Transaction> buyTx = Optional.empty();
        var dateIdx = 0;
        
        for ( dateIdx = 0; dateIdx <= values.length - 1; dateIdx++ ) { 
        	if ( dateIdx + 1 < values.length
        			&& values[dateIdx + 1] > values[dateIdx] 
        			&& buyTx.isEmpty()) {
        		buyTx = Optional.of(new Transaction (dateIdx, values[dateIdx]));
        	} 
        	else if (!buyTx.isEmpty() && values[dateIdx] > buyTx.get().value) {
        		 var sellTx = new Transaction(dateIdx, values[dateIdx]);
        		 txProfitList.add(new TransactionProfit(buyTx.get(), sellTx, sellTx.value - buyTx.get().value));
        		 buyTx = Optional.empty();
        	 }
        }
        
        // Clean up any remaining stock, we don't want it eh 
        if (!buyTx.isEmpty()) {
        	var sellTx = new Transaction(dateIdx, values[dateIdx]);
        	txProfitList.add(new TransactionProfit(buyTx.get(), sellTx, sellTx.value - buyTx.get().value));
        }
        	
		return new TransactionHistory(txProfitList);
	}
	
}
