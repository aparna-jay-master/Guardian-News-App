package com.example.android.guardiannewsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * {@link NewsAdapter} knows how to create list layout for {@link News} object
 */

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs new {@link NewsAdapter}
     *
     * @param context of the app
     * @param news    list of news articles
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays news
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check is there is existing view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_view, parent, false);
        }

        //Find news for current position
        News currentNewsArticle = getItem(position);

        //Find and display section view for title
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_text_view);
        sectionView.setText(currentNewsArticle.getSectionName());

        //Set the proper background color for text block
        int sectionColor = getSectionColor(currentNewsArticle.getSectionName());
        sectionView.setBackgroundColor(sectionColor);

        //Find and display article title
        TextView titleView = (TextView) listItemView.findViewById(R.id.article_name_text_view);
        titleView.setText(currentNewsArticle.getArticleName());

        return listItemView;
    }

    private int getSectionColor(String section) {
        int sectionColorResourceId;
        switch (section) {
            case "Politics":
                sectionColorResourceId = R.color.politicsColor;
                break;
            case "Education":
                sectionColorResourceId = R.color.educationColor;
                break;
            case "UK news":
                sectionColorResourceId = R.color.UKNewsColor;
                break;
            case "Environment":
                sectionColorResourceId = R.color.environmentColor;
                break;
            case "Opinion":
                sectionColorResourceId = R.color.opinionColor;
                break;
            case "Sport":
                sectionColorResourceId = R.color.sportColor;
                break;
            case "Law":
                sectionColorResourceId = R.color.lawColor;
                break;
            case "News":
                sectionColorResourceId = R.color.newsColor;
                break;
            case "Science":
                sectionColorResourceId = R.color.scienceColor;
                break;
            case "Society":
                sectionColorResourceId = R.color.societyColor;
                break;
            case "Australia news":
                sectionColorResourceId = R.color.ausiNewsColor;
                break;
            case "Music":
                sectionColorResourceId = R.color.musicColor;
                break;
            case "Art and design":
                sectionColorResourceId = R.color.artsColor;
                break;
            case "World news":
                sectionColorResourceId = R.color.worldColor;
                break;
            case "Stage":
                sectionColorResourceId = R.color.stageColor;
                break;
            case "Technology":
                sectionColorResourceId = R.color.techColor;
                break;
            default:
                sectionColorResourceId = R.color.defaultColor;
                break;
        }

        return ContextCompat.getColor(getContext(), sectionColorResourceId);
    }
}
