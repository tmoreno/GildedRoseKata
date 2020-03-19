package com.gildedrose.domain;

import com.gildedrose.Item;

public class RegularItem extends GildedRoseItem {

    public RegularItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();

        if (getSellIn() < 0) {
            decreaseQuality();
        }
    }
}
