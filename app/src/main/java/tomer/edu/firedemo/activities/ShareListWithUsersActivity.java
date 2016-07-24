package tomer.edu.firedemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tomer.edu.firedemo.Const;
import tomer.edu.firedemo.R;
import tomer.edu.firedemo.adapters.UserAdapter;
import tomer.edu.firedemo.models.ShoppingList;

public class ShareListWithUsersActivity extends AppCompatActivity {

    private String listKey;
    private ShoppingList userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_list_with_users);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            userList = intent.getParcelableExtra(Const.EXTRA_USER_LIST);
            listKey = intent.getStringExtra(Const.EXTRA_USER_LIST_KEY);



            RecyclerView rvUsers = (RecyclerView) findViewById(R.id.usersRecycler);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
            UserAdapter adapter = new UserAdapter(ref, userList, listKey, this);

            rvUsers.setLayoutManager(new LinearLayoutManager(this));
            rvUsers.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
