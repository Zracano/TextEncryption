package com.TextEncryption;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Launcher extends AppCompatActivity{
    EditText pPrime;
    EditText qPrime;
    EditText eCoPrime;
    EditText inputMessage;
    TextView encryptedMessageText;
    List<Integer> encryptedMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Main main = new Main();

        pPrime = findViewById(R.id.P);
        qPrime = findViewById(R.id.Q);
        eCoPrime = findViewById(R.id.E);
        inputMessage = findViewById(R.id.Message);
        encryptedMessageText = findViewById(R.id.EncryptedMessage);

        Button Encrypt = findViewById(R.id.Encrypt);
        //Define and attach click listener for encryption button
        Encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = Integer.parseInt(pPrime.getText().toString());
                int q = Integer.parseInt(qPrime.getText().toString());
                int e = Integer.parseInt(eCoPrime.getText().toString());
                int n = p*q;
                String message = inputMessage.getText().toString();
                encryptedMessage = main.encrypt(e,n,message);
                encryptedMessageText.setText(encryptedMessage.toString());
            }
        });

    }
}
