package org.spacetrader.cargo;

import org.spacetrader.main.StarSystem;
import org.spacetrader.main.enums.SpecialResource;
import org.spacetrader.main.enums.SystemPressure;
import org.spacetrader.main.enums.TechLevel;


public class TradeItem implements Comparable<TradeItem> {
    private SpecialResource _resourceLowPrice; // When this resource is available, this trade item is cheap
    private SpecialResource _resourceHighPrice;// When this resource is available, this trade item is expensive
    private SystemPressure _pressurePriceHike; // Price increases considerably when this event occurs
    private TechLevel _techProduction;         // Tech level needed for production
    private TechLevel _techUsage;              // Tech level needed to use
    private TechLevel _techTopProduction;      // Tech level which produces this item the most
    private TradeItemType _type;
    private int _piceLowTech;   // Medium price at lowest tech level
    private int _priceInc;      // Price increase per tech level
    private int _priceVariance; // Max percentage above or below calculated price
    private int _minTradePrice; // Minimum price to buy/sell in orbit
    private int _maxTradePrice; // Minimum price to buy/sell in orbit
    private int _roundOff;      // Roundoff price for trade in orbit

    public TradeItem(TradeItemType type, TechLevel techProduction, TechLevel techUsage, TechLevel techTopProduction, int piceLowTech,
                     int priceInc, int priceVariance, SystemPressure pressurePriceHike, SpecialResource resourceLowPrice,
                     SpecialResource resourceHighPrice, int minTradePrice, int maxTradePrice, int roundOff) {
        _type = type;
        _techProduction = techProduction;
        _techUsage = techUsage;
        _techTopProduction = techTopProduction;
        _piceLowTech = piceLowTech;
        _priceInc = priceInc;
        _priceVariance = priceVariance;
        _pressurePriceHike = pressurePriceHike;
        _resourceLowPrice = resourceLowPrice;
        _resourceHighPrice = resourceHighPrice;
        _minTradePrice = minTradePrice;
        _maxTradePrice = maxTradePrice;
        _roundOff = roundOff;
    }

    @Override
    public int compareTo(TradeItem ti) {
        return CompareTo(ti);
    }

    public int CompareTo(Object value) {
        int compared = 0;
        if (value == null) {
            compared = 1;
        } else {
            compared = ((Integer) _piceLowTech).compareTo(((TradeItem) value)._piceLowTech);
            if (compared == 0) {
                compared = -((Integer) _priceInc).compareTo(((TradeItem) value)._priceInc);
            }
        }
        return compared;
    }

    public int StandardPrice(StarSystem target) {
        int price = 0;
        if (target.ItemUsed(this)) {
            // Determine base price on techlevel of system
            price = _piceLowTech + target.TechLevel().ordinal() * _priceInc;
            // If a good is highly requested, increase the price
            if (target.PoliticalSystem().Wanted() == _type) {
                price = price * 4 / 3;
            }
            // High trader activity decreases prices
            price = price * (100 - 2 * target.PoliticalSystem().ActivityTraders().CastToInt()) / 100;
            // Large system = high production decreases prices
            price = price * (100 - target.Size().CastToInt()) / 100;
            // Special resources price adaptation
            if (target.SpecialResource() == _resourceLowPrice) {
                price = price * 3 / 4;
            } else if (target.SpecialResource() == _resourceHighPrice) {
                price = price * 4 / 3;
            }
        }
        return price;
    }

    public boolean Illegal() {
        return _type == TradeItemType.Firearms || _type == TradeItemType.Narcotics;
    }

    public int MaxTradePrice() {
        return _maxTradePrice;
    }

    public int MinTradePrice() {
        return _minTradePrice;
    }

    public String Name() {
        return _type.name;
    }

    public SystemPressure PressurePriceHike() {
        return _pressurePriceHike;
    }

    public int PriceInc() {
        return _priceInc;
    }

    public int PriceLowTech() {
        return _piceLowTech;
    }

    public int PriceVariance() {
        return _priceVariance;
    }

    public SpecialResource ResourceHighPrice() {
        return _resourceHighPrice;
    }

    public SpecialResource ResourceLowPrice() {
        return _resourceLowPrice;
    }

    public int RoundOff() {
        return _roundOff;
    }

    public TechLevel TechProduction() {
        return _techProduction;
    }

    public TechLevel TechTopProduction() {
        return _techTopProduction;
    }

    public TechLevel TechUsage() {
        return _techUsage;
    }

    public TradeItemType Type() {
        return _type;
    }
}
