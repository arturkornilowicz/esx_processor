package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

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
}
