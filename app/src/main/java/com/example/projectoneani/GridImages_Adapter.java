package com.example.projectoneani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class GridImages_Adapter extends BaseAdapter {

    private List<GridImages_Class> gridImages_list ;
    private Context con;
    private LayoutInflater layout_inf;

    public GridImages_Adapter(List<GridImages_Class> gridImages_list, Context con) {
        this.gridImages_list = gridImages_list;
        this.con = con;
        this.layout_inf = (LayoutInflater) con.getSystemService(LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return gridImages_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = layout_inf.inflate(R.layout.grid_items, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.item_grid_image);

        Glide.with(con)
                .load(gridImages_list.get(position).getPreviewURL())
                .into(image);


        return convertView;

    }
}

