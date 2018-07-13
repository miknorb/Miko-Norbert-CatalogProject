package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List performers){

        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Empty title");
        }

        if(Validators.isEmpty(performers) || length<=0){
            throw new IllegalArgumentException();
        }

        this.title=title;
        this.length=length;
        this.performers=new ArrayList<>(performers);
        this.composer=null;
    }

    public AudioFeatures(String title, int length, List performers, List composer){

        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Empty title");
        }

        if(Validators.isEmpty(performers) || Validators.isEmpty(composer) || length<=0){
            throw new IllegalArgumentException();
        }

        this.title=title;
        this.length=length;
        this.performers=new ArrayList<>(performers);
        this.composer=new ArrayList<>(composer);
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {

        List<String> joined=new ArrayList<>();

        if(!Validators.isEmpty(composer)){
            joined.addAll(composer);
        }

        joined.addAll(performers);

        return joined;
    }

}
