package com.example.frag_r7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFrag.NameClicked {

    LinearLayout portrait, landscape;
    FragmentManager manager;
    Fragment flist, fContent;

    TextView tvName;
    ImageView ivPhone, ivLocation, ivUrl, ivProfilePic;

    View viewOfContentFrag;

    Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        ivUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(contact.getUrl()));
                startActivity(i);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo(0,0)?q="+contact.getLocation()));
                startActivity(i);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+contact.getPhone()));
                startActivity(i);
            }
        });


        if(portrait != null)
        {
              manager.beginTransaction()
                      .show(flist)
                      .hide(fContent)
                      .commit();
        }
        else
        {
              manager.beginTransaction()
                    .show(flist)
                    .show(fContent)
                    .commit();
        }

    }

    private void init()
    {
        portrait = findViewById(R.id.portrait_mode);
        landscape = findViewById(R.id.landscape_mode);
        manager = getSupportFragmentManager();
        flist = manager.findFragmentById(R.id.fList);
        fContent = manager.findFragmentById(R.id.fContent);
        assert fContent != null;
        viewOfContentFrag = fContent.requireView();
        tvName = viewOfContentFrag.findViewById(R.id.tvName);
        ivLocation = viewOfContentFrag.findViewById(R.id.ivLocation);
        ivPhone = viewOfContentFrag.findViewById(R.id.ivPhone);
        ivUrl = viewOfContentFrag.findViewById(R.id.ivUrl);
        ivProfilePic = viewOfContentFrag.findViewById(R.id.ivProfilePic);

        ivProfilePic.setVisibility(View.GONE);
        ivUrl.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);

        tvName.setText("EMPTY");



    }

    @Override
    public void onNameClick(int index) {
        contact = MyApplication.contacts.get(index);
        tvName.setText(contact.getName());

        if(portrait != null)
        {
            manager.beginTransaction()
                    .hide(flist)
                    .show(fContent)
                    .addToBackStack(null)
                    .commit();
        }

        ivProfilePic.setVisibility(View.VISIBLE);
        ivUrl.setVisibility(View.VISIBLE);
        ivLocation.setVisibility(View.VISIBLE);
        ivPhone.setVisibility(View.VISIBLE);
    }
}