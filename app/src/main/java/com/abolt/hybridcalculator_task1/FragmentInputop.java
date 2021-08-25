package com.abolt.hybridcalculator_task1;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class FragmentInputop extends Fragment {
    private Fragment_inputListener listener;
    private EditText input;
    private Button n0;
    private Button n1;
    private Button n2;
    private Button n3;
    private Button n4;
    private Button n5;
    private Button n6;
    private Button n7;
    private Button n8;
    private Button n9;
    private Button sign;
    private Button decimal;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button equal;
    private Button back;
    public String input_var;
    private int operation, color, error;
    public double a, output;

    public interface Fragment_inputListener {
        void onInputSent(double a, String s);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inputop, container, false);
        a = 0; output = 0;operation = 0;input_var = "";color = 0;error = 0;
        input = v.findViewById(R.id.input);
        add = v.findViewById(R.id.add);
        subtract = v.findViewById(R.id.subtract);
        multiply = v.findViewById(R.id.multiplication);
        divide = v.findViewById(R.id.division);
        equal = v.findViewById(R.id.equality);
        n0 = v.findViewById(R.id.n0);
        n1 = v.findViewById(R.id.n1);
        n2 = v.findViewById(R.id.n2);
        n3 = v.findViewById(R.id.n3);
        n4 = v.findViewById(R.id.n4);
        n5 = v.findViewById(R.id.n5);
        n6 = v.findViewById(R.id.n6);
        n7 = v.findViewById(R.id.n7);
        n8 = v.findViewById(R.id.n8);
        n9 = v.findViewById(R.id.n9);
        sign = v.findViewById(R.id.sign);
        decimal = v.findViewById(R.id.decimal);
        back = v.findViewById(R.id.erased);
        input.setText("");
        input.setShowSoftInputOnFocus(false);

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "0");
            }
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "1");
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "2");
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "3");
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "4");
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "5");
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "6");
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "7");
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "8");
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "9");
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("-" + input.getText().toString());
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color == 0) {
                    input.setText(input.getText().toString() + ".");
                    decimal.setBackground(null); color = 1;
                }
                else{
                    Toast.makeText(getContext(), "Not more than 1 decimal point", Toast.LENGTH_SHORT).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = input.getText().toString();

                if(s.matches("")){
                    color = 0;
                }
                else {
                    if(s.indexOf('.') == -1){
                        color = 0;
                    }
                    input.setText(s.substring(0, s.length() - 1));
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().matches("")){
                    ;
                }
                else{
                    a = Float.parseFloat(input.getText().toString());
                    if(operation == 0) {
                        output = a;
                        operation = 1;
                        input_var = "";
                    }
                    else{
                        calculate_output();
                    }

                    if( a == (long) a) {
                        input_var += (long) a + " + ";
                    }
                    else{
                        input_var += a + " + ";
                    }
                    input.setText("");
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().matches("")){
                    ;
                }
                else {
                    a = Float.parseFloat(input.getText().toString());
                    if (operation == 0) {
                        input_var = "";
                        output = a;
                        operation = 2;
                    }
                    else {
                        calculate_output();
                    }
                    if( a == (long) a) {
                        input_var += (long) a + " - ";
                    }
                    else{
                        input_var += a + " - ";
                    }
                    input.setText("");
                    operation = 2;
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().matches("")){
                    ;
                }
                else {
                    a = Float.parseFloat(input.getText().toString());
                    if(operation == 0) {
                        input_var = "";
                        output = a;
                        operation = 3;
                    }
                    else{
                        calculate_output();
                    }

                    if( a == (long) a) {
                        input_var += (long) a + " * ";
                    }
                    else{
                        input_var +=  a + " * ";
                    }
                    input.setText("");
                    operation = 3;

                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().matches("")){
                    ;
                }
                else {
                    a = Float.parseFloat(input.getText().toString());
                    if(operation == 0) {
                        output = a;
                        input_var = "";
                        operation = 4;
                    }
                    else{
                        calculate_output();
                    }
                        if( a == (long) a) {
                            input_var +=(long) a + " / ";
                        }
                        else{
                            input_var += a + " / ";
                        }
                        operation = 4;
                        input.setText("");

                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().matches("")){
                    ;
                }
                else{
                    a = Float.parseFloat(input.getText().toString());
                    if(operation == 0){
                        output = a;
                        input_var = "" ;
                    }
                    if(operation == 1){
                        output += a;
                    }
                    if(operation == 2){
                        output -= a;
                    }
                    if(operation == 3){
                        output *= a;
                    }
                    if(operation == 4){
                        if(a == 0){
                            listener.onInputSent(0, "Divide by zero error");
                        }
                        else {
                            output /= a;
                        }
                    }

                    if( a == (long) a) {
                        input_var +=(long) a;
                    }
                    else{
                        input_var += a ;
                    }

                    input.setText("");
                    a = 0;
                    operation = 0;
                    listener.onInputSent(output,input_var); output = 0; input_var = "";
                }
            }
        });

        return  v;
    }

    public void updateNumber(double a){
        input.setText("" + a);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Fragment_inputListener){
            listener = (Fragment_inputListener) context;
        }
        else{
            throw new RuntimeException(context.toString() + "has not implemented Fragment_input interface");
        }
    }

    private void calculate_output(){
        if(operation == 1){
            output += a;
        }
        if(operation == 2){
            output -= a;
        }
        if(operation == 3){
            output *= a;
        }
        if(operation == 4){
            if(a == 0){
                listener.onInputSent(0, "Divide by zero error");
            }
            else {
                output /= a;
            }
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
