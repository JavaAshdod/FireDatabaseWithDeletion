package tomer.edu.firedemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import tomer.edu.firedemo.R;
import tomer.edu.firedemo.models.ShoppingList;
import tomer.edu.firedemo.models.ShoppingListItem;
import tomer.edu.firedemo.utils.FirebaseRecyclerAdapter;

/**
 * Created by stud27 on 24/07/16.
 */
public class ShoppingListItemsAdapter extends FirebaseRecyclerAdapter<ShoppingListItem, ShoppingListItemsAdapter.ShoppingListItemsViewHolder>{

    public ShoppingListItemsAdapter( DatabaseReference ref) {
        super(ShoppingListItem.class, R.layout.shopping_list_item, ShoppingListItemsViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(ShoppingListItemsViewHolder viewHolder, ShoppingListItem model, int position) {
        viewHolder.tvListItem.setText(model.getTitle());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });

    }

    public static class ShoppingListItemsViewHolder extends RecyclerView.ViewHolder{
        String key;
        TextView tvListItem;
        RelativeLayout layout;

        public ShoppingListItemsViewHolder(View itemView) {
            super(itemView);
            tvListItem = (TextView) itemView.findViewById(R.id.tvShoppingListItem);
            layout = (RelativeLayout)itemView.findViewById(R.id.shoppingListLayout);
        }
    }
}
