package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemBuilder;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
            new ItemBuilder().withName("+5 Dexterity Vest").withSellIn(10).withQuality(20).build(),
            new ItemBuilder().withName("Aged Brie").withSellIn(2).withQuality(0).agedWell().build(),
            new ItemBuilder().withName("Elixir of the Mongoose").withSellIn(5).withQuality(7).build(),
            new ItemBuilder().withName("Sulfuras, Hand of Ragnaros").withSellIn(0).withQuality(80).legendary().build(),
            new ItemBuilder().withName("Sulfuras, Hand of Ragnaros").withSellIn(-1).withQuality(80).legendary().build(),
            new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(15).withQuality(20).agedWell().noLongerWorthAnythingAfterPeremption().build(),
            new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(10).withQuality(49).agedWell().noLongerWorthAnythingAfterPeremption().build(),
            new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(49).agedWell().noLongerWorthAnythingAfterPeremption().build(),
                // this conjured item does not work properly yet
            new ItemBuilder().withName("Conjured Mana Cake").withSellIn(3).withQuality(6).build()
        };

        GildedRose app = new GildedRose(items);

        int days = 31;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateInventory();
        }
    }

}
