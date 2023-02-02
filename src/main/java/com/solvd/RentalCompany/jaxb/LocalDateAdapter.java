package com.solvd.RentalCompany.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return s != null ? LocalDate.parse(s) : null;
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return date != null ? date.toString() : null;
    }
}