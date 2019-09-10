package hubspot;

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.*;

/**
 * Main application
 */
public class Application {
    public static void main(String[] args) {

        List<Country> returnList = new ArrayList<>();
        HttpResponse<String> response = Unirest.get("https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=ad14e2cd69c50b48f437bf794ca9").asString();
        Gson gson = new Gson();
        Partners partnerList = gson.fromJson(response.getBody(), Partners.class);

        //1) Create a country_partner map.
        Map<String, ArrayList<Partner>> countryPartnersMap = new HashMap<>();
        Set<String> countrySet = new HashSet<>();
        for (int i = 0; i < partnerList.partners.size(); i++) {
            countrySet.add(partnerList.partners.get(i).getCountry());
        }

        for (Partner p : partnerList.partners) {
            String country = p.getCountry();
            ArrayList<Partner> partners = countryPartnersMap.get(country);
            if (partners == null) {
                partners = new ArrayList<>();
            }
            partners.add(p);
            countryPartnersMap.put(country, partners);
        }

        //2) For every country
        /**
         * Make a calender of its partners
         * Sort the calender incrementally
         * Find the intersection of two lists, so we can find the partners who are available in a row
         * Find the date with max people
         * Find the EARLIEST date with max people
         * Add this record into a return list
         */


        for (String country : countrySet) {
            //2.1 Make a calender of its partners
            HashMap<String, List<Partner>> calender = new HashMap<>();
            ArrayList<Partner> partners = countryPartnersMap.get(country);
            for (Partner partner : partners) {
                for (String date : partner.getAvailableDates()) {
                    List<Partner> partnerArrayList = calender.get(date);
                    if (partnerArrayList == null) {
                        partnerArrayList = new ArrayList<>();
                    }
                    partnerArrayList.add(partner);
                    calender.put(date, partnerArrayList);
                }
            }

            //2.2 Sort the calender incrementally
            Set<String> strings = calender.keySet();
            List<String> sortedList = new ArrayList<>(strings);
            Collections.sort(sortedList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int date1 = Integer.valueOf(o1.replace("-", ""));
                    int date2 = Integer.valueOf(o2.replace("-", ""));
                    if (date1 > date2)
                        return 1;
                    else return -1;
                }
            });

            //2.3 Find the intersection of two lists, so we can find the partners who are available in a row.
            Map<String, List<Partner>> dayWithPeople = new HashMap<>();
            for (int i = 0; i < sortedList.size() - 1; i++) {
                List<Partner> partners1 = calender.get(sortedList.get(i));
                List<Partner> partners2 = calender.get(sortedList.get(i + 1));
                List<Partner> intersection = new ArrayList<>();
                for (Partner p1 : partners1) {
                    for (Partner p2 : partners2) {
                        if (p1.equals(p2)) {
                            intersection.add(p1);
                        }
                    }
                }
                dayWithPeople.put(sortedList.get(i), intersection);
                System.out.println();
            }

            //2.4 Find the date with max people
            String bestDate = "";
            int min = 20202020;
            int maxPeople = 0;
            for (Map.Entry<String, List<Partner>> entry : dayWithPeople.entrySet()) {
                if (entry.getValue().size() > maxPeople) {
                    maxPeople = entry.getValue().size();
                }
            }

            //2.5 Find the EARLIEST date with max people
            for (Map.Entry<String, List<Partner>> entry : dayWithPeople.entrySet()) {
                if (entry.getValue().size() == maxPeople) {
                    String date = entry.getKey().replace("-", "");
                    if (Integer.valueOf(date) < min) {
                        bestDate = entry.getKey();
                        min = Integer.valueOf(date);

                    }
                }
            }

            //2.6 Add this record into a return list
            List<Partner> selectedPartners = dayWithPeople.get(bestDate);

            Country returnCountry = new Country();

            if (selectedPartners != null) {
                returnCountry.setName(country);
                returnCountry.setAttendeeCount(selectedPartners.size());
                returnCountry.setAttendees(new ArrayList<>());
                for (Partner p : selectedPartners) {
                    returnCountry.getAttendees().add(p.getEmail());
                }
                returnCountry.setStartDate(bestDate);
            } else {
                returnCountry.setName(country);
                returnCountry.setAttendeeCount(0);
                returnCountry.setAttendees(new ArrayList<>());
                returnCountry.setStartDate(null);
            }


            returnList.add(returnCountry);
        }

        //3) Create a return object by taking the returnList
        Countries countries = new Countries();
        countries.setCountries(returnList);
        String returnJson = gson.toJson(countries);
        HttpResponse httpResponse = Unirest.post("https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey=ad14e2cd69c50b48f437bf794ca9")
                .body(returnJson)
                .header("Content-Type", "application/json")
                .asEmpty();

        System.out.println();
    }
}

