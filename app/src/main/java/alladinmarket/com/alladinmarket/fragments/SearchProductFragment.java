package alladinmarket.com.alladinmarket.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.activities.SeacrhProductActivity;
import alladinmarket.com.alladinmarket.adapters.CategoryAdaper;
import alladinmarket.com.alladinmarket.adapters.SearchProductAdaper;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchProductFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchProductFragment extends Fragment implements CategoryAdaper.OnItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private CategoryAdaper mAdapter ;
    private RecyclerView.LayoutManager mLayoutManager;


    public SearchProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchProductFragment newInstance(String param1, String param2) {
        SearchProductFragment fragment = new SearchProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_product, container, false) ;
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_search_product_list);

        mLayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CategoryAdaper(getContext());



        mRecyclerView.setAdapter(mAdapter);
       //  mAdapter.setOnItemClickListener(new CategoryAdaper.OnItemClickListener())
         mAdapter.setOnItemClickListener(new CategoryAdaper.OnItemClickListener() {
             @Override
             public void onItemClick(View itemView, int position) {
                 Intent i = new Intent(getContext(), SeacrhProductActivity.class);
                startActivity(i);
             }
         }) ;

        return view ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(View itemView, int position) {

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
