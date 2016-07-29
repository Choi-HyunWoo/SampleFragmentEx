package com.example.hyunwoo.samplefragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
public class LoginFragment extends Fragment {

    EditText inputID;
    EditText inputPW;
    Button loginBtn;
    Button signupBtn;

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        mEditor = mPrefs.edit();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // View Initialize
        inputID = (EditText) view.findViewById(R.id.inputID);
        inputPW = (EditText) view.findViewById(R.id.inputPW);
        loginBtn = (Button) view.findViewById(R.id.loginBtn);
        signupBtn = (Button) view.findViewById(R.id.signUpBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = inputID.getText().toString();
                String pw = inputPW.getText().toString();

                if (TextUtils.isEmpty(id)) {
                    Toast.makeText(getContext(), "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pw)) {
                    Toast.makeText(getContext(), "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                } else {

                    // LOGIN !
                    String memberID = mPrefs.getString(SignupFragment.LOGIN_ID, "");
                    String memberPW = mPrefs.getString(SignupFragment.LOGIN_PW, "");

                    if (id.equals(memberID) && pw.equals(memberPW)) {
                        Toast.makeText(getContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    } else if (TextUtils.isEmpty(memberID) && TextUtils.isEmpty(memberPW)) {
                        Toast.makeText(getContext(), "가입된 아이디가 없습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity)getActivity()).pushSignupFragment();
            }
        });

        return view;
    }

}
















