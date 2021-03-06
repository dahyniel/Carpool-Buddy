package com.example.carpoolbuddyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This class is used to sign up users after filling in given fields
 *
 * @author danielyang
 * @version 1.0
 */
public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private String selected;
    private Spinner sUserType;

    EditText nameField;
    EditText emailField;
    EditText passwordField;

    String roleInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        selected = findViewById(R.id.signUpRoleInput).toString();
        nameField = findViewById(R.id.signUpNameInput);
        emailField = findViewById(R.id.signUpEmailInput);
        passwordField = findViewById(R.id.signUpPasswordInput);

        sUserType = findViewById(R.id.signUpRoleInput);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sUserType.setAdapter(adapter);
        sUserType.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        String text = adapterView.getItemAtPosition(i).toString();
        roleInput = text;
//        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    /**
     * This method takes in the inputs from the user and stores an account to Firebase
     * @param v sends the user to the home page if the sign up is successful
     */
    public void signUp(View v)
    {
        EditText nameText = findViewById(R.id.signUpNameInput);
        String nameString = nameText.getText().toString();

        EditText emailText = findViewById(R.id.signUpEmailInput);
        String emailString = emailText.getText().toString();

        EditText passwordText = findViewById(R.id.signUpPasswordInput);
        String passwordString = passwordText.getText().toString();

        User newUser = new User(nameString, passwordString, emailString, roleInput);
        firestore.collection("Users").document(newUser.getUserName()).set(newUser);

        String cisEmail = emailString.substring(emailString.length() - 10);

        if (cisEmail.equals("cis.edu.hk"))
        {
            mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful())
                            {
                                Log.d("Sign Up", "Signed Up!");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            }
                            else
                            {
                                Log.w("SIGN UP", "createUserWithEmail:failure", task.getException());
                                updateUI(null);
                            }
                        }
                    });
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Sorry, this is only for the CIS community!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void updateUI(FirebaseUser currentUser)
    {
        if (currentUser != null)
        {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}