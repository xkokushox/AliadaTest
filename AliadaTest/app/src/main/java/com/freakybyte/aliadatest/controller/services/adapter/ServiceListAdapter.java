package com.freakybyte.aliadatest.controller.services.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freakybyte.aliadatest.R;
import com.freakybyte.aliadatest.model.services.ServiceItemModel;
import com.freakybyte.aliadatest.ui.wrapper.ItemServiceWrapper;
import com.freakybyte.aliadatest.util.AliadaUtil;

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

        viewHolder.getTxtServiceHour().setText(String.format(mActivity.getString(R.string.txt_service_item_hours), mService.getEstimatedHours()));
        viewHolder.getTxtServiceDate().setText(String.format(mActivity.getString(R.string.txt_service_item_special_date), AliadaUtil.getDateFromString(mService.getDatetime()),
                AliadaUtil.getDateFromString(mService.getEndingDatetime())));
        viewHolder.getTxtServiceSpecialInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_special_instructions), mService.getSpecialInstructions()));
        viewHolder.getTxtServiceGarbageInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_garbage_instructions), mService.getGarbageInstructions()));
        viewHolder.getTxtServiceEquipmentInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_equipment_instructions), mService.getEquipmentInstructions()));
        viewHolder.getTxtServiceForbiddenInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_forbidden_instructions), mService.getForbiddenInstructions()));
        viewHolder.getTxtServiceSuppliesInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_cleaning_supplies_instructions), mService.getCleaningSuppliesInstructions()));
        viewHolder.getTxtServiceAtentionInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_attention_instructions), mService.getAttentionInstructions()));

        viewHolder.getTxtServiceAddress().setText(String.format(mActivity.getString(R.string.txt_service_item_direction), mService.getAddress().getStreet(), mService.getAddress().getNumber()
                , mService.getAddress().getInteriorNumber(), mService.getAddress().getColony(), mService.getAddress().getCity(), mService.getAddress().getPostalCode().getNumber()));


        viewHolder.getTxtServiceUser().setText(String.format(mActivity.getString(R.string.txt_service_item_user_name), mService.getUser().getFullName()));
        viewHolder.getTxtServicePhone().setText(String.format(mActivity.getString(R.string.txt_service_item_user_phone), mService.getUser().getPhone()));

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
