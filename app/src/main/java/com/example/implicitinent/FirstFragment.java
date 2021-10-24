package com.example.implicitinent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.implicitinent.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;
EditText url,subjects,body;
Button btn,btn1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentFirstBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
        btn = view.findViewById(R.id.button);
        url = view.findViewById(R.id.editTextTextPersonName);
        subjects=view.findViewById(R.id.editTextTextPersonName2);
        body=view.findViewById(R.id.editTextTextPersonName3);
        btn1= view.findViewById(R.id.button2);


//        implicent url intent
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=url.getText().toString();
                Toast.makeText(getActivity(), "got it", Toast.LENGTH_SHORT).show();

//                this is implicent intent for all browsers
                Uri webpage = Uri.parse(str);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }

//                you can call this an explicit intent because it only opens chrome
//                Intent i = new Intent();
//                i.setPackage("com.android.chrome");
//                i.setAction(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(str));
//                startActivity(i);

            }
        });
//        implicent email intent
       btn1.setOnClickListener(new View.OnClickListener() {
           String[] addresses={"amrutakhamkar15@gmail.com","amrutakhamkar610@gmail.com"};
           String subject=subjects.getText().toString();
           String Body=body.getText().toString();
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_SENDTO);
               intent.setData(Uri.parse("mailto:"));
//               intent.setType("*/*");
               intent.putExtra(Intent.EXTRA_EMAIL, addresses);
               intent.putExtra(Intent.EXTRA_SUBJECT, subject);
               intent.putExtra(Intent.EXTRA_TEXT, Body);

               if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                   startActivity(intent);
               }
           }
       });

    }
//



@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}