package theoneandonly.com.thequotebook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Quotebook extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The first line (setContentView) sets the app page (Activity) to be the layout we created
        //  earlier, essentially loading the main Quote screen.
        setContentView(R.layout.activity_quotebook);

/*        This part wasn't in the tutorial
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
          End non-tutorial part*/

        //The other lines just find the Textviews in the activity layout and declare them as an
        //  Object so we can change the text in them
        RelativeLayout touch = (RelativeLayout) findViewById(R.id.touch);
        final TextView quoteText = (TextView) findViewById(R.id.quote);
        final TextView personText = (TextView) findViewById(R.id.person);

        //The first line here creates an Array/List that we can add as many quotes as we like to,
        //  note how the List is called ‘quoteList’.
        final ArrayList<Quote> quoteList = new ArrayList<Quote>();


        /*The next 4 lines are where the Quote class we created earlier are coming in to play.
            What we are doing here is passing a quote and a person’s name (separated by a
            comma) through to the Quote class and it becomes a variable, we then add that
            Variable to the quoteList.
        You can add as many quotes by just adding an extra value to the variable name
            (quote7) add then adding it to the quote list.*/

        Quote quote1 = new Quote("Cool Beans", "Rod Kimble");
        quoteList.add(quote1);

        Quote quote2 = new Quote("How can mirrors be real if our eyes aren't real",
                "Jaden Smith");
        quoteList.add(quote2);

        Quote quote3 = new Quote("That's like me blaming owls for how bad I suck at analogies.",
                "Britta Perry");
                quoteList.add(quote3);

        Quote quote4 = new Quote("You're more of a fun vampire. You don't suck blood, you just" +
                " suck.",
                "Troy Barnes");
        quoteList.add(quote4);

        Quote quote5 = new Quote("I was gonna be the first person in my family to graduate from "+
                "community college. Everyone else graduated from normal college", "Troy Barnes");
        quoteList.add(quote5);

        /*Basically: If every quote has been cycled through, set the count to 0 so it starts again.
            Or: If we have not gone through every quote, get the Quote variable in the quoteList at
            the count we are up to, then set the text on the quote and person textboxes to the
            quote data we just grabbed**/
        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count < quoteList.size()) {

                    Quote q = quoteList.get(count);
                    quoteText.setText(q.getQuote());
                    personText.setText(q.getPerson());

                    count = count + 1;

                } else {

                    count = 0;

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quotebook, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
