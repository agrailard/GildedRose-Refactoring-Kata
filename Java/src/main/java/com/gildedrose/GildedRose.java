package com.gildedrose;

import com.gildedrose.item.Item;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {

            item.sellInMinusADay();

            item.updateQuality();
        }
    }
}
