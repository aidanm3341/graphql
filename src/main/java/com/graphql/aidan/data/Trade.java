package com.graphql.aidan.data;

public class Trade {
  private String symbol;

  private String longshort;

  private Integer qty;

  private Double price;

  public Trade() {
  }

  public Trade(String symbol, String longshort, Integer qty, Double price) {
    this.symbol = symbol;
    this.longshort = longshort;
    this.qty = qty;
    this.price = price;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getLongshort() {
    return longshort;
  }

  public void setLongshort(String longshort) {
    this.longshort = longshort;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Trade{" + "symbol='" + symbol + "'," +"longshort='" + longshort + "'," +"qty='" + qty + "'," +"price='" + price + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade that = (Trade) o;
        return java.util.Objects.equals(symbol, that.symbol) &&
                            java.util.Objects.equals(longshort, that.longshort) &&
                            java.util.Objects.equals(qty, that.qty) &&
                            java.util.Objects.equals(price, that.price);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(symbol, longshort, qty, price);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String symbol;

    private String longshort;

    private Integer qty;

    private Double price;

    public Trade build() {
                  Trade result = new Trade();
                      result.symbol = this.symbol;
          result.longshort = this.longshort;
          result.qty = this.qty;
          result.price = this.price;
                      return result;
    }

    public Builder symbol(String symbol) {
      this.symbol = symbol;
      return this;
    }

    public Builder longshort(String longshort) {
      this.longshort = longshort;
      return this;
    }

    public Builder qty(Integer qty) {
      this.qty = qty;
      return this;
    }

    public Builder price(Double price) {
      this.price = price;
      return this;
    }
  }
}
