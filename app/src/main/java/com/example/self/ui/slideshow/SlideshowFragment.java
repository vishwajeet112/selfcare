package com.example.self.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.self.MainActivity;
import com.example.self.MainActivity2;
import com.example.self.R;
import com.example.self.databinding.FragmentSlideshowBinding;
import com.example.self.maindashboard;
import com.example.self.ui.home.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    FirebaseAuth firebaseAuth;TextView yes,no;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        yes=root.findViewById(R.id.yes);
        no=root.findViewById(R.id.no);
//        final TextView textView = binding.textSlideshow;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth=FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), maindashboard.class);
                startActivity(intent);

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}