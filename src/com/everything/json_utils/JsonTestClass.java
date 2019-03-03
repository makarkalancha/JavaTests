package com.everything.json_utils;

/**
 * Created by mcalancea on 2016-04-07.
 */
public class JsonTestClass {
    @S1erializedName("a-0.1")
//    @SerializedName("a-0.1")
    private int a;
    private String b;
//    @S1erializedName("c-2.3")
//    @SerializedName("c-2.3")
//    private List<InnerJson> c;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JsonTestClass that = (JsonTestClass) o;

        if (a != that.a) {
            return false;
        }
        return !(b != null ? !b.equals(that.b) : that.b != null);
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JsonTestClass{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }

    public static class InnerJson{
        private boolean isNew;
        private int value;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            InnerJson innerJson = (InnerJson) o;

            if (isNew != innerJson.isNew) {
                return false;
            }
            return value == innerJson.value;
        }

        @Override
        public int hashCode() {
            int result = (isNew ? 1 : 0);
            result = 31 * result + value;
            return result;
        }

        @Override
        public String toString() {
            return "InnerJson{" +
                    "isNew=" + isNew +
                    ", value=" + value +
                    '}';
        }
    }
}
