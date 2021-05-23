package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class page3 extends AppCompatActivity {

    private Button signupenter;
    private EditText signupaccount,signuppswd;
    private TextView textView3,textView4,textView5;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        signupenter =findViewById(R.id.signupenter);
        signupaccount =findViewById(R.id.signupaccount);
        signuppswd =findViewById(R.id.signuppswd);

        mAuth=FirebaseAuth.getInstance();

        signupenter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                createUser();
            }

            private void createUser() {
                String account = signupaccount.getText().toString();
                String pswd = signuppswd.getText().toString();

                if(!account.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(account).matches()){
                    if(!pswd.isEmpty()){
                        mAuth.createUserWithEmailAndPassword(account,pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(page3.this,"註冊成功",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(page3.this,MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(page3.this,"註冊失敗",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    else{
                        signuppswd.setError("密碼不能是空的");
                    }
                }
                else if(account.isEmpty()){
                    signupaccount.setError("帳號不能是空的");
                }
            }
        });
    }
}