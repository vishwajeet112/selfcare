package com.example.self.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.self.AnonymousCorner;
import com.example.self.Insidephysical;
import com.example.self.MainActivity;
import com.example.self.MentalDashboard;
import com.example.self.R;
import com.example.self.SocialDashboard;
import com.example.self.dashboard1;
import com.example.self.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment  {
    CardView startprogress;
    CardView startprogress1;
    CardView startprogress2;
    private FragmentHomeBinding binding;
    DatabaseReference databaseReference;
    TextView CompleteProfile;
    FloatingActionButton fab1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        CompleteProfile=root.findViewById(R.id.textView);
        fab1=root.findViewById(R.id.fab1);
        binding.fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AnonymousCorner.class));
            }
        });
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String role=snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("role").getValue(String.class);
               // Toast.makeText(getActivity(), ""+role, Toast.LENGTH_SHORT).show();
                if(role.equalsIgnoreCase("Guardian")==false){
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            boolean completeProf= (boolean) snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("profileComp").getValue();
                            if(completeProf==false){
                                CompleteProfile.setVisibility(View.VISIBLE);
                                CompleteProfile.setEnabled(true);
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        CompleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getActivity(), dashboard1.class));
            }
        });
        startprogress=root.findViewById(R.id.startprogress);
        startprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Insidephysical.class);
                    startActivity(intent);
            }
        });


        startprogress1=root.findViewById(R.id.startprogress1);
        startprogress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MentalDashboard.class));
            }
        });

        startprogress2=root.findViewById(R.id.startprogress2);
        startprogress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          startActivity(new Intent(getActivity(), SocialDashboard.class));
            }
        });


//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}