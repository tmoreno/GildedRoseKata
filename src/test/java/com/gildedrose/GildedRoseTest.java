package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    private static final String REGULAR_ITEM = "foo";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void items_name_does_not_change() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].name, is(REGULAR_ITEM));
    }

    @Test
    public void given_a_regular_item_when_pass_a_day_then_sellin_decrease_by_one() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 10, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemSellinIs(app.items[0], 9);
    }

    @Test
    public void given_a_regular_item_with_sellin_and_quality_when_pass_a_day_then_quality_decrease_by_one() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 10, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 4);
    }

    @Test
    public void given_a_regular_item_with_no_sellin_and_with_quality_when_pass_a_day_then_quality_decrease_by_two() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 3);
    }

    @Test
    public void given_a_regular_item_with_no_sellin_and_zero_quality_when_pass_a_day_then_the_quality_is_not_negative() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 0);
    }

    @Test
    public void given_a_regular_item_with_no_sellin_and_negative_quality_when_pass_a_day_then_the_quality_not_changes() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, -1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], -1);
    }

    @Test
    public void given_an_aged_brie_with_sellin_when_pass_a_day_then_the_quality_increased_by_one() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 2);
    }

    @Test
    public void given_an_aged_brie_with_no_sellin_when_pass_a_day_then_the_quality_is_increased_by_two() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 3);
    }

    @Test
    public void the_quality_of_an_item_is_never_more_than_50() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 50) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 50);
    }

    @Test
    public void given_a_sulfuras_item_when_pass_a_day_the_sellin_and_quality_not_changes() {
        Item[] items = new Item[] { new Item(SULFURAS, 10, 10) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemSellinIs(app.items[0], 10);
        assertThatItemQualityIs(app.items[0], 10);
    }

    @Test
    public void given_a_backstage_passes_item_with_sellin_more_than_10_when_pass_a_day_then_quality_increased_by_one() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 15, 10) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 11);
    }

    @Test
    public void given_a_backstage_passes_item_with_sellin_equals_to_10_when_pass_a_day_then_quality_increased_by_two() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 10) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 12);
    }

    @Test
    public void given_a_backstage_passes_item_with_sellin_equals_to_5_when_pass_a_day_then_quality_increased_by_two() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 10) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 13);
    }

    @Test
    public void given_a_backstage_passes_item_with_sellin_equals_to_0_when_pass_a_day_then_quality_increased_is_zero() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 10) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThatItemQualityIs(app.items[0], 0);
    }

    private void assertThatItemSellinIs(Item item, int expectedSellIn) {
        assertThat(item.sellIn, is(expectedSellIn));
    }

    private void assertThatItemQualityIs(Item item, int expectedQuality) {
        assertThat(item.quality, is(expectedQuality));
    }
}
