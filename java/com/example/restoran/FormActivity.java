package com.example.restoran;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormActivity extends AppCompatActivity {

    // membuat variable sesuai dengan tipe data masing-masing
    EditText tanggal, jam, nomorMeja;
    ImageView iconKalender, iconJam;
    Button submit;

    // variable untuk date picker
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        tanggal = findViewById(R.id.tanggal);
        jam = findViewById(R.id.jam);
        nomorMeja = findViewById(R.id.nomorMeja);
        iconKalender = findViewById(R.id.icoNTanggal);
        iconJam = findViewById(R.id.icoNJam);
        submit = findViewById(R.id.submiTNext);

        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        iconKalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDateDialog();
            }
        });

        iconJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTimeDialog();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perintah melempar data
                String inputTanggal = tanggal.getText().toString();
                String inputJam = jam.getText().toString();
                String inputMeja = nomorMeja.getText().toString();

                Bundle paket = new Bundle();
                paket.putString("Tanggal", inputTanggal);
                paket.putString("Jam", inputJam);
                paket.putString("Nomor Meja", inputMeja);

                Intent i = new Intent(FormActivity.this, MenuActivity.class);
                i.putExtras(paket);
                startActivity(i);
            }
        });
    }

    private void ShowDateDialog(){
        // untuk mendapatkan tanggal
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog
                (this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar c =  Calendar.getInstance();
                        c.set(year, month, dayOfMonth);
                        tanggal.setText(dateFormat.format(c.getTime()));
                    }
                },
                        newCalendar.get(Calendar.YEAR),
                        newCalendar.get(Calendar.MONTH),
                        newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
    }

    private void ShowTimeDialog(){

        Calendar calendar = Calendar.getInstance();

        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar c = Calendar.getInstance();
                jam.setText(hourOfDay + ":" + minute);
            }
        },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }
}
