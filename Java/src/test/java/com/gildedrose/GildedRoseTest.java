package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new ItemBuilder().withName("foo").withSellIn(0).withQuality(0).build() };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertEquals("foo", app.items[0].name);
    }

}
