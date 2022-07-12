package org.unibl.etf.enums;

public enum Color {
    RED(0,false,"0xff0000"), BLUE(1,false, "0x0000ff"), YELLOW(2, false, "0xffff00"), GREEN(3,false, "0x00ff00");

    private final int value;
    private boolean lock;
    private String RGBValue;

    private Color(int i, boolean lock, String s){
        this.value=i;
        this.lock=lock;
        this.RGBValue=s;
    }

    public boolean getLock(){
        return this.lock;
    }

    public void setLock(){
        this.lock=true;
    }

    public String getRGBValue() {
        return RGBValue;
    }
}
