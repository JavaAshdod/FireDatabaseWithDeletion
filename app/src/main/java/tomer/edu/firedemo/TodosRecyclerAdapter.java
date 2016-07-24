package tomer.edu.firedemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import tomer.edu.firedemo.models.Todo;

/**
 * 1) create an inner class of the viewHolder
 */
public class TodosRecyclerAdapter extends FirebaseRecyclerAdapter<Todo, TodosRecyclerAdapter.TodosViewHolder> {

    private final DatabaseReference ref;
    boolean isEnabled = true;

    public TodosRecyclerAdapter(DatabaseReference ref) {
        super(Todo.class, R.layout.todo_item, TodosViewHolder.class, ref);
        this.ref = ref;

    }

    @Override
    protected void populateViewHolder(final TodosViewHolder viewHolder, final Todo model, final int position) {
        viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDescription.setText(model.getContent());


        viewHolder.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getRef(position).removeValue();
                ref.child(viewHolder.key).removeValue();
            }
        });
    }

//Firebase.ViewHolder... String key
    public static class TodosViewHolder extends RecyclerView.ViewHolder {
        String key;
        TextView tvTitle;
        TextView tvDescription;
        FloatingActionButton fabDelete;

        public TodosViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDetails);
            fabDelete = (FloatingActionButton) itemView.findViewById(R.id.fabDelete);
        }
    }
}
