package alladinmarket.com.alladinmarket.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.adapters.CartAdaper;
import alladinmarket.com.alladinmarket.adapters.MarketAdaper;

public class CartActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_cart_items);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CartAdaper();
        mRecyclerView.setAdapter(mAdapter);
    }
}
