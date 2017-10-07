package com.everything.parsers.gnydm;

/**
 * User: Makar Kalancha
 * Date: 24/09/14
 * Time: 1:59 PM
 */
public class Exhibitor {
    public String Exhibitor;
    public String Address;
    public String Address1;
    public String Country;
    public String Telephone;
    public String Fax;
    public String WebSite;
    public String Booths;

    private String ID;

//    private static int count = 1;
//    public Exhibitor(){
//        System.out.println(">>>"+(count++));
//    }

    @Override
    public String toString() {
//        return "Exhibitor{" +
//                "Exhibitor='" + Exhibitor + '\'' +
//                ", Address='" + Address + '\'' +
//                ", Address1='" + Address1 + '\'' +
//                ", Country='" + Country + '\'' +
//                ", Telephone='" + Telephone + '\'' +
//                ", Fax='" + Fax + '\'' +
//                ", WebSite='" + WebSite + '\'' +
//                ", Booths='" + Booths + '\'' +
//                ", ID='" + ID + '\'' +
//                '}';
        String cityPattern = "^(.[^,]*),(.*)$";
        String city = Address1.replaceAll(cityPattern, "$1");
        if (city.equalsIgnoreCase(Address1)) {
            city = "";
        }
//        String zipCodePattern = "^(.*)\\s+(.[^\\s]*)$";
//        String zipCodePattern = "^(.*),(.*)\\s+(.[^\\s-]*)$";
//        String zipCode = Address1.replaceAll(zipCodePattern, "$3");
        String zipCodePattern = "^(.[^\\s]*)\\s+(.[^\\s-]*)$";
        String zipCode = Address1.replace(city + ",", "");
        zipCode = zipCode.replaceAll(zipCodePattern, "$2");
        if (zipCode.equalsIgnoreCase(Address1)) {
            zipCode = "";
        }

        String state = Address1.replace(city, "").replace(zipCode, "");
//        state = state.replaceAll(".[^A-Za-z0-9_\\s-]+", "~");
        if (state.equalsIgnoreCase(Address1)) {
            state = "";
        }

        return ID + "\t" +
//                Exhibitor + "\t" +
//                Booths + "\t" +
//                Address + "\t" +
                Address1 + "\t" +
                city.trim() + "\t" +
                state.replace(","," ").trim() + "\t" +
                zipCode.replace(","," ").trim() + "\t" +
//                Country + "\t" +
//                Telephone + "\t" +
//                Fax + "\t" +
                WebSite
                ;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    //    private static Map<String,Exhibitor> _exhibitorCodeToExhibitorObj = new HashMap<>();
//
//    private Exhibitor(String Exhibitor,
//                      String Address,
//                      String Address1,
//                      String Country,
//                      String Telephone,
//                      String Fax,
//                      String WebSite,
//                      String Booths) {
//        this.Exhibitor = Exhibitor;
//        this.Address = Address;
//        this.Address1 = Address1;
//        this.Country = Country;
//        this.Telephone = Telephone;
//        this.Fax = Fax;
//        this.WebSite = WebSite;
//        this.Booths = Booths;
//    }
//
//    public static String createExhibitorCode(String Exhibitor,
//                                             String Address,
//                                             String Address1,
//                                             String Country,
//                                             String Telephone,
//                                             String Fax,
//                                             String WebSite,
//                                             String Booths){
//        return Exhibitor + Address + Address1 + Country + Telephone + Fax + WebSite + Booths;
//    }
//
//    public static Exhibitor createExhibitor(String Exhibitor,
//                                          String Address,
//                                          String Address1,
//                                          String Country,
//                                          String Telephone,
//                                          String Fax,
//                                          String WebSite,
//                                          String Booths) {
//        String exhibitorCode = createExhibitorCode(Exhibitor,
//                Address,
//                Address1,
//                Country,
//                Telephone,
//                Fax,
//                WebSite,
//                Booths);
//        Exhibitor instance = _exhibitorCodeToExhibitorObj.get(exhibitorCode);
//        if(instance == null) {
//            instance = new Exhibitor(Exhibitor,
//                    Address,
//                    Address1,
//                    Country,
//                    Telephone,
//                    Fax,
//                    WebSite,
//                    Booths);
//            _exhibitorCodeToExhibitorObj.put(exhibitorCode, instance);
//        }
//        return instance;
//    }


}
