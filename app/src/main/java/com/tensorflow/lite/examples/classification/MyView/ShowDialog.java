package com.tensorflow.lite.examples.classification.MyView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import org.tensorflow.lite.examples.classification.R;


public class ShowDialog extends Dialog {
    public Context context;

    public ShowDialog(Context context) {
        super(context);
        this.context = context;
    }

    public ShowDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public ShowDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(context, R.layout.dialog_item, null);
        setContentView(view);

        setCanceledOnTouchOutside(false);

        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.height = 1000;
        lp.width = 1000;
        win.setAttributes(lp);

        view.findViewById(R.id.btn_cancel).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"tianjiachenggong",Toast.LENGTH_LONG).show();
                dismiss();
            }
        });
    }
}
