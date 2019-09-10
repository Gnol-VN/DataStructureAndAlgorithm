package hubspot;

import java.util.List;

/**
 * For mapping the JSON data from the GET api to a Java List containing many elements
 */
public class Partners {
    List<Partner> partners;

    public List<Partner> getPartners() {
        return partners;
    }

    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }
}
