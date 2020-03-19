package com.gildedrose.domain;

import com.gildedrose.Item;

public class Sulfuras extends GildedRoseItem {

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void decreaseSellIn() {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }
}
