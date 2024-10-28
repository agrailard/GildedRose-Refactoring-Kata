package com.gildedrose;

class GildedRose {
    public static final int QUALITE_MAX = 50;
    public static final String ITEM_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ITEM_BRIE = "Aged Brie";
    public static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String ITEM_CONJURED ="Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            majQualiteInit(item);

            decrementeNbJoursAvantPeremption(item);

            if (estPerime(item)) {
                majQualiteApresPeremption(item);
            }
        }
    }

    private static void majQualiteApresPeremption(Item item) {

            if (item.name.equals(ITEM_BACKSTAGE)) {
                item.quality = 0;
            }
            if (!item.name.equals(ITEM_BRIE)) {
                if (!item.name.equals(ITEM_BACKSTAGE)) {
                    perdEnQualite(item);
                }
            } else {
                if (item.quality < QUALITE_MAX) {
                    gagneEnQualite(item);
                }
            }
        }


    private static void majQualiteInit(Item item) {
        if (!item.name.equals(ITEM_BRIE)
                && !item.name.equals(ITEM_BACKSTAGE)) {
            perdEnQualite(item);
        } else {
            if (item.quality < QUALITE_MAX) {
                gagneEnQualite(item);

                if (item.name.equals(ITEM_BACKSTAGE)) {
                    gagneEnQualiteAvantPeremption(item);
                }
            }
        }
    }

    private static void gagneEnQualiteAvantPeremption(Item item) {
        if (item.sellIn <= 10) {
            if (item.quality < QUALITE_MAX) {
                gagneEnQualite(item);
            }
        }

        if (item.sellIn <= 5) {
            if (item.quality < QUALITE_MAX) {
                gagneEnQualite(item);
            }
        }
    }

    private static void perdEnQualite(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals(ITEM_SULFURAS)) {
                item.quality -= 1;
            }
            if (item.name.equals(ITEM_CONJURED)) {
                item.quality -= 1;
            }
        }
    }

    private static boolean estPerime(Item item) {
        return item.sellIn < 0;
    }

    private static void decrementeNbJoursAvantPeremption(Item item) {
        if (!item.name.equals(ITEM_SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private static void gagneEnQualite(Item item) {
        item.quality = item.quality + 1;
    }

}
