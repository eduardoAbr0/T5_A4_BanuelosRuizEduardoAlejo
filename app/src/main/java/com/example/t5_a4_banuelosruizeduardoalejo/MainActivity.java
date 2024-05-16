package com.example.t5_a4_banuelosruizeduardoalejo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    logicaConversiones log = new logicaConversiones();
    RadioGroup radioGroup;
    RadioButton radioDecimal, radioBinario, radioOctal, radioHex;
    CheckBox chkOct, chkBin, chkHex;
    EditText txtIngreso, txtBinRes, txtOctRes, txtHexRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.grupoConversiones);

        radioDecimal = findViewById(R.id.radioDecimal);
        radioBinario = findViewById(R.id.radioBinario);
        radioOctal = findViewById(R.id.radioOctal);
        radioHex = findViewById(R.id.radioHex);

        txtIngreso = findViewById(R.id.txtIngreso);

        chkOct = findViewById(R.id.chkOct);
        chkBin = findViewById(R.id.chkBin);
        chkHex = findViewById(R.id.chkHex);

        txtBinRes = findViewById(R.id.txtBinRes);
        txtOctRes = findViewById(R.id.txtOctRes);
        txtHexRes = findViewById(R.id.txtHexRes);

    }

    public void conversionBinario(View v) {
        int id = radioGroup.getCheckedRadioButtonId();

        //VERIFICACION CAMPO VACIO
        if (!TextUtils.isEmpty(txtIngreso.getText().toString())) {
            if (((CheckBox) v).isChecked()) {
                String ingS = txtIngreso.getText().toString();


                //CONVERSION DECIMAL A BINARIO
                if (id == radioDecimal.getId()) {
                    double ingDec = Double.parseDouble(txtIngreso.getText().toString());
                    int ingBin = (int) ingDec;

                    if (ingBin < 0) {
                        txtBinRes.setText("-" + log.conversionDecimalBinario(ingBin * -1));
                    } else {
                        txtBinRes.setText(log.conversionDecimalBinario(ingBin));
                    }

                    //CONVERSION OCTAL A BINARIO
                } else if (id == radioOctal.getId()) {
                    double ingDec = Double.parseDouble(txtIngreso.getText().toString());
                    int ingBin = (int) ingDec;

                    txtBinRes.setText(log.conversionOctalBinario(ingBin));
                }

                //CONVERSION HEXA A BINARIO
                else if (id == radioHex.getId()) {
                    txtBinRes.setText(log.conversionHexaBin(ingS));
                } else {
                    Toast.makeText(this, "Selecciona tipo de entrada.", Toast.LENGTH_SHORT).show();
                }
            } else {
                txtBinRes.setText("");
            }
        } else {
            Toast.makeText(this, "Ingresa la entrada.", Toast.LENGTH_SHORT).show();
        }

    }//CONVERSIONES BINARIO

    public void conversionOctal(View v) {
        int id = radioGroup.getCheckedRadioButtonId();

        if (((CheckBox) v).isChecked()) {
            //VERIFICACION CAMPO VACIO
            if (!TextUtils.isEmpty(txtIngreso.getText().toString())) {
                //CONVERSION DECIMAL A OCTAL
                if (id == radioDecimal.getId()) {
                    int inDou = Integer.parseInt(txtIngreso.getText().toString());

                    txtOctRes.setText(log.conversionDecimalOctal(inDou));
                }

                //CONVERSION BINARIO A OCTAL
                else if (id == radioBinario.getId()) {
                    String inDou = txtIngreso.getText().toString();

                    txtOctRes.setText(log.conversionBinarioOctal(inDou));
                }

                //CONVERSION HEXADECIMAL A OCTAL
                else if (id == radioHex.getId()) {
                    String inDou = txtIngreso.getText().toString();
                    //HEXADECIMAL A BINARIO
                    String hexD = log.conversionHexaBin(inDou);
                    //BINARIO A OCTAL
                    String binOc = log.conversionBinarioOctal(hexD);

                    txtOctRes.setText(binOc);

                } else {
                    Toast.makeText(this, "Selecciona tipo de entrada.", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Ingresa la entrada.", Toast.LENGTH_SHORT).show();
            }
        } else {
            txtBinRes.setText("");

        }

    }


}//MAIN