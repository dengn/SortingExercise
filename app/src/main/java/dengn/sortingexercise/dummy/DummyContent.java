package dengn.sortingexercise.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add sample data content.
        addItem(new DummyItem("1", "Insertion sort"));
        addItem(new DummyItem("2", "Shell sort"));
        addItem(new DummyItem("3", "Selection sort"));
        addItem(new DummyItem("4", "Heap sort"));
        addItem(new DummyItem("5", "Bubble sort"));
        addItem(new DummyItem("6", "Quick sort"));
        addItem(new DummyItem("7", "Merge sort"));
        addItem(new DummyItem("8", "Radix sort"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
