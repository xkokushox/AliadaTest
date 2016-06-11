package com.freakybyte.aliadatest.ui.wrapper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.freakybyte.aliadatest.R;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class ItemServiceWrapper extends RecyclerView.ViewHolder {

    public View view = null;

    private TextView txtServiceHour = null;
    private TextView txtServiceDate = null;
    private TextView txtServiceSpecialInstructions = null;
    private TextView txtServiceGarbageInstructions = null;
    private TextView txtServiceEquipmentInstructions = null;
    private TextView txtServiceForbiddenInstructions = null;
    private TextView txtServiceSuppliesInstructions = null;
    private TextView txtServiceAtentionInstructions = null;
    private TextView txtServiceAddress = null;
    private TextView txtServiceUser = null;
    private TextView txtServicePhone = null;
    private TextView txtServiceEmail = null;


    public ItemServiceWrapper(View base) {
        super(base);
        this.view = base;
    }

    public TextView getTxtServiceHour() {
        if (txtServiceHour == null)
            txtServiceHour = (TextView) view.findViewById(R.id.txtServiceHour);
        return txtServiceHour;
    }

    public TextView getTxtServiceDate() {
        if (txtServiceDate == null)
            txtServiceDate = (TextView) view.findViewById(R.id.txtServiceDate);
        return txtServiceDate;
    }

    public TextView getTxtServiceSpecialInstructions() {
        if (txtServiceSpecialInstructions == null)
            txtServiceSpecialInstructions = (TextView) view.findViewById(R.id.txtServiceSpecialInstructions);
        return txtServiceSpecialInstructions;
    }

    public TextView getTxtServiceGarbageInstructions() {
        if (txtServiceGarbageInstructions == null)
            txtServiceGarbageInstructions = (TextView) view.findViewById(R.id.txtServiceGarbageInstructions);
        return txtServiceGarbageInstructions;
    }

    public TextView getTxtServiceEquipmentInstructions() {
        if (txtServiceEquipmentInstructions == null)
            txtServiceEquipmentInstructions = (TextView) view.findViewById(R.id.txtServiceEquipmentInstructions);
        return txtServiceEquipmentInstructions;
    }

    public TextView getTxtServiceForbiddenInstructions() {
        if (txtServiceForbiddenInstructions == null)
            txtServiceForbiddenInstructions = (TextView) view.findViewById(R.id.txtServiceForbiddenInstructions);
        return txtServiceForbiddenInstructions;
    }

    public TextView getTxtServiceSuppliesInstructions() {
        if (txtServiceSuppliesInstructions == null)
            txtServiceSuppliesInstructions = (TextView) view.findViewById(R.id.txtServiceSuppliesInstructions);
        return txtServiceSuppliesInstructions;
    }

    public TextView getTxtServiceAtentionInstructions() {
        if (txtServiceAtentionInstructions == null)
            txtServiceAtentionInstructions = (TextView) view.findViewById(R.id.txtServiceAtentionInstructions);
        return txtServiceAtentionInstructions;
    }

    public TextView getTxtServiceAddress() {
        if (txtServiceAddress == null)
            txtServiceAddress = (TextView) view.findViewById(R.id.txtServiceAddress);
        return txtServiceAddress;
    }

    public TextView getTxtServiceUser() {
        if (txtServiceUser == null)
            txtServiceUser = (TextView) view.findViewById(R.id.txtServiceUser);
        return txtServiceUser;
    }

    public TextView getTxtServicePhone() {
        if (txtServicePhone == null)
            txtServicePhone = (TextView) view.findViewById(R.id.txtServicePhone);
        return txtServicePhone;
    }
    public TextView getTxtServiceEmail() {
        if (txtServiceEmail == null)
            txtServiceEmail = (TextView) view.findViewById(R.id.txtServiceEmail);
        return txtServiceEmail;
    }
}
