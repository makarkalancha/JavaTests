package com.everything.effectivejava.ch03;

/**
 * Created by mcalancea on 2015-04-20.
 */
public class CaseInsensitiveString {
    private final String string;
    public CaseInsensitiveString(String str) {
        this.string = str;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return string.equalsIgnoreCase(((CaseInsensitiveString)o).string);
        }

        //One-way interoperability!!!
        if (o instanceof String) {
            return string.equalsIgnoreCase(((String)o));
        }

        return false;

    }
}
