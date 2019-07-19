package my.test.cdek.util;

public class Page {

    public static int getOffset(String button, String back, String next, int currentOffset, int limit, int count) {
        if (button.equals(next)) {
            currentOffset = currentOffset + limit;
            if (currentOffset >= count) {
                currentOffset = 0;
            }
        } else if (button.equals(back)) {
            currentOffset = currentOffset - limit;
            if (currentOffset < 0) {
                currentOffset = limit * (count / limit);
                if (count == currentOffset) {
                    currentOffset = currentOffset - limit;
                }
            }
        }
        return currentOffset;
    }

    public static int countPages(int count, int limit) {
        if (count % limit == 0) {
            return count / limit;
        }
        return count / limit + 1;
    }

    public static int currentPage(int offset, int limit) {
        return offset / limit + 1;
    }
}
