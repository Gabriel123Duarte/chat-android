package duarte.gabriel.chat;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    User myUser, friend;
    private ListView messageListView;
    private EditText messageEditText;
    private ImageView sendImageView;
    private static final int DEFAULT_MSG_LENGTH_LIMIT = 140;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        myUser = (User) getIntent().getSerializableExtra("me");
        friend = (User) getIntent().getSerializableExtra("friend");
        if(myUser == null || friend == null)
            finish();

        setTitle(friend.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        messageListView = (ListView)findViewById(R.id.messageListView);
        messageEditText = (EditText)findViewById(R.id.messageEditText);
        sendImageView = (ImageView)findViewById(R.id.sendimageView);
        messageEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});
        messageEditText.clearFocus();


        messageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() > 0) {
                    sendImageView.setEnabled(true);
                } else {
                    sendImageView.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        sendImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");
    }

    private void sendMessage(){
        Message message = new Message(myUser, friend, messageEditText.getText().toString(), null);
        mMessagesDatabaseReference.push().setValue(message);
        messageEditText.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}
