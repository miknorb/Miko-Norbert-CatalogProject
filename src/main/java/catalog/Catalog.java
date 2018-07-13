package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems=new ArrayList<>();

    public void addItem(CatalogItem item){

        if(item==null){
            throw new IllegalArgumentException();
        }

        catalogItems.add(item);
    }

    public double averagePageNumberOver(int limit){

        if(limit<1){
            throw new IllegalArgumentException("Page number must be positive");
        }

        int count=0;
        double amount=0;

        for(CatalogItem item:catalogItems){

            if(item.hasPrintedFeature() && item.numberOfPagesAtOneItem()>limit){
                count++;
                amount+=item.numberOfPagesAtOneItem();
            }

        }

        if(count==0){
            throw new IllegalArgumentException("No pages");
        }

        return amount/count;

    }

    public void deleteItemByRegistrationNumber(String regNumber){

        if(Validators.isBlank(regNumber)){
            throw new IllegalArgumentException();
        }

        for(CatalogItem item : catalogItems){

            if(item.getRegistrationNumber().equals(regNumber)){
                catalogItems.remove(item);
                return;
            }

        }
    }

    public int getAllPageNumber(){

        int sum=0;

        for(CatalogItem item : catalogItems){
            sum+=item.numberOfPagesAtOneItem();
        }

        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems(){

        List<CatalogItem> audioItems=new ArrayList<>();

        for(CatalogItem item : catalogItems){
            if(item.hasAudioFeature()){
                audioItems.add(item);
            }
        }

        return audioItems;
    }

    public int getFullLength(){

        int sum=0;

        for(CatalogItem item:catalogItems){

            if(item.hasAudioFeature()){
                sum+=item.fullLengthAtOneItem();
            }

        }

        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems(){

        List<CatalogItem> printedItems=new ArrayList<>();

        for(CatalogItem item : catalogItems){

            if(item.hasPrintedFeature()){
                printedItems.add(item);
            }

        }

        return printedItems;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria criteria){

        if(criteria==null){
            throw new IllegalArgumentException();
        }

        List<CatalogItem> foundItems=new ArrayList<>();

        for(CatalogItem item:catalogItems){
                matcher(item,criteria,foundItems);
        }

        return foundItems;
    }

    private void matcher(CatalogItem item, SearchCriteria criteria,List<CatalogItem> target){

        if(criteria.hasContributor() && criteria.hasTitle() &&
           item.getTitles().contains(criteria.getTitle()) &&
           item.getContributors().contains(criteria.getContributor())){
            target.add(item);
            return;
        }

        if (criteria.hasTitle() && item.getTitles().contains(criteria.getTitle())) {
            target.add(item);
            return;
        }

        if(criteria.hasContributor() && item.getContributors().contains(criteria.getContributor())){
            target.add(item);
            return;
        }
    }

}

