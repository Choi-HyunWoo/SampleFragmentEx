package com.example.hyunwoo.samplefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    EditText inputID, inputPW, inputPWrpt;
    Button signupBtn;

    

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        // View Initialize
        inputID = (EditText) view.findViewById(R.id.inputID);
        inputPW = (EditText) view.findViewById(R.id.inputPW);
        inputPWrpt = (EditText) view.findViewById(R.id.inputPWrpt);
        signupBtn = (Button) view.findViewById(R.id.signUpBtn);


        // 회원가입 로직
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(inputID.getText().toString())) {
                    Toast.makeText(getContext(), "아이디 입력하세요", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(inputPW.getText().toString())) {
                    Toast.makeText(getContext(), "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(inputPWrpt.getText().toString())) {
                    Toast.makeText(getContext(), "비밀번호 확인하세요", Toast.LENGTH_SHORT).show();
                }else {

                    // 회원가입 로직



                    // Fragment가 소속된 Activity를 finish
                    getActivity().finish();
                }

            }
        });








        return view;
    }

}
