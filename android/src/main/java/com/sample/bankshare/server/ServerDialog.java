package com.sample.bankshare.server;

import android.app.ProgressDialog;
import android.content.Context;


/**
 * Created by jeonghan on 9. 30..
 */
public class ServerDialog {
    private Context mContext;
    private ProgressDialog dialog;
    public ServerDialog(Context context){
        mContext = context;
    }

    public void show(){
        dialog = ProgressDialog.show(mContext,"","");
    }

    public void dismiss(){
        if (dialog.isShowing())
            dialog.dismiss();
    }
}
