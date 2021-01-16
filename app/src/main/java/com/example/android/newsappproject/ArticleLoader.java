package com.example.android.newsappproject;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of articles
 */
public class ArticleLoader extends AsyncTaskLoader<List<article>> {

    /** Tag for log messages */
    private static final String LOG_TAG = ArticleLoader.class.getName();

    /** Query URL */
    private String mArticleUrl;

    /**
     * Constructs a new {@link ArticleLoader}.
     *
     * @param context of the activity
     * @param ArticleUrl to load data from
     */
    public ArticleLoader(Context context, String ArticleUrl) {
        super(context);
        mArticleUrl = ArticleUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<article> loadInBackground() {
        if (mArticleUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of articles
        List<article> articles = QueryUtils.fetchArticleData(mArticleUrl);
        return articles;
    }
}