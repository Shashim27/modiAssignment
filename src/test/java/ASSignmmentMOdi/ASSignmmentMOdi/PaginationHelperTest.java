package ASSignmmentMOdi.ASSignmmentMOdi;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaginationHelperTest {
	
	 private static final List<String> ITEMS = Arrays.asList("a", "b", "c", "d", "e", "f");

	    private paginationHelper<String> helper;

	    @Test
	    public void testConstructor() {
	        helper = new paginationHelper<>(ITEMS, 4);
	        Assert.assertEquals(helper.itemCount(), 6);
	        Assert.assertEquals(helper.pageCount(), 2);
	    }

	    @Test
	    public void testPageItemCount() {
	        helper = new paginationHelper<>(ITEMS, 4);
	        Assert.assertEquals(helper.pageItemCount(0), 4);
	        Assert.assertEquals(helper.pageItemCount(1), 2);
	        Assert.assertEquals(helper.pageItemCount(2), -1);
	        Assert.assertEquals(helper.pageItemCount(-1), -1);
	    }

	    @Test
	    public void testPageIndex() {
	        helper = new paginationHelper<>(ITEMS, 4);
	        Assert.assertEquals(helper.pageIndex(0), 0);
	        Assert.assertEquals(helper.pageIndex(5), 1);
	Assert.assertEquals(helper.pageIndex(2), 0);
	Assert.assertEquals(helper.pageIndex(20), -1);
	Assert.assertEquals(helper.pageIndex(-10), -1);
	}
	    
	    
	    /* Explanation :
	     * 
	     * The tests create a `PaginationHelper` instance with an
	     *  array of items and a number indicating how many items 
	     *  fit on a single page. The tests then assert that the
	     *   `itemCount` and `pageCount` methods return the 
	     *   expected values, and that the `pageItemCount` and 
	     *   `pageIndex` methods return the correct values for 
	     *   various inputs. These tests ensure that the `PaginationHelper`
	     *    class is functioning correctly.
	     * 
	     * 
	     */
	    

}
