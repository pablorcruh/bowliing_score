package org.example.domain;

public class LastSlot {

    private int firstShot;

    private int secondShot;

    private int thirdShot;

    private int result;

    public LastSlot(int firstShot, int secondShot, int thirdShot, int result) {
        this.firstShot = firstShot;
        this.secondShot = secondShot;
        this.thirdShot = thirdShot;
        this.result = result;
    }

    public int getFirstShot() {
        return firstShot;
    }

    public void setFirstShot(int firstShot) {
        this.firstShot = firstShot;
    }

    public int getSecondShot() {
        return secondShot;
    }

    public void setSecondShot(int secondShot) {
        this.secondShot = secondShot;
    }

    public int getThirdShot() {
        return thirdShot;
    }

    public void setThirdShot(int thirdShot) {
        this.thirdShot = thirdShot;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
