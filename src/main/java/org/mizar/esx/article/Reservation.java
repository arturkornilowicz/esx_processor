package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Reservation extends Item {

    private ArrayList<ReservationSegment> reservationSegments = new ArrayList<>();

    public Reservation(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "reserve " + reservationSegments.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionReservationBeforeReservationSegments(this);
        for (Element element : getElement().elements())
            getReservationSegments().add((ReservationSegment) EsxElementFactory.create(element));
        ESX_Processor.actions.actionReservationAfterReservationSegments(this);
    }
}
