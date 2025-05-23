package com.example.myflexiblefragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbAwr, rbUnai, rbGeor, rbArteta;
    private OnOptionDialogListener onOptionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);

        btnChoose = view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);

        btnClose = view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        rgOptions = view.findViewById(R.id.rg_options);
        rbAwr = view.findViewById(R.id.rb_awr);
        rbUnai = view.findViewById(R.id.rb_unai);
        rbGeor = view.findViewById(R.id.rb_geor);
        rbArteta = view.findViewById(R.id.rb_arteta);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btn_close) {
            getDialog().cancel();
        } else if (id == R.id.btn_choose) {
            int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();

            if (checkedRadioButtonId != -1) {
                String coach = null;

                if (checkedRadioButtonId == R.id.rb_awr) {
                    coach = rbAwr.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_unai) {
                    coach = rbUnai.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_geor) {
                    coach = rbGeor.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_arteta) {
                    coach = rbArteta.getText().toString().trim();
                }

                if (onOptionDialogListener != null) {
                    onOptionDialogListener.onOptionChoosen(coach);
                }

                getDialog().cancel();
            }
        }
    }

    public interface OnOptionDialogListener {
        void onOptionChoosen(String text);
    }
}
