package com.gildedrose;

import com.gildedrose.domain.*;

public class ItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured";

    public static GildedRoseItem createFromItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case SULFURAS:
                return new Sulfuras(item);
            case BACKSTAGE_PASSES:
                return new BackStagePasses(item);
            case CONJURED:
                return new Conjured(item);
            default:
                return new RegularItem(item);
        }
    }
}
