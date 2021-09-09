package com.kodigo.group4;

import java.util.List;

public interface IUpdateFlight {
    boolean verifyIfExist(List<Flight> otherList, String find);
    void updateFlight();
}
