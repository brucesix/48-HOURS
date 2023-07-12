package com.example.a48hours.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a48hours.R;
import com.example.a48hours.databinding.FragmentClockBinding;

public class ClockFragment extends Fragment {

    private FragmentClockBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClockViewModel clockViewModel =
                new ViewModelProvider(this).get(ClockViewModel.class);

        binding = FragmentClockBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // SET THE ADAPTER FOR SPINNER

        Spinner spinnerClockInType = (Spinner) root.findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this.getActivity(),
                R.array.Type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerClockInType.setAdapter(adapter);

//        final TextView textView = binding.textGallery;
//        clockViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}