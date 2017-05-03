package alladinmarket.com.alladinmarket.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.adapters.OrdersAdaper;
import alladinmarket.com.alladinmarket.adapters.SearchProductAdaper;
import alladinmarket.com.alladinmarket.adapters.SearchShopkeeperAdaper;
import alladinmarket.com.alladinmarket.adapters.TrendsAdapter;

/**
 * Created by nmn on 3/4/17.
 */

public class OrdersFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private OrdersAdaper mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);
        // Set title bar
        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_orders);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new OrdersAdaper();
        mRecyclerView.setAdapter(mAdapter);




        return v;
    }
}
