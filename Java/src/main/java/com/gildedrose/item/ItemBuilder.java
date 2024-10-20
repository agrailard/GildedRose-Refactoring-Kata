package com.gildedrose.item;

public class ItemBuilder {
    private String name;
    private int sellIn;
    private int quality;
    private boolean agedWell = false;
    private boolean noLongerWorthAnythingAfterPeremption = false;
    private boolean legendary = false;

    // Méthode pour définir le nom
    public ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    // Méthode pour définir le sellIn
    public ItemBuilder withSellIn(int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    // Méthode pour définir la qualité
    public ItemBuilder withQuality(int quality) {
        this.quality = quality;
        return this;
    }

    // Méthode pour définir si l'item vieillit bien
    public ItemBuilder agedWell() {
        this.agedWell = true;
        return this;
    }

    // Méthode pour définir si l'item ne vaut plus rien après péremption
    public ItemBuilder noLongerWorthAnythingAfterPeremption() {
        this.noLongerWorthAnythingAfterPeremption = true;
        return this;
    }

    // Méthode pour définir si l'item est légendaire
    public ItemBuilder legendary() {
        this.legendary = true;
        return this;
    }

    // Méthode pour construire l'objet Item
    public Item build() {
        Item item =  new Item(name, sellIn, quality, agedWell, noLongerWorthAnythingAfterPeremption, legendary);

        return item;
    }
}
