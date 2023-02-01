package com.solvd.RentalCompany.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Year;

public class YearAdapter extends XmlAdapter <String, Year>{
    @Override
    public Year unmarshal(String s) throws Exception {
        return s != null ? Year.parse(s) : null;
    }

    @Override
    public String marshal(Year year) throws Exception {
        return year != null ? year.toString() : null;
    }
}