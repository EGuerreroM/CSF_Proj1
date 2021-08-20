package com.kodigo.group4;

import java.util.List;

public interface ICancelFlight {
    void cancelFlight(List<Flight> otherList, String find, String reason);
}
