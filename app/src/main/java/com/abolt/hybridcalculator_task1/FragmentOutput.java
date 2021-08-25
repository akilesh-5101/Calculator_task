package com.abolt.hybridcalculator_task1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOutput extends Fragment {
    public TextView input;
    public TextView numbers;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_output, container, false);
        input = v.findViewById(R.id.output);
        input.setText("");
        numbers = v.findViewById(R.id.string);
        return  v;
    }
    public void updateText(Double b, String s) {
        if (s.matches("Divide by zero error")) {
            input.setText(s);
        } else {
            if (b - Math.floor(b) == 0) {
                input.setText("Output: " + (long) Math.floor(b));
            } else {
                input.setText("Output: " + b);
            }
            numbers.setText(s);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if(context instanceof Fragment_outputListener){
//            listener = (Fragment_outputListener) context;
//        }
//        else{
//            throw new RuntimeException(context.toString() + "has not implemented Fragment_output interface");
//        }
//    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
