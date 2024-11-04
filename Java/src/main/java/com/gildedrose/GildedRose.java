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

            decrementeNbJoursAvantPeremption(item);

            if (item.name.equals(ITEM_SULFURAS)) {
                continue;
            }

            if (item.name.equals(ITEM_BRIE)){
                gagneEnQualite(item);
                if(estPerime(item)){
                    gagneEnQualite(item);
                }
                continue;
            }

            if (item.name.equals(ITEM_BACKSTAGE)){
                if(estPerime(item)){
                    item.quality = 0;
                    continue;
                }
                gagneEnQualite(item);
                gagneEnQualiteAvantPeremption(item);
                continue;
            }

            perdEnQualite(item);

            if (estPerime(item)) {
                perdEnQualite(item);
            }
        }
    }


    private static void gagneEnQualiteAvantPeremption(Item item) {
        if (resteNbJoursAvantPeremption(item, 10)) {
            gagneEnQualite(item);
        }

        if (resteNbJoursAvantPeremption(item, 5)) {
            gagneEnQualite(item);
        }
    }

    private static boolean resteNbJoursAvantPeremption(Item item, int nbJours) {
        return item.sellIn < nbJours;
    }

    private static void perdEnQualite(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
            if (item.name.equals(ITEM_CONJURED)) {
                item.quality -= 1;
            }
        }
    }

    private static boolean estPerime(Item item) {
        return resteNbJoursAvantPeremption(item, 0);
    }

    private static void decrementeNbJoursAvantPeremption(Item item) {
        if (!item.name.equals(ITEM_SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private static void gagneEnQualite(Item item) {
        if (item.quality < GildedRose.QUALITE_MAX) {
            item.quality = item.quality + 1;
        }
    }

}
