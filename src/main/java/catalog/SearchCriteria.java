package catalog;

public class SearchCriteria {

    private String contributor;
    private String title;

    private SearchCriteria(String title, String contributor){
        this.contributor=contributor;
        this.title=title;
    }

    public static SearchCriteria createByContributor(String contributor){

        if(Validators.isBlank(contributor)){
            throw new IllegalArgumentException();
        }

        return new SearchCriteria("",contributor);
    }

    public static SearchCriteria createByTitle(String title){

        if(Validators.isBlank(title)){
            throw new IllegalArgumentException();
        }

        return new SearchCriteria(title,"");
    }

    public static  SearchCriteria createByBoth(String title,String contributor){

        if(Validators.isBlank(contributor) || Validators.isBlank(title)){
            throw new IllegalArgumentException();
        }

        return new SearchCriteria(title,contributor);

    }

    public boolean hasContributor(){
        return !Validators.isBlank(contributor);
    }

    public boolean hasTitle(){
        return !Validators.isBlank(title);
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
