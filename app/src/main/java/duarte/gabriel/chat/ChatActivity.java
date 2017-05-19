package duarte.gabriel.chat;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class ChatActivity extends AppCompatActivity {

    User myUser, friend;
    private ListView messageListView;
    private EditText messageEditText;
    private ImageView sendImageView;
    private static final int DEFAULT_MSG_LENGTH_LIMIT = 140;

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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}
