package com.gildedrose.domain;

import com.gildedrose.Item;

public class BackStagePasses extends GildedRoseItem {

    public BackStagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (getSellIn() < 0) {
            setQualityToZero();
        }
        else {
            increaseQuality();

            if (getSellIn() < 10) {
                increaseQuality();
            }

            if (getSellIn() < 5) {
                increaseQuality();
            }
        }
    }
}
