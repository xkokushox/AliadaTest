package com.freakybyte.aliadatest.controller.services.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.model.services.ServiceItemModel;
import com.freakybyte.aliadatest.ui.wrapper.ItemServiceWrapper;

import java.util.ArrayList;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class ServiceListAdapter extends RecyclerView.Adapter<ItemServiceWrapper> {

    public static final String TAG = "ServiceListAdapter";
    private ArrayList<ServiceItemModel> mListServices = new ArrayList<>();
    private Activity mActivity;

    /**
     * @param context
     */
    public ServiceListAdapter(Activity context) {
        this.mActivity = context;
    }

    @Override
    public ItemServiceWrapper onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_services, parent, false);
        ItemServiceWrapper vh = new ItemServiceWrapper(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemServiceWrapper viewHolder, final int position) {
        final ServiceItemModel mService = getListServices().get(position);

    }


    @Override
    public int getItemCount() {
        return mListServices.size();
    }

    public ArrayList<ServiceItemModel> getListServices() {
        return mListServices;
    }

    public void setListServoces(ArrayList<ServiceItemModel> listServices) {
        this.mListServices = listServices;
    }
}
