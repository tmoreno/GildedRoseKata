package com.gildedrose;

public class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            decreaseSellIn(item);

            switch (item.name) {
                case AGED_BRIE:
                    changeAgedBrieQuality(item);
                    break;

                case BACKSTAGE_PASSES:
                    changeBackstageQuality(item);
                    break;

                case SULFURAS:
                    changeSulfurasQuality(item);
                    break;

                default:
                    changeRegularItemQuality(item);
            }
        }
    }

    private void changeAgedBrieQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void changeBackstageQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        else {
            increaseQuality(item);

            if (item.sellIn < 10) {
                increaseQuality(item);
            }

            if (item.sellIn < 5) {
                increaseQuality(item);
            }
        }
    }

    private void changeSulfurasQuality(Item item) {

    }

    private void changeRegularItemQuality(Item item) {
        decreaseQuality(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}