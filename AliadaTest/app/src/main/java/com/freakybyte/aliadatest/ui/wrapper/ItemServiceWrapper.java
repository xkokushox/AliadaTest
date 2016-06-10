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


    public ItemServiceWrapper(View base) {
        super(base);
        this.view = base;
    }

    public TextView getTxtServiceHour() {
        if (txtServiceHour == null)
            txtServiceHour = (TextView) view.findViewById(R.id.txtServiceHour);
        return txtServiceHour;
    }
}
