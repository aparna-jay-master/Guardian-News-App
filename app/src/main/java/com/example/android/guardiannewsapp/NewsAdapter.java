package com.example.android.guardiannewsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
     * @param context of the app
     * @param news list of news articles
     */
    public NewsAdapter (Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays news
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

        //Find and display article title
        TextView titleView = (TextView) listItemView.findViewById(R.id.article_name_text_view);
        titleView.setText(currentNewsArticle.getArticleName());

        return listItemView;

    }
}
