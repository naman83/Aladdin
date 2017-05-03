package alladinmarket.com.alladinmarket.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import alladinmarket.com.alladinmarket.R;

/**
 * Created by nmn on 16/4/17.
 */

public class SearchShopkeeperAdaper extends RecyclerView.Adapter<SearchShopkeeperAdaper.ViewHolder> {
private String[] mDataset;


    private CategoryAdaper.OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener


    public void setOnItemClickListener(CategoryAdaper.OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_shopkeepr_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



    }

    // Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public  class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView shopKeeperName;
        public TextView featuredCategory;
        public TextView address;
        public ImageView mapView ;
          public ViewHolder(View v) {
        super(v);
        shopKeeperName = (TextView)v.findViewById(R.id.tv_featured_category);
        featuredCategory = (TextView)v.findViewById(R.id.tv_seller_name);
        address = (TextView)v.findViewById(R.id.tv_address);
        mapView = (ImageView)v.findViewById(R.id.iv_map);

              v.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if (listener != null) {
                          int position = getAdapterPosition();
                          if (position != RecyclerView.NO_POSITION) {
                              listener.onItemClick(itemView, position);
                          }
                      }
                  }
              });
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)

    // Create new views (invoked by the layout manager)
    // Replace the contents of a view (invoked by the layout manager)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 10;
    }
}