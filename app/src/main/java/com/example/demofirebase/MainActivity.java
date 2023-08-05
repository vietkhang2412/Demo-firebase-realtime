package com.example.demofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText edName, edEmail, edAge, edId;
    private Button btnSend;

    private FirebaseDatabase database;
    private DatabaseReference myRef ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edEmail = findViewById(R.id.edEmail);
        edId = findViewById(R.id.edId);
        btnSend = findViewById(R.id.btnSend);

        database = FirebaseDatabase.getInstance("https://demofirebase-fcc27-default-rtdb.asia-southeast1.firebasedatabase.app");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                myRef = database.getReference("message");//trỏ tới cái gì thì đưa nó vào đây
//                myRef.setValue(edId.getText().toString());
//
//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        //dữ liệu trả về ở đây
//                        String s = snapshot.getValue(String.class);
//                        edName.setText(s);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        //lỗi xẩy ra ở đây
//                    }
//                });
//                trỏ tới people
//                myRef = database.getReference("people");
//                int id = Integer.parseInt(edId.getText().toString());
//                int age = Integer.parseInt(edAge.getText().toString());
//                String name = edName.getText().toString();
//                String email = edEmail.getText().toString();
//                People people = new People(name, email, id, age);
//                myRef.setValue(people);

                //trỏ tới array
                myRef = database.getReference("listPeople/2");
                int id = Integer.parseInt(edId.getText().toString());
                int age = Integer.parseInt(edAge.getText().toString());
                String name = edName.getText().toString();
                String email = edEmail.getText().toString();
                People people = new People(name, email, id, age);

                myRef.setValue(people);
            }
        });
    }
}