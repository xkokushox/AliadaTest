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
    public void onBindViewHolder(final ItemServiceWrapper viewHolder, final int position) {
        final ServiceItemModel mService = getListServices().get(position);

        if (AliadaUtil.isInValiedField(mService.getEstimatedHours()))
            viewHolder.getTxtServiceHour().setVisibility(View.GONE);
        else {
            viewHolder.getTxtServiceHour().setVisibility(View.VISIBLE);
            viewHolder.getTxtServiceHour().setText(String.format(mActivity.getString(R.string.txt_service_item_hours), mService.getEstimatedHours()));
        }

        viewHolder.getTxtServiceDate().setText(String.format(mActivity.getString(R.string.txt_service_item_special_date), AliadaUtil.getDateFromString(mService.getDatetime()),
                AliadaUtil.getDateFromString(mService.getEndingDatetime())));

        if (AliadaUtil.isInValiedField(mService.getSpecialInstructions()))
            viewHolder.getTxtServiceSpecialInstructions().setVisibility(View.GONE);
        else {
            viewHolder.getTxtServiceSpecialInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_special_instructions), mService.getSpecialInstructions()));
            viewHolder.getTxtServiceSpecialInstructions().setVisibility(View.VISIBLE);
        }

        if (AliadaUtil.isInValiedField(mService.getGarbageInstructions()))
            viewHolder.getTxtServiceGarbageInstructions().setVisibility(View.GONE);
        else {
            viewHolder.getTxtServiceGarbageInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_garbage_instructions), mService.getGarbageInstructions()));
            viewHolder.getTxtServiceGarbageInstructions().setVisibility(View.VISIBLE);
        }

        if (AliadaUtil.isInValiedField(mService.getEquipmentInstructions()))
            viewHolder.getTxtServiceEquipmentInstructions().setVisibility(View.GONE);
        else {
            viewHolder.getTxtServiceEquipmentInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_equipment_instructions), mService.getEquipmentInstructions()));
            viewHolder.getTxtServiceEquipmentInstructions().setVisibility(View.VISIBLE);
        }

        if (AliadaUtil.isInValiedField(mService.getForbiddenInstructions()))
            viewHolder.getTxtServiceForbiddenInstructions().setVisibility(View.GONE);
        else {
            viewHolder.getTxtServiceForbiddenInstructions().setVisibility(View.VISIBLE);
            viewHolder.getTxtServiceForbiddenInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_forbidden_instructions), mService.getForbiddenInstructions()));
        }

        if (AliadaUtil.isInValiedField(mService.getCleaningSuppliesInstructions()))
            viewHolder.getTxtServiceSuppliesInstructions().setVisibility(View.GONE);
        else {
            viewHolder.getTxtServiceSuppliesInstructions().setVisibility(View.VISIBLE);
            viewHolder.getTxtServiceSuppliesInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_cleaning_supplies_instructions), mService.getCleaningSuppliesInstructions()));
        }

        if (AliadaUtil.isInValiedField(mService.getAttentionInstructions()))
            viewHolder.getTxtServiceAtentionInstructions().setVisibility(View.GONE);
        else {
            viewHolder.getTxtServiceAtentionInstructions().setVisibility(View.VISIBLE);
            viewHolder.getTxtServiceAtentionInstructions().setText(String.format(mActivity.getString(R.string.txt_service_item_attention_instructions), mService.getAttentionInstructions()));
        }

        viewHolder.getTxtServiceAddress().setText(String.format(mActivity.getString(R.string.txt_service_item_direction), mService.getAddress().getStreet(), mService.getAddress().getNumber()
                , mService.getAddress().getInteriorNumber(), mService.getAddress().getCity(), mService.getAddress().getColony(), mService.getAddress().getPostalCode().getNumber()));


        viewHolder.getTxtServiceUser().setText(String.format(mActivity.getString(R.string.txt_service_item_user_name), mService.getUser().getFullName()));
        viewHolder.getTxtServicePhone().setText(String.format(mActivity.getString(R.string.txt_service_item_user_phone), mService.getUser().getPhone()));
        viewHolder.getTxtServiceEmail().setText(String.format(mActivity.getString(R.string.txt_service_item_user_email), mService.getUser().getEmail()));
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
