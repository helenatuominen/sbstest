package net.burnandbury.sbstest.water;

/**
 * The given array represents the height of a series of 1x1 blocks that are stacked on top of each other.
 * Water is then poured over the blocks and collects into pools between the gaps.
 * 
 * The following image <a href="https://i.imgur.com/riclxSE.png">(https://i.imgur.com/riclxSE.png)</a> 
 * is a visual example of the blocks (black) and the pooled water (blue) for the example array values defined below.
 * 
 * <pre>
 * Input: [0,1,0,2,1,0,1,3,1,3,2,1,0]
 * Output: 7 (volume of water)
 * </pre>
 * 
 * Write a function that when given an array formatted similarly as above, 
 * but with different values, will calculate the total volume of water measured as 1x1 units.
 * 
 * The array will only ever include positive integer values.
 * 
 * @author Helena Tuominen
 *
 */

public class WaterVolume {

	/**
	 * Calculate total volume of water pooled within a 2D heightmap array.
	 * @param blockArray the compact heightmap represented as a series of integer values >= 0.
	 * @return the total volume of water capable of pooling in the varying heights of the heightmap.
	 */
	public static int calculateVolume(int[] blockArray) {
        var leftIndex = 0;
        var rightIndex = blockArray.length - 1;
        var leftTop = 0;
        var rightTop = 0;
        var totalWater = 0;

        while(leftIndex < rightIndex) {
            if (blockArray[leftIndex] < blockArray[rightIndex]) {
                leftTop = Math.max(blockArray[leftIndex], leftTop);
                totalWater += leftTop - blockArray[leftIndex];
                leftIndex++;
            } else {
                rightTop = Math.max(blockArray[rightIndex], rightTop);
                totalWater += rightTop - blockArray[rightIndex];
                rightIndex--;
            }
        }
		
		return totalWater;
	}
	
}
