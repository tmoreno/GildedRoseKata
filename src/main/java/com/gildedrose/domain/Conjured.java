package com.gildedrose.domain;

import com.gildedrose.Item;

public class Conjured extends GildedRoseItem {

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        decreaseQuality();
    }
}
