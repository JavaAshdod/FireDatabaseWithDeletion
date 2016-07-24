package tomer.edu.firedemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tomer.edu.firedemo.R;
import tomer.edu.firedemo.adapters.UserShoppingListsAdapter;
import tomer.edu.firedemo.dialogs.AddUserListFragment;

public class UserListsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_lists);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        validateLogin();


    }

    private void validateLogin() {
        FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

                if (currentUser == null) {
                    /**
                     * Start an intent without adding the activity to the stack
                     */
                    Intent intent = new Intent(UserListsActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else {
                    Toast.makeText(UserListsActivity.this, "Hello, " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
                    initRecycler();
                }
            }
        });
    }

    void initRecycler(){

        RecyclerView rvShoppingLists = (RecyclerView) findViewById(R.id.userListsRecycler);

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("userLists").child(uid);
        UserShoppingListsAdapter adapter = new UserShoppingListsAdapter(this, ref);

        rvShoppingLists.setLayoutManager(new LinearLayoutManager(this));
        rvShoppingLists.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddUserList);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUserListFragment dialog = new AddUserListFragment();
                dialog.show(getSupportFragmentManager(), "AddUserList");
            }
        });
    }
}
