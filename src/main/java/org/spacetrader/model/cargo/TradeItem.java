package org.spacetrader.model.cargo;

import org.spacetrader.model.enums.SpecialResource;
import org.spacetrader.model.enums.SystemPressure;
import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.model.system.StarSystem;


public class TradeItem implements Comparable<TradeItem> {

    private final SpecialResource resourceLowPrice; // When this resource is available, this trade item is cheap
    private final SpecialResource resourceHighPrice;// When this resource is available, this trade item is expensive
    private final SystemPressure pressurePriceHike; // Price increases considerably when this event occurs
    private final TechLevel techProduction;         // Tech level needed for production
    private final TechLevel techUsage;              // Tech level needed to use
    private final TechLevel techTopProduction;      // Tech level which produces this item the most
    private final TradeItemType type;
    private final int pictureLowTech;   // Medium price at lowest tech level
    private final int priceIncrease;      // Price increase per tech level
    private final int priceVariance; // Max percentage above or below calculated price
    private final int minTradePrice; // Minimum price to buy/sell in orbit
    private final int maxTradePrice; // Minimum price to buy/sell in orbit
    private final int roundOff;      // Roundoff price for trade in orbit

    public TradeItem(final TradeItemType type, final TechLevel techProduction, final TechLevel techUsage, final TechLevel techTopProduction, final int pictureeLowTech,
                     final int priceInc, final int priceVariance, final SystemPressure pressurePriceHike, final SpecialResource resourceLowPrice,
                     final SpecialResource resourceHighPrice, final int minTradePrice, final int maxTradePrice, final int roundOff) {
        this.type = type;
        this.techProduction = techProduction;
        this.techUsage = techUsage;
        this.techTopProduction = techTopProduction;
        pictureLowTech = pictureeLowTech;
        priceIncrease = priceInc;
        this.priceVariance = priceVariance;
        this.pressurePriceHike = pressurePriceHike;
        this.resourceLowPrice = resourceLowPrice;
        this.resourceHighPrice = resourceHighPrice;
        this.minTradePrice = minTradePrice;
        this.maxTradePrice = maxTradePrice;
        this.roundOff = roundOff;
    }

    @Override
    public int compareTo(final TradeItem tradeItem) {
        return CompareTo(tradeItem);
    }

    public int CompareTo(final Object value) {
        int compared = 0;
        if (value == null) {
            compared = 1;
        } else {
            compared = ((Integer) pictureLowTech).compareTo(((TradeItem) value).pictureLowTech);
            if (compared == 0) {
                compared = -((Integer) priceIncrease).compareTo(((TradeItem) value).priceIncrease);
            }
        }
        return compared;
    }

    public int getStandardPrice(final StarSystem target) {
        int price = 0;
        if (target.ItemUsed(this)) {
            // Determine base price on techlevel of system
            price = pictureLowTech + target.TechLevel().ordinal() * priceIncrease;
            // If a good is highly requested, increase the price
            if (target.PoliticalSystem().Wanted() == type) {
                price = price * 4 / 3;
            }
            // High trader activity decreases prices
            price = price * (100 - 2 * target.PoliticalSystem().ActivityTraders().getId()) / 100;
            // Large system = high production decreases prices
            price = price * (100 - target.Size().getId()) / 100;
            // Special resources price adaptation
            if (target.SpecialResource() == resourceLowPrice) {
                price = price * 3 / 4;
            } else if (target.SpecialResource() == resourceHighPrice) {
                price = price * 4 / 3;
            }
        }
        return price;
    }

    public boolean isIllegal() {
        return type == TradeItemType.Firearms || type == TradeItemType.Narcotics;
    }

    public int MaxTradePrice() {
        return maxTradePrice;
    }

    public int MinTradePrice() {
        return minTradePrice;
    }

    public String Name() {
        return type.name;
    }

    public SystemPressure PressurePriceHike() {
        return pressurePriceHike;
    }

    public int PriceInc() {
        return priceIncrease;
    }

    public int PriceLowTech() {
        return pictureLowTech;
    }

    public int PriceVariance() {
        return priceVariance;
    }

    public SpecialResource ResourceHighPrice() {
        return resourceHighPrice;
    }

    public SpecialResource ResourceLowPrice() {
        return resourceLowPrice;
    }

    public int RoundOff() {
        return roundOff;
    }

    public TechLevel TechProduction() {
        return techProduction;
    }

    public TechLevel TechTopProduction() {
        return techTopProduction;
    }

    public TechLevel TechUsage() {
        return techUsage;
    }

    public TradeItemType Type() {
        return type;
    }
}
