package org.unibl.etf.enums;

public enum Dimension {
    SEVEN(7, "7x7"),
    EIGHT(8, "8x8"),
    NINE(9, "9x9"),
    TEN(10, "10x10");

    public final int value;
    public final String stringValue;

    private Dimension(int i, String s) {
        this.value = i;
        this.stringValue = s;
    }

    public static Dimension getDimensionByString(String stringValue) {
        Dimension[] values = Dimension.values();
        for( Dimension i : values){
            if (i.stringValue.equals(stringValue)) return i;
        }
        return  null;
    }
}
