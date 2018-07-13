package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private List<Feature> features=new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... features) {

        if(Validators.isBlank(registrationNumber) || price<0 || features==null || features.length==0){
            throw new IllegalArgumentException();
        }

        this.features.addAll(Arrays.asList(features));
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<String> getTitles(){

        List<String> titles=new ArrayList<>();

        for(Feature feature:features){
            titles.add(feature.getTitle());
        }

        return titles;
    }

    public List<String> getContributors(){

        List<String> contributors=new ArrayList<>();

        for(Feature feature:features){
            contributors.addAll(feature.getContributors());
        }

        return contributors;
    }

    public boolean hasAudioFeature(){
        return featureCheck(AudioFeatures.class);
    }

    public boolean hasPrintedFeature(){
        return featureCheck(PrintedFeatures.class);
    }

    public int fullLengthAtOneItem(){

        int sum = 0;

        for(Feature feature:features){

            if(feature instanceof AudioFeatures){
                sum+= ((AudioFeatures) feature).getLength();
            }

        }

        return sum;
    }

    public int numberOfPagesAtOneItem(){

        int sum=0;

        for(Feature feature:features){

            if(feature instanceof PrintedFeatures){
                sum+=((PrintedFeatures) feature).getNumberOfPages();
            }

        }

        return sum;
    }

    private boolean featureCheck(Class<?> featureToCheck){

        for(Feature feature:features){

            if(featureToCheck.isAssignableFrom(feature.getClass())){
                return true;
            }

        }

        return false;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria criteria){
        return null;
    }






}
