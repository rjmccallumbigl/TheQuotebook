package theoneandonly.com.thequotebook;

/**
 * Created by rmccal14 on 6/8/2017.
 */

public class Quote {

    public String quote;

    public String person;

    public Quote(String mQuote, String mPerson){

        super();

        quote = mQuote;

        person = mPerson;

    }

    public String getPerson() {

        return person;

    }

    public String getQuote() {

        return quote;

    }

}
