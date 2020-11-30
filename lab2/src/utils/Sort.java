package utils;

import tariff.Tariff;

public class Sort implements Comparable {
    private String trname;
    @Override
    public int compareTo(Object o) {
            return trname.compareTo(((Tariff) o).getName());
        }
    }


