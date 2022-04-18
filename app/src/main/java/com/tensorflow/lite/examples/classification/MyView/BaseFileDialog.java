package com.tensorflow.lite.examples.classification.MyView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.tensorflow.lite.examples.classification.DataBase.FlowerInfo;

import org.litepal.LitePal;
import org.tensorflow.lite.examples.classification.R;

import java.io.File;
import java.util.ArrayList;

//汇总进行各项处理的dialog
public class BaseFileDialog {

    public static BaseFileDialog newInstance() {

        BaseFileDialog dialog = new BaseFileDialog();
        return dialog;
    }

    public void createBaseDialog(final Context mContext, final int pos,FlowerInfo flowerInfo) {

        ArrayList<String> entrys = new ArrayList<String>();
        entrys.add("删除花朵");


        final CharSequence[] items = entrys.toArray(new CharSequence[entrys.size()]);

        // File delete confirm
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                LitePal.deleteAll(FlowerInfo.class,"type=?and data=?",flowerInfo.getType(),flowerInfo.getData());

                Toast.makeText(builder.getContext(), "success",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setTitle(mContext.getString(R.string.dialog_title_options));
        builder.setCancelable(true);
        builder.setNegativeButton(mContext.getString(R.string.dialog_action_cancel),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }



}
