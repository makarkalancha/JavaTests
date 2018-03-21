package com.everything.location;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.util.Arrays;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * Created by mcalancea
 * Date: 21 Mar 2018
 * Time: 09:09
 */
public class GeolocationTest {
//    String googleKey check email

    public static void main(String[] args) throws Exception {
        String googleKey = args[0];

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(googleKey)
                .build();
//        LatLng latLng = new LatLng(38.908133, -77.047119);
        LatLng latLng = new LatLng(45.461374, -73.4659812);

        TimeZone timeZone = TimeZoneApi.getTimeZone(context, latLng).await();
        System.out.println(timeZone.toZoneId().toString());

        GeocodingResult[] geocodingResults = GeocodingApi.reverseGeocode(context, latLng).await();

        System.out.println(geocodingResults);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson("addressComponents:" + Arrays.toString(geocodingResults[0].addressComponents)));
        System.out.println(gson.toJson("addressComponents[0].types:" +
                Arrays.stream(geocodingResults[0].addressComponents)
//                    .flatMap(addressComponent -> Arrays.stream(addressComponent.types))
                    .filter(addressComponent -> Arrays.stream(addressComponent.types)
                                .allMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY) || addressComponentType.equals(AddressComponentType.POLITICAL))
                    )
                    .map(addressComponent1 -> addressComponent1.shortName)
                    .collect(Collectors.toList())
        ));
        System.out.println(gson.toJson("country:" +
                        Arrays.stream(geocodingResults[0].addressComponents)
                                .filter(addressComponent -> Arrays.stream(addressComponent.types)
//                                        .anyMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY))
                                        .allMatch(addressComponentType -> addressComponentType.equals(AddressComponentType.COUNTRY) || addressComponentType.equals(AddressComponentType.POLITICAL))
                                )
                                .map(addressComponent1 -> addressComponent1.shortName)
                                .findFirst().orElse(null)
        ));
//        System.out.println(gson.toJson("addressComponents:" + geocodingResults[0].addressComponents[0].types));
//        System.out.println(gson.toJson("types:" + Arrays.toString(geocodingResults[0].types)));
//        System.out.println(gson.toJson("formattedAddress:" + geocodingResults[0].formattedAddress));
//        System.out.println(gson.toJson("geometry:" + geocodingResults[0].geometry));
//        System.out.println(gson.toJson("partialMatch:" + geocodingResults[0].partialMatch));
//        System.out.println(gson.toJson("placeId:" + geocodingResults[0].placeId));
//        System.out.println(gson.toJson("postcodeLocalities:" + geocodingResults[0].postcodeLocalities));
//        System.out.println(gson.toJson("addressComponents1:" + Arrays.toString(geocodingResults[1].addressComponents)));
    }
}
