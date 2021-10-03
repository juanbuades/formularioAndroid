package com.example.ej03_juan_buades;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText name;
    EditText lastname;
    EditText age;
    TextView incorrectAge;
    EditText othercontest;
    CheckBox check1;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    Button suscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        final EditText name = findViewById(R.id.name);
        final EditText lastname = findViewById(R.id.lastName);
        final EditText age = findViewById(R.id.age);
        final TextView incorrectAge = findViewById(R.id.incorrectAge);
        incorrectAge.setVisibility(View.INVISIBLE);
        final CheckBox check1 = findViewById(R.id.check);
        final EditText othercontest = findViewById(R.id.otherContest1);
        othercontest.setVisibility(View.INVISIBLE);
        RadioButton radioButtonMale = findViewById(R.id.radioButtonMale);
        RadioButton radioButtonFemale = findViewById(R.id.radioButtonFemale);
        final Button suscribe = findViewById(R.id.button);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1.isChecked()) {
                    othercontest.setVisibility(View.VISIBLE);
                } else {
                    othercontest.setVisibility(View.INVISIBLE);
                }
            }
        });
        suscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age_srt = age.getText().toString();
                if (age_srt.matches("")) {
                    age_srt = "0";
                }
                int age_int = Integer.parseInt(age_srt);
                String name_str = name.getText().toString();
                String lastname_str = lastname.getText().toString();
                String othercontest_str = othercontest.getText().toString();

                if (name_str.isEmpty() || lastname_str.isEmpty() || age_srt.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Rellene todos los campos", Toast.LENGTH_LONG).show();
                }
                else if (age_int < 18){
                    incorrectAge.setTextColor(Color.RED);
                    incorrectAge.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Edad minima de 18 años", Toast.LENGTH_LONG).show();
                }
                else if (check1.isChecked() && othercontest_str.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Indique el nombre del concurso anterior", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Registrando...", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Registro completado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    }
}
