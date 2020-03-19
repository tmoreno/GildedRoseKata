package com.gildedrose.domain;

import com.gildedrose.Item;

public class AgedBrie extends GildedRoseItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();

        if (getSellIn() < 0) {
            increaseQuality();
        }
    }
}
