package com.gildedrose.item;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    private boolean agedWell = false;

    private boolean legendary = false;

    private boolean noLongerWorthAnythingAfterPeremption = false;

    Item(String name, int sellIn, int quality, boolean agedWell, boolean noLongerWorthAnythingAfterPeremption, boolean legendary) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.agedWell = agedWell;
        this.noLongerWorthAnythingAfterPeremption = noLongerWorthAnythingAfterPeremption;
        this.legendary = legendary;
    }

    public void sellInMinusADay() {
        if (!legendary) {
            --this.sellIn;
        }
    }

    public void updateQuality() {

        if (noLongerWorthAnythingAfterPeremption && this.isPerempted()) {
            this.quality = 0;
            return;
        }

        if (this.agedWell()) {
            this.gainInQuality();

            if (noLongerWorthAnythingAfterPeremption) {
                if (this.sellIn < 10) {
                    this.gainInQuality();
                }

                if (this.sellIn < 5) {
                    this.gainInQuality();
                }
            }

            if (this.isPerempted()) {
                this.gainInQuality();
            }
            return;
        }

        if (!this.isLegendary()) {
            this.losesInQuality();
        }
    }

    private boolean agedWell() {
        return agedWell;
    }

    private void gainInQuality() {
        if (this.quality < 50) {
            ++this.quality;
        }
    }

    private void losesInQuality() {
        this.quality -= isPerempted() ? 2 : 1;
        this.quality = Math.max(this.quality, 0);
    }

    private boolean isLegendary() {
        return legendary;
    }

    private boolean isPerempted() {
        return this.sellIn < 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
