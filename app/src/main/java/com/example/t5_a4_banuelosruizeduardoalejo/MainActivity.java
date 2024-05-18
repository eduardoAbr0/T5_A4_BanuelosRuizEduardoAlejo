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
    boolean ver = true;

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

    //CONVERSIONES BINARIO
    public void conversionBinario(View v) {
        ver = true;
        int id = radioGroup.getCheckedRadioButtonId();

        //VERIFICACION CAMPO VACIO
        if (!TextUtils.isEmpty(txtIngreso.getText().toString())) {
            String txtIng = txtIngreso.getText().toString().toUpperCase();
            //EJM
            for (int i = 0 ; i < txtIng.length();i++) {
                if (!((txtIng.charAt(i)>='0' && txtIng.charAt(i)<='9') || (txtIng.charAt(i)=='-') || (txtIng.charAt(i)=='.'))) {
                    ver = false;
                    break;
                }
            }
                if (((CheckBox) v).isChecked()) {
                    String ingS = txtIngreso.getText().toString();
                    if (ver){

                    }

                    //CONVERSION DECIMAL A BINARIO
                    if (id == radioDecimal.getId()) {
                        //VERIFICACION DECIMAL INGRESADO
                        for (int i = 0 ; i < txtIng.length();i++) {
                            if (!((txtIng.charAt(i)>='0' && txtIng.charAt(i)<='9') || (txtIng.charAt(i)=='-' || (txtIng.charAt(i)=='.')))) {
                                ver = false;
                                break;
                            }
                        }

                        if (ver){
                            double ingDec = Double.parseDouble(txtIngreso.getText().toString());
                            int ingBin = (int) ingDec;

                            if (ingBin < 0) {
                                txtBinRes.setText("-" + log.conversionDecimalBinario(ingBin * -1));
                            } else {
                                txtBinRes.setText(log.conversionDecimalBinario(ingBin));
                            }
                        }else{
                            Toast.makeText(this, "Ingresa un numero decimal correcto.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //CONVERSION OCTAL A BINARIO
                    else if (id == radioOctal.getId()) {
                        //VERIFICACION OCTAL INGRESADO
                        for (int i = 0 ; i < ingS.length();i++) {
                            if (!(ingS.charAt(i)>='0' && ingS.charAt(i)<='7')) {
                                ver = false;
                                break;
                            }
                        }

                        if (ver){
                            double ingDec = Double.parseDouble(txtIngreso.getText().toString());
                            int ingBin = (int) ingDec;

                            txtBinRes.setText(log.conversionOctalBinario(ingBin));
                        }else {
                            Toast.makeText(this, "Ingresa un numero octal correcto.", Toast.LENGTH_SHORT).show();
                        }

                    }

                    //CONVERSION HEXA A BINARIO
                    else if (id == radioHex.getId()) {
                        //VERFICACION HEXA INGRESADO
                        for (int i = 0 ; i < txtIng.length();i++) {
                            if (!((txtIng.charAt(i)>='0' && txtIng.charAt(i)<='9') || (txtIng.charAt(i)>='A' && txtIng.charAt(i)<='F'))) {
                                ver = false;
                                break;
                            }
                        }

                        if (ver){
                            txtBinRes.setText(log.conversionHexaBin(ingS));
                        }else {
                            Toast.makeText(this, "Ingresa un hexadecimal correcto.", Toast.LENGTH_SHORT).show();
                        }

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


    //CONVERSIONES OCTAL
    public void conversionOctal(View v) {
        ver = true;
        int id = radioGroup.getCheckedRadioButtonId();

        if (((CheckBox) v).isChecked()) {
            //VERIFICACION CAMPO VACIO
            if (!TextUtils.isEmpty(txtIngreso.getText().toString())) {
                String txtIng[] = txtIngreso.getText().toString().split("");
                String txtIng2 = txtIngreso.getText().toString();

                //CONVERSION DECIMAL A OCTAL
                if (id == radioDecimal.getId()) {
                    //VERIFICACION DECIMAL INGRESADO
                    for (int i = 0 ; i < txtIng2.length();i++) {
                        if (!((txtIng2.charAt(i)>='0' && txtIng2.charAt(i)<='9') || (txtIng2.charAt(i)=='-') || (txtIng2.charAt(i)=='.'))) {
                            ver = false;
                            break;
                        }
                    }

                    if (ver){
                        int inDou = Integer.parseInt(txtIngreso.getText().toString());

                        txtOctRes.setText(log.conversionDecimalOctal(inDou));
                    }else{
                        Toast.makeText(this, "Ingresa un numero decimal correcto.", Toast.LENGTH_SHORT).show();
                    }
                }

                //CONVERSION BINARIO A OCTAL
                else if (id == radioBinario.getId()) {
                    //VERIFICACION BINARIO INGRESADO
                    for (String n : txtIng) {
                        if (!n.equals("0") && !n.equals("1")) {
                            ver = false;
                        }
                    }

                    if (ver){
                        String inDou = txtIngreso.getText().toString();

                        txtOctRes.setText(log.conversionBinarioOctal(inDou));
                    }else {
                        Toast.makeText(this, "Ingresa un numero binario correcto.", Toast.LENGTH_SHORT).show();
                    }

                }

                //CONVERSION HEXADECIMAL A OCTAL
                else if (id == radioHex.getId()) {
                    //VERFICACION HEXA INGRESADO
                    for (int i = 0 ; i < txtIng2.length();i++) {
                        if (!((txtIng2.charAt(i)>='0' && txtIng2.charAt(i)<='9') || (txtIng2.charAt(i)>='A' && txtIng2.charAt(i)<='F'))) {
                            ver = false;
                            break;
                        }
                    }

                    if (ver){
                        String inDou = txtIngreso.getText().toString();
                        //HEXADECIMAL A BINARIO
                        String hexD = log.conversionHexaBin(inDou);
                        //BINARIO A OCTAL
                        String binOc = log.conversionBinarioOctal(hexD);

                        txtOctRes.setText(binOc);
                    }else {
                        Toast.makeText(this, "Ingresa un hexadecimal correcto.", Toast.LENGTH_SHORT).show();
                    }



                } else {
                    Toast.makeText(this, "Selecciona tipo de entrada.", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Ingresa la entrada.", Toast.LENGTH_SHORT).show();
            }
        } else {
            txtOctRes.setText("");

        }

    }

    //CONVERSION HEXADECIMAL
    public void conversionHex(View v) {
        int id = radioGroup.getCheckedRadioButtonId();
        ver = true;

        if (((CheckBox) v).isChecked()) {
            //VERIFICACION CAMPO VACIO
            if (!TextUtils.isEmpty(txtIngreso.getText().toString())) {
                String txtIng[] = txtIngreso.getText().toString().split("");
                String txtIng2 = txtIngreso.getText().toString().toUpperCase();

                //CONVERSION DECIMAL A HEXADECIMAL
                if (id == radioDecimal.getId()) {
                    //VERIFICACION DECIMAL INGRESADO
                    for (int i = 0 ; i < txtIng2.length();i++) {
                        if (!((txtIng2.charAt(i)>='0' && txtIng2.charAt(i)<='9') || (txtIng2.charAt(i)=='-') || (txtIng2.charAt(i)=='.'))) {
                            ver = false;
                            break;
                        }
                    }

                    if (ver){
                        int indD = Integer.parseInt(String.valueOf(txtIngreso.getText()));
                        txtHexRes.setText(log.conversionDecimalHex(indD));
                    }else{
                        Toast.makeText(this, "Ingresa un numero decimal correcto.", Toast.LENGTH_SHORT).show();
                    }

                }//CONVERSION DECIMAL A HEXADECIMAL

                //CONVERSION BINARIO A HEXADECIMAL
                else if (id == radioBinario.getId()) {
                    //VERIFICACION BINARIO INGRESADO
                    for (String n : txtIng) {
                        if (!n.equals("0") && !n.equals("1")) {
                            ver = false;
                        }
                    }

                    if (ver){
                        String inD = txtIngreso.getText().toString();

                        txtHexRes.setText(log.conversionBinHex(inD));
                    }else {
                        Toast.makeText(this, "Ingresa un numero binario correcto.", Toast.LENGTH_SHORT).show();
                    }


                }//CONVERSION BINARIO A HEXADECIMAL

                //CONVERSION OCTAL A HEXADECIMAL
                else if (id == radioOctal.getId()) {
                    String ingS = txtIngreso.getText().toString();

                    //VERIFICACION OCTAL INGRESADO
                    for (int i = 0 ; i < ingS.length();i++) {
                        if (!(ingS.charAt(i)>='0' && ingS.charAt(i)<='7')) {
                            ver = false;
                            break;
                        }
                    }

                    if (ver){
                        //CONVERTIR DE OCTAL A BINARIO
                        int inInt = Integer.parseInt(String.valueOf(txtIngreso.getText()));
                        String octBin = log.conversionOctalBinario(inInt);
                        //CONVERTIR DE BINARIO A HEXADECIMAL
                        String binHex = log.conversionBinHex(octBin);

                        txtHexRes.setText(binHex);
                    }else {
                        Toast.makeText(this, "Ingresa un numero octal correcto.", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Selecciona tipo de entrada.", Toast.LENGTH_SHORT).show();
                }


            } else {
                Toast.makeText(this, "Ingresa la entrada.", Toast.LENGTH_SHORT).show();
            }
        } else {
            txtHexRes.setText("");

        }
    }//CONVERSIONES HEXADECIMAL

}//MAIN