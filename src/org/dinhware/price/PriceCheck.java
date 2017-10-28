package org.dinhware.price;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by: Niklas
 * Date: 25.06.2017
 * Alias: Dinh
 * Time: 23:46
 */

public class PriceCheck {

    private boolean cache;
    private long lastRefresh, refreshRate;
    private HashMap<Integer, Integer> itemCache;

    public PriceCheck(boolean cache, long refreshRate) {
        this.cache = cache;
        this.refreshRate = refreshRate;
        this.lastRefresh = System.currentTimeMillis();
        if (cache) itemCache = new HashMap<>();
    }

    public PriceCheck() {
        this(false, Long.MAX_VALUE);
    }

    public int getPrice(PriceType priceType, int itemID, boolean useCache) {
        if (cache && useCache) {
            if (System.currentTimeMillis() - lastRefresh >= refreshRate) {
                System.out.println("Clearing cache...");
                lastRefresh = System.currentTimeMillis();
                itemCache.clear();
            } else if (itemCache.containsKey(itemID)) {
                System.out.println("Returning price from Cache");
                return itemCache.get(itemID);
            }
        }
        int price = 0;
        switch (priceType) {
            case RS_BUDDY:
                price = getBuddyPrice(itemID);
                break;
            case RUNESCAPE:
                price = getRunescapePrice(itemID);
                break;
            case GRAPHS:
                price = getGraphPrice(itemID);
                break;
        }
        if (cache && price != -1) itemCache.put(itemID, price);
        return price;
    }

    public int getPrice(PriceType priceType, int itemID) {
        return getPrice(priceType, itemID, true);
    }

    public int getPrice(int itemID) {
        int price;
        if ((price = getBuddyPrice(itemID)) != -1) return price;
        else if ((price = getGraphPrice(itemID)) != -1) return price;
        else return getRunescapePrice(itemID);
    }

    /*
     0 = overall
     1 = buying
     2 = buyingQuantity
     3 = selling
     4 = sellingQuantity
     */

    public int getBuddyPrice(int itemID, int index) {
        try {
            String response = readURL(PriceType.RS_BUDDY.getLocation(), itemID);
            int occurrence = ordinalIndexOf(response, ":", index);
            return Integer.parseInt(response.substring(occurrence + 1, response.indexOf(index == 4 ? "}" : ",", occurrence)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int ordinalIndexOf(String main, String search, int index) {
        int pos = main.indexOf(search);
        while (index-- > 0 && pos != -1) pos = main.indexOf(search, pos + 1);
        return pos;
    }

    private int getBuddyPrice(int itemID) {
        try {
            String response = readURL(PriceType.RS_BUDDY.getLocation(), itemID);
            return Integer.parseInt(response.substring(response.indexOf(":") + 1, response.indexOf(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getRunescapePrice(int itemID) {
        try {
            String response = readURL(PriceType.RUNESCAPE.getLocation(), itemID);
            int indexOf = response.indexOf("price");
            return formatPrice(response.substring(response.indexOf(":", indexOf) + 1, response.indexOf("}", indexOf)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getGraphPrice(int itemID) {
        try {
            String response = readURL(PriceType.GRAPHS.getLocation(), String.valueOf(itemID) + ".json");
            int lastIndexOf = response.lastIndexOf(":") + 1;
            return Integer.parseInt(response.substring(lastIndexOf, response.indexOf("}", lastIndexOf)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private Integer formatPrice(String price) {
        return Integer.parseInt(price.replaceAll("k", "000").replaceAll("m", "000000").replaceAll("b", "00000000").replaceAll("[^\\d+]", ""));
    }

    private String readURL(String base, Object o) throws IOException {
        InputStream streamIn = new URL(base + o).openStream();
        try (BufferedReader readIn = new BufferedReader(new InputStreamReader(streamIn, Charset.forName("UTF-8")))) {
            return getString(readIn);
        }
    }

    private String getString(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int currentChar;
        while ((currentChar = reader.read()) != -1) {
            stringBuilder.append((char) currentChar);
        }
        return stringBuilder.toString();
    }

}