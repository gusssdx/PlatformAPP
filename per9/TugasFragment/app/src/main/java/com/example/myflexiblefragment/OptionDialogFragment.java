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
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9;
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
        rb1 = view.findViewById(R.id.rb_1);
        rb2 = view.findViewById(R.id.rb_2);
        rb3 = view.findViewById(R.id.rb_3);
        rb4 = view.findViewById(R.id.rb_4);
        rb5 = view.findViewById(R.id.rb_5);
        rb6 = view.findViewById(R.id.rb_6);
        rb7 = view.findViewById(R.id.rb_7);
        rb8 = view.findViewById(R.id.rb_8);
        rb9 = view.findViewById(R.id.rb_9);

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

                if (checkedRadioButtonId == R.id.rb_1) {
                    coach = rb1.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_2) {
                    coach = rb2.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_3) {
                    coach = rb3.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_4) {
                    coach = rb4.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_5) {
                    coach = rb5.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_6) {
                    coach = rb6.getText().toString().trim();
                }else if (checkedRadioButtonId == R.id.rb_7) {
                    coach = rb7.getText().toString().trim();
                }else if (checkedRadioButtonId == R.id.rb_8) {
                    coach = rb8.getText().toString().trim();
                }else if (checkedRadioButtonId == R.id.rb_9) {
                    coach = rb9.getText().toString().trim();
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
