package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;

    public PrintedFeatures(String title, int numberOfPages, List authors) {

        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Empty title");
        }

        if(Validators.isEmpty(authors) || numberOfPages<1){
            throw new IllegalArgumentException();
        }

        this.authors = new ArrayList<>(authors);
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }

}
