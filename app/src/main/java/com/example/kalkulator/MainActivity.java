package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double w = 0;
    String op;
    boolean isOP = false;
    boolean isDot = false;
    boolean is0 = true;
    boolean wasEq = false;
    String label;
    double tempEq;


    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {

        final TextView textView = findViewById(R.id.wynik);

        Kalkulator kalkulator = new Kalkulator();
        double temp;
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (button.getId() == R.id.btnC) {
            textView.setText("");
            w = 0;
            isDot = false;
            isOP = false;
            op = "";
            wasEq = false;
            is0 = true;   //nie można nastepne 0
        } else if (button.getId() == R.id.btnPlus) {
            if (wasEq==true){    //gdy odtatnie było "rowna sie" to nalezy wyzerowac istniejacy operator
                isOP=false;
                wasEq=false;
            }
            temp = Double.valueOf(textView.getText().toString());
            if (isOP == true) {
                double w2 = kalkulator.oblicz(w, op, temp);
                setW(w2);
            } else if (isOP == false) {
                setW(temp);
            }

            op = "+";
            isOP = true;
            textView.setText("");
            is0 = true;   //nie można nastepne 0
            isDot = false;
            wasEq = false;

        } else if (button.getId() == R.id.btnMin) {
            if (wasEq==true){    //gdy odtatnie było "rowna sie" to nalezy wyzerowac istniejacy operator
                isOP=false;
                wasEq=false;
            }
            temp = Double.valueOf(textView.getText().toString());
            if (isOP == true) {
                double w2 = kalkulator.oblicz(getW(), op, temp);
                setW(w2);
            } else if (isOP == false) {
                setW(temp);
            }

            op = "-";
            isOP = true;
            textView.setText("");
            is0 = true;   //nie można nastepne 0
            isDot = false;
            wasEq = false;

        } else if (button.getId() == R.id.btnMult) {
            if (wasEq==true){    //gdy odtatnie było "rowna sie" to nalezy wyzerowac istniejacy operator
                isOP=false;
                wasEq=false;
            }
            temp = Double.valueOf(textView.getText().toString());
            if (isOP == true) {
                double w2 = kalkulator.oblicz(getW(), op, temp);
                setW(w2);
            } else if (isOP == false) {
                setW(temp);
            }

            op = "*";
            isOP = true;
            textView.setText("");
            is0 = true;   //nie można nastepne 0
            isDot = false;
            wasEq = false;

        } else if (button.getId() == R.id.btnDiv) {
            if (wasEq==true){    //gdy odtatnie było "rowna sie" to nalezy wyzerowac istniejacy operator
                isOP=false;
                wasEq=false;
            }
            temp = Double.valueOf(textView.getText().toString());
            if (isOP == true) {
                double w2 = kalkulator.oblicz(getW(), op, temp);
                setW(w2);
            } else if (isOP == false) {
                setW(temp);
            }

            op = "/";
            isOP = true;
            textView.setText("");
            is0 = true;   //nie można nastepne 0
            isDot = false;
            wasEq = false;

        } else if (button.getId() == R.id.btnZnak) {
            if (wasEq==true){    //gdy odtatnie było "rowna sie" to nalezy wyzerowac istniejacy operator
                isOP=false;
                wasEq=false;
            }
            temp = Double.valueOf(textView.getText().toString());
            if (w != 0) {
                if (isOP == true) {
                    double w2 = kalkulator.oblicz(getW(), op, temp);
                    setW(-w2);
                } else if (isOP == false) {
                    setW(-temp);
                }
            } else setW(-temp);

            op = "";
            isOP = false;
            textView.setText(String.valueOf(getW()));

            if (w % 1 == 0) {
                isDot = false;
                int wInt = (int) Math.round(getW());
                textView.setText(String.valueOf(wInt));
            } else {
                isDot = true;
                textView.setText(String.valueOf(getW()));
            }

            wasEq = false;

        } else if (button.getId() == R.id.btnProc) {
            if (wasEq==true){    //gdy odtatnie było "rowna sie" to nalezy wyzerowac istniejacy operator
                isOP=false;
                wasEq=false;
            }
            temp = Double.valueOf(textView.getText().toString());
            if (isOP == true) {
                if (op == "+" || op == "-") {
                    double tp = w * temp / 100;
                    double w2 = kalkulator.oblicz(w, op, tp);
                    setW(w2);
                } else {
                    double tp = temp / 100;
                    double w2 = kalkulator.oblicz(w, op, tp);
                    setW(w2);
                }
            } else if (isOP == false) {
                setW(temp / 100);
            }


            if (w % 1 == 0) {
                isDot = false;
                int wInt = (int) Math.round(getW());
                textView.setText(String.valueOf(wInt));
            } else {
                isDot = true;
                textView.setText(String.valueOf(getW()));
            }


            op = "";
            isOP = false;
            isDot = false;


            if (w % 1 == 0) {
                isDot = false;
            } else isDot = true;
            wasEq = false;
            is0 = true;   //nie można nastepne 0

        } else if (button.getId() == R.id.btnEq) {

            if (wasEq == false) {
                temp = Double.valueOf(textView.getText().toString());
                tempEq = temp;
                if (isOP == true) {
                    double w2 = kalkulator.oblicz(getW(), op, temp);
                    setW(w2);
                } else if (isOP == false) {
                    setW(temp);
                }
            } else {
                if (isOP == true) {
                    double w2 = kalkulator.oblicz(getW(), op, tempEq);
                    setW(w2);
                } else if (isOP == false) {
                    setW(tempEq);
                }

            }
            textView.setText(String.valueOf(getW()));
            //isOP = false;

            if (w % 1 == 0) {
                isDot = false;
                int wInt = (int) Math.round(getW());
                textView.setText(String.valueOf(wInt));
            } else {
                isDot = true;
                textView.setText(String.valueOf(getW()));
            }
            wasEq = true;

            is0 = true;   //nie można nastepne 0
        } else if (button.getId() == R.id.btnDot) {
            if (isDot == false) {
                label = button.getText().toString();
                System.out.println(label);
                String text = (textView.getText().toString() + label);
                textView.setText(text);
                isDot = true;
            } else {
                System.out.println("Error. Jest juz kropka");
            }
            wasEq = false;
            is0 = false;   //można nastepne 0

        } else if (button.getId() == R.id.btn0) {

            if (w == (int) 0 && isDot == false && is0 == true) {
                textView.setText("0");
            } else {
                label = button.getText().toString();
                System.out.println(label);
                String text = (textView.getText().toString() + label);
                textView.setText(text);

            }
            wasEq = false;
        } else {
            if (wasEq == true) {
                isOP = false;
                textView.setText("");
                wasEq = false;
            }

            String st = textView.getText().toString();
            label = button.getText().toString();
            if (st == "0") {
                textView.setText(label);

            } else {
                String text = (st + label);
                textView.setText(text);
            }

            is0 = false;   //można nastepne 0
        }

    }

}
