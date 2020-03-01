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
}
