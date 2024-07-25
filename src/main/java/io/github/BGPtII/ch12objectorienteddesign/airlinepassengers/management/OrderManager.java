package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.management;

import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.Passenger;
import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.orders.Order;
import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating.Row;
import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating.RowPartition;
import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating.Seat;
import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating.Section;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderManager implements ReportHandling {

    private SectionManager sectionManager;
    private Map<Order, Passenger> pendingOrders;

    public OrderManager(SectionManager sectionManager) {
        this.sectionManager = sectionManager;
        pendingOrders = new LinkedHashMap<>();
    }

    public void addPendingOrder(Order order, Passenger passenger) {
        pendingOrders.put(order, passenger);
    }

    public void completeOrder(Order order) {
        if (!pendingOrders.containsKey(order)) {
            throw new IllegalArgumentException("order specified is not a valid pending order.");
        }
        pendingOrders.get(order).incrementAmountOwed(order.getTotalCost());
        pendingOrders.remove(order);
    }

    @Override
    public String getReport() {
        StringBuilder seatsToAvailability = new StringBuilder();
        for (Section section : sectionManager.getSections()) {
            for (Row row : section.getRows()) {
                for (RowPartition rowPartition : row.getRowPartitions()) {
                    seatsToAvailability.append("{");
                    for (Seat seat : rowPartition.getSeats()) {
                        seatsToAvailability.append(" ");
                        if (seat.getOccupyingPassenger() == null) {
                            seatsToAvailability.append("N");
                        }
                        else {
                            seatsToAvailability.append(seat.getOccupyingPassenger().getAmountOwed());
                        }
                    }
                    seatsToAvailability.append("}");
                }
                seatsToAvailability.append("\n");
            }
            seatsToAvailability.append("\n");
        }
        return seatsToAvailability.toString();
    }

}
