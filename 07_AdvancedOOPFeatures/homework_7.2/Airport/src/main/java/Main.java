import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Terminal> terminalList = airport.getTerminals();
        List<Flight> flightList = terminalList.stream()
                .flatMap(terminal -> terminal.getFlights().stream()
                        .filter(flight -> {
                            boolean isTrueTime = false;
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(new Date());
                            cal.add(Calendar.HOUR_OF_DAY, 2);
                            Date dateNow = new Date();
                            Date dateNowPlusTwoHours = cal.getTime();
                            if (flight.getDate().after(dateNow) && flight.getDate().before(dateNowPlusTwoHours)) {
                                isTrueTime = true;
                            }

                            return isTrueTime;
                        })
                        .filter(flight -> flight.getType() == Flight.Type.DEPARTURE))
                .collect(Collectors.toList());
        return flightList;
    }

}