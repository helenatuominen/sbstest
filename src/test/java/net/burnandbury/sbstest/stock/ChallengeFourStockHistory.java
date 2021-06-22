package net.burnandbury.sbstest.stock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import net.burnandbury.sbstest.ConsoleLogging;

class ChallengeFourStockHistory {

	static final Logger logger = ConsoleLogging.getLogger(ChallengeFourStockHistory.class);

	void printInfo(int[] testData, String stockHistory) {
		logger.info("""
				Output from StockHistory.getBestTransactions for array 
				""" + Arrays.toString(testData));
		logger.info(stockHistory);
	}
	
	@Test
	void sellingStockWithSampleData() {
		// Profit of 665
		var testData = new int[] {
				360, 255, 260, 230, 150, 100, 135, 265, 750, 460, 600
			};
		var stkHistory = StockHistory.getBestTransactions(testData);
		printInfo(testData, stkHistory.toString());
		assertEquals(665, stkHistory.getTotalProfit());
	}
	
	@Test
	void neverBuyingStock() {
		// Profit of 0
		var testData = new int[] {
				20, 20, 20, 20, 20, 20, 20
			};
		var stkHistory = StockHistory.getBestTransactions(testData);
		printInfo(testData, stkHistory.toString());
		assertEquals(0, stkHistory.getTotalProfit());
	}

	@Test
	void tradingPlacesFrozenConcentratedOrangeJuiceMarketCrash() {
		// Profit of 130
		var testData = new int[] {
				20, 30, 25, 70, 100, 150, 20, 20, 20, 45, 50, 50
			};
		var stkHistory = StockHistory.getBestTransactions(testData);
		printInfo(testData, stkHistory.toString());
		assertEquals(130, stkHistory.getTotalProfit());
	}	
}
