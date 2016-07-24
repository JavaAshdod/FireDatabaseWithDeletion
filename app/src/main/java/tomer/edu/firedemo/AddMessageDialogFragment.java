package tomer.edu.firedemo;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tomer.edu.firedemo.models.Todo;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMessageDialogFragment extends DialogFragment {
    EditText etTitle;
    EditText etMessage;
    Button btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_message_dialog, container, false);

        //FIND Views By ID:
        etTitle = (EditText) v.findViewById(R.id.etTitle);
        etMessage = (EditText)v.findViewById(R.id.etMessage);
        btnSave = (Button) v.findViewById(R.id.btnSave);

        //Set On Click Listener for btnSave
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTodoToFirebase();
            }
        });
        return v;
    }

    private void saveTodoToFirebase() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        String uid = currentUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Todos").child(uid);

        Todo todo = new Todo(etTitle.getText().toString(), etMessage.getText().toString());

        ref.push().setValue(todo);
        dismiss();
    }
}
