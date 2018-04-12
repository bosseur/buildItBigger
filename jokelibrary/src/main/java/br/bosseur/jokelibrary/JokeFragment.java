package br.bosseur.jokelibrary;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeFragment extends Fragment {

  public static final String ARG_JOKE  = "joke";

  private String joke;


  private TextView mJokeTextView;


  public JokeFragment() {
    // Required empty public constructor
  }


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getActivity().getIntent();
    joke = intent.getStringExtra(ARG_JOKE);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_joke, container, false);

    mJokeTextView = view.findViewById(R.id.joke);

    if(!TextUtils.isEmpty(joke)) {
      mJokeTextView.setText(joke);
    }

    return view;
  }

}
