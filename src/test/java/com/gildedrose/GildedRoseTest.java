package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void items_name_does_not_change() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].name, is("foo"));
    }

    @Test
    public void when_sell_date_is_not_passed_then_quality_should_decrease_by_one() {
        Item[] items = new Item[] { new Item("foo", 10, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(4));
    }

    @Test
    public void when_sell_date_is_passed_then_quality_should_decrease_twice() {
        Item[] items = new Item[] { new Item("foo", 0, 5) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(3));
    }

    @Test
    public void given_an_item_with_zero_quality_then_the_quality_is_not_negative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(0));
    }

    @Test
    public void given_an_item_with_negative_quality_then_the_quality_not_changes() {
        Item[] items = new Item[] { new Item("foo", 0, -1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(-1));
    }

    @Test
    public void the_quality_in_aged_brie_is_increased_by_one() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(2));
    }

    @Test
    public void the_quality_in_aged_brie_is_increased_twice_when_sell_date_is_zero() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality, is(3));
    }
}
