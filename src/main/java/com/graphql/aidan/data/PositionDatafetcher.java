package com.graphql.aidan.data;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class PositionDatafetcher {

    private final List<Position> positions;

    public PositionDatafetcher() {
        positions = new ArrayList<>();
        List<Trade> trades = new ArrayList<>(List.of(
                new Trade("ibm.n", "L", 100, 5.4),
                new Trade("ibm.n", "L", 50, 4.0),
                new Trade("ibm.n", "L", 12, 6.1),
                new Trade("ibm.n", "S", 150, 50.9)
        ));
        positions.add(new Position("ibm.n", trades));
    }

    @DgsQuery
    public List<Position> positions(@InputArgument String symbolFilter) {
        if(symbolFilter == null) {
            return positions;
        }

        return positions.stream().filter(s -> s.getSymbol().contains(symbolFilter)).collect(Collectors.toList());
    }

    @DgsMutation
    public Trade addTrade(@InputArgument String symbol, @InputArgument String longshort, @InputArgument int qty, @InputArgument double price) {
        Trade trade = new Trade(symbol, longshort, qty, price);
        positions.stream()
                .filter(pos -> pos.getSymbol().equals(symbol))
                .map(pos -> pos.getTrades().add(trade));
        return trade;
    }
}
