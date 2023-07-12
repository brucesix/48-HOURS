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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFragment extends Fragment {

    private FragmentClockBinding binding;
    TextView dateTimeFormat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClockViewModel clockViewModel =
                new ViewModelProvider(this).get(ClockViewModel.class);
        binding = FragmentClockBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        String dateTime;
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;

        // SET THE ADAPTER FOR SPINNER

        Spinner spinnerClockInType = (Spinner) root.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this.getActivity(),
                R.array.Type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerClockInType.setAdapter(adapter);

        // Register the text view with the right ID
        dateTimeFormat = (TextView) root.findViewById(R.id.dateFormat1);

        // get the long type value of the current system date
        Long dateValueInLong = System.currentTimeMillis();
        dateTimeFormat.setText(dateValueInLong.toString());

        // Format the date
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEEE, LLL dd");
//        dateTime = simpleDateFormat.format(calendar.toString());
//        dateTimeFormat.setText(dateTime);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}