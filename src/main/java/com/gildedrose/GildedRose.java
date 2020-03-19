package com.gildedrose;

import com.gildedrose.domain.GildedRoseItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

    Item[] items;

    private final List<GildedRoseItem> gildedRoseItems;

    public GildedRose(Item[] items) {
        this.items = items;

        this.gildedRoseItems = Arrays.stream(this.items)
                .map(ItemFactory::createFromItem)
                .collect(Collectors.toList());
    }

    public void updateQuality() {
        for (GildedRoseItem item : gildedRoseItems) {
            item.decreaseSellIn();
            item.updateQuality();
        }
    }
}