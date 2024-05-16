package com.example.t5_a4_banuelosruizeduardoalejo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    logicaConversiones log = new logicaConversiones();
    RadioGroup radioGroup;
    RadioButton radioDecimal,radioBinario,radioOctal,radioHex;
    CheckBox chkOct,chkBin,chkHex;
    TextView txtOctRes,txtHexRes;

    EditText txtIngreso,txtBinRes;

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

    public void conversionBinario (View v){
        int id = radioGroup.getCheckedRadioButtonId();
        if (((CheckBox) v).isChecked()) {
            Double ingDec = Double.parseDouble(String.valueOf(txtIngreso.getText()));
            int ingBin = Integer.parseInt(String.valueOf(txtIngreso.getText()));

            if (id == radioDecimal.getId()) {
                txtBinRes.setText(log.conversionDecimalBinario(ingBin));
            } else if (id == radioBinario.getId()) {

            } else if (id == radioOctal.getId()) {

            } else if (id == radioHex.getId()) {

            }
        }
    }//CONVERSIONES BINARIO



}//MAIN