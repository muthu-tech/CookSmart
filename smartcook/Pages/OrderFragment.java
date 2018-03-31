package com.smartcook.smartcook.Pages;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartcook.smartcook.Models.Items;
import com.smartcook.smartcook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    private RecyclerView mOrderRecycler;
    private TextView mDateTextView;
    private TextView mItemTextView;

    private List<Items> mEventList = new ArrayList<>(1);

    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.order_recipie, container, false);

        mOrderRecycler = (RecyclerView)view.findViewById(R.id.Order_Recycler);



        return view;
    }

    public class EventAdapter extends RecyclerView.Adapter<ItemHolder> {

        private List<Items> adapterEvent;

        public EventAdapter(List<Items> events){
            adapterEvent = events;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.order_display_layout, parent, false);
            return new ItemHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(adapterEvent.get(position));
        }

        @Override
        public int getItemCount() {
            return adapterEvent.size();
        }

    }


    public class ItemHolder extends RecyclerView.ViewHolder{

        private Items holderEvent;
        private TextView orderDate;
        private TextView orderItems;

        private View mView;

        public ItemHolder(View itemView) {
            super(itemView);

            mDateTextView = (TextView)itemView.findViewById(R.id.Order_date);
            mItemTextView = (TextView)itemView.findViewById(R.id.Order_Items);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Items item = mEventList.get(getAdapterPosition());

                    //Query Database for recepie
                    //ModelQueryManager.get(getContext().getApplicationContext()).deleteEvent(event.getEventid());

                }
            });

        }

        public void bind(Items event) {
            holderEvent = event;
            mDateTextView.setText(holderEvent.getDatePurchased());
            mItemTextView.setText(holderEvent.getFoodItems());

        }
    }

}
