package com.gildedrose.domain;

import com.gildedrose.Item;

public abstract class GildedRoseItem {

    private static final int MAX_QUALITY = 50;

    private final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();

    public int getSellIn() {
        return item.sellIn;
    }

    public void decreaseSellIn() {
        item.sellIn--;
    }

    public void increaseQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    public void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public void setQualityToZero() {
        item.quality = 0;
    }
}
