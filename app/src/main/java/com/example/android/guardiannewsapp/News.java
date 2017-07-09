package com.example.android.guardiannewsapp;

/**
 * Creates a News object which has three parts to it:
 * article title, section, and the webUrl
 */

public class News {

    //section name
    private String mSectionName;

    //article title
    private String mArticleName;

    //web URL
    private String mWebUrl;

    /**
     * Constructor a new {@link News} object
     *
     * @param sectionName name of the section
     * @param articleName name of the article
     * @param webUrl      url to actual article
     */
    public News(String sectionName, String articleName, String webUrl) {
        mSectionName = sectionName;
        mArticleName = articleName;
        mWebUrl = webUrl;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getArticleName() {
        return mArticleName;
    }

    public String getWebUrl() {
        return mWebUrl;
    }

}
