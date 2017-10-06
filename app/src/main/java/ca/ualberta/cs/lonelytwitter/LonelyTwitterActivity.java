package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<NormalTweet> tweetList = new ArrayList<NormalTweet>();
	private ArrayAdapter<NormalTweet> adapter;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				NormalTweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

                ElasticsearchTweetController.AddTweetsTask task =
                        new ElasticsearchTweetController.AddTweetsTask();
                task.execute(newTweet);
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();

                String text = bodyText.getText().toString();
                ElasticsearchTweetController.GetTweetsTask task
                        = new ElasticsearchTweetController.GetTweetsTask();
                task.execute(text);
                try {

                } catch (Exception e) { // Should make exception more specific
                    Log.i("Error", "Failed to get tweets from " +
                            "ElasticSearchTweetController");
                }
				adapter.notifyDataSetChanged();
			}
		});


	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		ElasticsearchTweetController.GetTweetsTask task =
                new ElasticsearchTweetController.GetTweetsTask();
        task.execute("");

        try {
            tweetList = task.get();
        } catch (Exception e) { // Should make exception more specific
            Log.i("Error", "Failed to get tweets from GetTweetsTask object");
        }

		adapter = new ArrayAdapter<NormalTweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}
}