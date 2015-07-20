package everything.java8tests.forimpatient.ch02;

/**
 * User: Makar Kalancha
 * Date: 13/02/2015
 * Time: 18:06
 */
public class City {
    private String cityName;
    private String province;
    private int population;

    public City(String cityName, String province, int populations){
        this.cityName = cityName;
        this.province = province;
        this.population = populations;
    }

    public int getPopulation() {
        return population;
    }

    public String getProvince() {
        return province;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", province='" + province + '\'' +
                ", population=" + population +
                '}';
    }
}
