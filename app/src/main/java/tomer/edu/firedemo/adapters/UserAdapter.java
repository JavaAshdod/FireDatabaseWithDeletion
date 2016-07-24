package tomer.edu.firedemo.adapters;

import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import tomer.edu.firedemo.R;
import tomer.edu.firedemo.activities.ShareListWithUsersActivity;
import tomer.edu.firedemo.models.ShoppingList;
import tomer.edu.firedemo.models.Todo;
import tomer.edu.firedemo.models.User;
import tomer.edu.firedemo.utils.FirebaseRecyclerAdapter;

/**
 * Created by stud27 on 24/07/16.
 */
public class UserAdapter extends FirebaseRecyclerAdapter<User, UserAdapter.UserViewHolder>{

    private final ShoppingList userList;
    private final String listKey;
    private final ShareListWithUsersActivity activity;


    public UserAdapter(DatabaseReference ref, ShoppingList userList, String listKey, ShareListWithUsersActivity activity) {
        super(User.class, R.layout.user_item, UserViewHolder.class, ref);
        this.userList = userList;
        this.listKey = listKey;
        this.activity = activity;
    }

    @Override
    protected void populateViewHolder(UserViewHolder viewHolder, final User model, int position) {
        viewHolder.tvUserEmail.setText(model.getEmail());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().
                        child("userLists").
                        child(model.getUID()).
                        child(listKey).setValue(userList);
                //

                activity.finish();
            }
        });
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvUserEmail;
        RelativeLayout layout;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvUserEmail = (TextView) itemView.findViewById(R.id.tvUserEmail);
            layout = (RelativeLayout) itemView.findViewById(R.id.userLayout);
        }
    }
}
