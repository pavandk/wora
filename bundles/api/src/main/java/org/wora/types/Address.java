package org.wora.types;

public class Address {

    Coordinate coordinate;

    String doorNum;

    String locality;

    int pinCode;

    String street;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public String getLocality() {
        return locality;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address [doorNum=" + doorNum + ", street=" + street + ", pinCode=" + pinCode + ", locality=" + locality + ", coordinate="
                + coordinate + "]";
    }

    public static class Coordinate {
        private final long latitude;

        private final long longitude;

        public Coordinate(long longitude, long latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public long getLatitude() {
            return latitude;
        }

        public long getLongitude() {
            return longitude;
        }

        @Override
        public String toString() {
            return "Coordinate [longitude=" + longitude + ", latitude=" + latitude + "]";
        }

    }

}
