package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    private static final String REGULAR_ITEM = "foo";
    private static final String AGED_BRIE = "Aged Brie";

    @Test
    public void items_name_does_not_change() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].name, is(REGULAR_ITEM));
    }

    @Test
    public void given_a_regular_item_with_sellin_and_quality_when_pass_a_day_then_quality_decrease_by_one() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 10, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(4));
    }

    @Test
    public void given_a_regular_item_with_no_sellin_and_with_quality_when_pass_a_day_then_quality_decrease_by_two() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(3));
    }

    @Test
    public void given_a_regular_item_with_no_sellin_and_zero_quality_when_pass_a_day_then_the_quality_is_not_negative() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(0));
    }

    @Test
    public void given_a_regular_item_with_no_sellin_and_negative_quality_when_pass_a_day_then_the_quality_not_changes() {
        Item[] items = new Item[] { new Item(REGULAR_ITEM, 0, -1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(-1));
    }

    @Test
    public void given_an_aged_brie_with_sellin_when_pass_a_day_then_the_quality_increased_by_one() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(2));
    }

    @Test
    public void given_an_aged_brie_with_no_sellin_when_pass_a_day_then_the_quality_is_increased_by_two() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(3));
    }
}
