package com.example.android.guardiannewsapp;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

/**
 * Loads a list of news over network request
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<News> newsArticles = QueryUtils.fetchNewsData(mUrl);
        return newsArticles;
    }

}
