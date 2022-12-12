package ASSignmmentMOdi.ASSignmmentMOdi;

import java.util.List;

public class paginationHelper<I> {
	 private List<I> items;
	    private int itemsPerPage;

	    /**
	     * The constructor takes in an array of items and a integer indicating how many
	     * items fit within a single page
	     */
	    public paginationHelper(List<I> items, int itemsPerPage) {
	        this.items = items;
	        this.itemsPerPage = itemsPerPage;
	    }

	    /**
	     * returns the number of items within the entire collection
	     */
	    public int itemCount() {
	        return items.size();
	    }

	    /**
	     * returns the number of pages
	     */
	    public int pageCount() {
	        return (int) Math.ceil((double) items.size() / itemsPerPage);
	    }

	    /**
	     * returns the number of items on the current page. page_index is zero based.
	     * this method should return -1 for pageIndex values that are out of range
	     */
	    public int pageItemCount(int pageIndex) {
	        if (pageIndex < 0 || pageIndex >= pageCount())
	            return -1;
	        if (pageIndex == pageCount() - 1)
	            return items.size() % itemsPerPage;
	        return itemsPerPage;
	    }

	    /**
	     * determines what page an item is on. Zero based indexes.
	     * this method should return -1 for itemIndex values that are out of range
	     */
	    public int pageIndex(int itemIndex) {
	        if (itemIndex < 0 || itemIndex >= items.size())
	            return -1;
	        return itemIndex / itemsPerPage;
	    }

}
