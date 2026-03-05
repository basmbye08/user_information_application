package com.example.userinformationapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password, address, age;
    RadioGroup genderGroup;
    RadioButton selectedGender;
    DatePicker datePicker;
    Spinner spinnerState;
    Button submitButton;
    TextView resultText;

    String[] states = {"Haryana", "Delhi", "Punjab", "Uttar Pradesh", "Rajasthan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);
        address = findViewById(R.id.editAddress);
        age = findViewById(R.id.editAge);

        genderGroup = findViewById(R.id.radioGroupGender);
        datePicker = findViewById(R.id.datePicker);
        spinnerState = findViewById(R.id.spinnerState);

        submitButton = findViewById(R.id.buttonSubmit);
        resultText = findViewById(R.id.textResult);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, states);

        spinnerState.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String addr = address.getText().toString();
                String userAge = age.getText().toString();

                int selectedId = genderGroup.getCheckedRadioButtonId();
                selectedGender = findViewById(selectedId);

                String gender = selectedGender.getText().toString();

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();

                String dob = day + "/" + month + "/" + year;

                String state = spinnerState.getSelectedItem().toString();

                String result =
                        "Username: " + user +
                                "\nPassword: " + pass +
                                "\nAddress: " + addr +
                                "\nGender: " + gender +
                                "\nAge: " + userAge +
                                "\nDOB: " + dob +
                                "\nState: " + state;

                resultText.setText(result);
            }
        });
    }
}