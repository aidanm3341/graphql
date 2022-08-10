package com.graphql.aidan.data;

import java.util.List;

public class Position {
  private String symbol;

  private List<Trade> trades;

  public Position() {
  }

  public Position(String symbol, List<Trade> trades) {
    this.symbol = symbol;
    this.trades = trades;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public List<Trade> getTrades() {
    return trades;
  }

  public void setTrades(List<Trade> trades) {
    this.trades = trades;
  }

  @Override
  public String toString() {
    return "Position{" + "symbol='" + symbol + "'," +"trades='" + trades + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return java.util.Objects.equals(symbol, that.symbol) &&
                            java.util.Objects.equals(trades, that.trades);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(symbol, trades);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String symbol;

    private List<Trade> trades;

    public Position build() {
                  Position result = new Position();
                      result.symbol = this.symbol;
          result.trades = this.trades;
                      return result;
    }

    public Builder symbol(String symbol) {
      this.symbol = symbol;
      return this;
    }

    public Builder trades(List<Trade> trades) {
      this.trades = trades;
      return this;
    }
  }
}
