package com.ab.fragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText editText;
    private Button button;
    OnMessageSendListener messageSendListener;

    public interface OnMessageSendListener
    {
        public void OnMessageSend(String message);
    }


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        button = view.findViewById(R.id.bn);
        editText = view.findViewById(R.id.txt_message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                messageSendListener.OnMessageSend(message);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try
        {
            messageSendListener = (OnMessageSendListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"Must implement OnMessageSendListener.....");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
    }
}
