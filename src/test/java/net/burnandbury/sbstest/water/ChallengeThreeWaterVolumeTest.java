package net.burnandbury.sbstest.water;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChallengeThreeWaterVolumeTest {

	@Test
	void test() {
		// Test for given sample.
		var volume = WaterVolume.calculateVolume(new int[] { 0,1,0,2,1,0,1,3,1,3,2,1,0 });		
		assertEquals(7, volume);
		
		// Test for alternatives
		volume = WaterVolume.calculateVolume(new int[] { 0,1,0,0,1,0,0,3,1,3,2,1,0 });
		assertEquals(6, volume);
		volume = WaterVolume.calculateVolume(new int[] { 4,2,0,0,4,0,0,0,1,0,3,1,3 });
		assertEquals(26, volume);
		volume = WaterVolume.calculateVolume(new int[] { 0,17,0,5,0,0,3,1,3,2,1,2 });
		assertEquals(14, volume);
	}

}
