package duarte.gabriel.chat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by gabriel on 19/05/17.
 */

public class UserListAdapter extends ArrayAdapter<User> {
    public UserListAdapter(Context context, int resource, List<User> objects){
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.user_list, parent, false);

        ImageView photo = (ImageView)convertView.findViewById(R.id.userImage);
        TextView nameTextView = (TextView)convertView.findViewById(R.id.nameTextView);
        TextView emailTextView = (TextView)convertView.findViewById(R.id.emailTextView);

        User user = getItem(position);

        nameTextView.setText(user.getName());
        emailTextView.setText(user.getEmail());
        Glide.with(photo.getContext())
                .load(user.getPhotoUri())
                .into(photo);


        return convertView;
    }
}
