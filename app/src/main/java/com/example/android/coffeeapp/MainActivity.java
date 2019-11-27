package com.example.android.coffeeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;

import java.text.Format;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private CheckBox chk1, chk2, chk3;
    private RadioButton rdb1, rdb2, rdb3;
    private Button btn1, btn2, btn3;
    private Spinner boissons;
    private Order anOrder;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button_drink_plus);
        btn2 = (Button) findViewById(R.id.button_order);
        btn3 = (Button) findViewById(R.id.button_cancel);

        chk1 = (CheckBox) findViewById(R.id.checkBox);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        chk3 = (CheckBox) findViewById(R.id.checkBox3);

        rdb1 = (RadioButton) findViewById(R.id.radioButton4);
        rdb2 = (RadioButton) findViewById(R.id.radioButton5);
        rdb3 = (RadioButton) findViewById(R.id.radioButton6);

        anOrder = new Order(0);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdb1.isChecked()) {
                    anOrder.setTypePrice(0.50);
                }
                else if (rdb2.isChecked()) {
                    anOrder.setTypePrice(1);
                }
                else if (rdb3.isChecked()) {
                    anOrder.setTypePrice(1.50);
                }
                double OptionPrice = 0;
                if (chk1.isChecked()) {
                    OptionPrice += 0.30;
                }
                if (chk2.isChecked()) {
                    OptionPrice += 0.30;
                }
                if (chk3.isChecked()) {
                    OptionPrice += 0.30;
                }
                anOrder.setOptionPrice(OptionPrice);
                anOrder.addDrink();
                number = anOrder.getNumberOfDrink();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayPrice(anOrder.orderPrice());
                displayOrder(anOrder.orderResult());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "test bouton", Toast.LENGTH_SHORT).show();
                while (anOrder.getNumberOfDrink() != 0) {

                    if (chk1.isChecked()) {
                        chk1.toggle();
                    }
                    if (chk2.isChecked()) {
                        chk2.toggle();
                    }
                    if (chk3.isChecked()) {
                        chk3.toggle();
                    }

                    if (rdb1.isChecked()) {
                        rdb1.toggle();
                    }
                    if (rdb2.isChecked()) {
                        rdb2.toggle();
                    }

                    if (rdb3.isChecked()) {
                        rdb3.toggle();
                    }
                    anOrder.removeDrink();

                }
                displayPrice(0);
                displayOrder("");
            }
        });
    }

    /*public void selectedType(View view) {

    }*/

    private void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.text_view_result);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayOrder(String s) {
        TextView orderTextView = (TextView) findViewById(R.id.text_view_order);
        orderTextView.setText(anOrder.orderResult());
    }
}

