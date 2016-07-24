package tomer.edu.firedemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DatabaseReference;

import tomer.edu.firedemo.Const;
import tomer.edu.firedemo.R;
import tomer.edu.firedemo.adapters.ShoppingListItemsAdapter;
import tomer.edu.firedemo.dialogs.AddShoppingListItemFragment;

public class ShoppingListItemsActivity extends BaseActivity {

    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_items);

        RecyclerView rvShoppingListItems = (RecyclerView) findViewById(R.id.recyclerShoppingItems);
        rvShoppingListItems.setLayoutManager(new LinearLayoutManager(this));


        pid = getIntent().getStringExtra(Const.EXTRA_PID);

        DatabaseReference ref = getRef().child("ShoppingListItems").child(pid);

        ShoppingListItemsAdapter adapter = new ShoppingListItemsAdapter(ref);

        rvShoppingListItems.setAdapter(adapter);


    }

    public void addItemToShoppingList(View view) {
        AddShoppingListItemFragment fragment = AddShoppingListItemFragment.newInstance(pid);
        fragment.show(getSupportFragmentManager(), "AddItemToShoppingList");
    }
}
