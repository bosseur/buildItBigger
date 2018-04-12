package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
  private static JokeApi myApiService = null;
  private Context context;
  private JokeListener mJokeListener;

  public EndpointsAsyncTask(JokeListener jokeListener) {
    this.mJokeListener = jokeListener;
  }

  @Override
  protected String doInBackground(Context... params) {
    context = params[0];

    if(myApiService == null) {  // Only do this once
      JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
          new AndroidJsonFactory(), null)
          // options for running against local devappserver
          // - 10.0.2.2 is localhost's IP address in Android emulator
          // - turn off compression when running against local devappserver
          .setRootUrl(context.getString(R.string.server_url))
          .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws
                IOException {
              abstractGoogleClientRequest.setDisableGZipContent(true);
            }
          });
      // end options for devappserver

      myApiService = builder.build();
    }

    try {
      return myApiService.tellJoke().execute().getJoke();
    } catch (Exception e) {
      return null;
    }
  }


  @Override
  protected void onPostExecute(String joke) {
    if(mJokeListener!=null){
      mJokeListener.tellJoke(joke);
    }
  }
}
