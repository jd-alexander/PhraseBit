package com.phrase.bit.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.phrase.bit.R;
import com.phrase.bit.ui.viewmodels.PhraseViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Joel on 5/4/2016.
 * Adapter that generates each view of the list view based on the phrase that's
 * provided.
 */
public class PhraseAdapter extends BaseAdapter {

    private List<PhraseViewModel> phrases;
    private Context context;

    public PhraseAdapter(Context context, List<PhraseViewModel> phrases) {
        this.phrases = phrases;
        this.context = context;
    }

    @Override
    public int getCount() {
        return phrases.size();
    }

    @Override
    public PhraseViewModel getItem(int position) {
        return phrases.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final PhraseViewModel item = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.phrase_row, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.phrase.setText(item.getPhrase());
        return convertView;
    }


    /*Utilizing the view holder pattern so that list cells/items can be recycled.
    *
    */
    static class ViewHolder {
        @BindView(R.id.phrase)
        TextView phrase;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
