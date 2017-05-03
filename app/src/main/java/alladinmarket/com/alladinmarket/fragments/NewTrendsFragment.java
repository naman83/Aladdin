package alladinmarket.com.alladinmarket.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.activities.ProductDetailActivity;
import alladinmarket.com.alladinmarket.activities.SeacrhProductActivity;
import alladinmarket.com.alladinmarket.adapters.CategoryAdaper;
import alladinmarket.com.alladinmarket.adapters.TrendsAdapter;

/**
 * Created by nmn on 3/4/17.
 */

public class NewTrendsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TrendsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_trends, container, false);
        // Set title bar

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_search_trends_list);

        mLayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new TrendsAdapter();
        mAdapter.setOnItemClickListener(new TrendsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent i = new Intent(getContext(), ProductDetailActivity.class);
                startActivity(i);
            }
        });


        mRecyclerView.setAdapter(mAdapter);




        return v;
    }
}
