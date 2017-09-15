package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
                try {
                    ImportantTweet important_tweet = new ImportantTweet("Hello");
                    NormalTweet tweet = new NormalTweet("hi");
                    ArrayList<Tweet> tweets = new ArrayList<Tweet>();
                    tweets.add(important_tweet);
                    tweets.add(tweet);
                    for (Tweet t : tweets) {
                        Log.d("Some Tag", "isImportant returns " + t.isImportant().toString());
                    }

                    ArrayList<Tweetable> tweetables = new ArrayList<Tweetable>();
                    tweetables.add(tweet);
                    tweetables.add(important_tweet);
                }
                catch (TweetTooLongException e) {
                    e.printStackTrace();
                }


                // Lab 2 usage example
                try {
                    NormalTweet sad_tweet = new NormalTweet("I am sad.");
                    sad_tweet.addMood(new SadMood());
                    for (Mood mood : sad_tweet.getMoods()) {
                        Log.d("Mood", mood.format());
                    }
                    NormalTweet happy_tweet = new NormalTweet("I am happy.");
                    happy_tweet.addMood(new HappyMood());
                    happy_tweet.addMood(new HappyMood());
                    for (Mood mood : happy_tweet.getMoods()) {
                        Log.d("Mood", mood.format());
                    }
                }
                catch (TweetTooLongException e) {
                    Log.d("Too long", "Tweet too long.");
                }







				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}