package sg.edu.rp.soi.knowyourfacts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {
    Button btnChange;
    RelativeLayout rl1;
    ImageView iv1;
    ArrayList<String> al;
    public Frag1() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        btnChange = view.findViewById(R.id.btnChange);
        rl1 = view.findViewById(R.id.rl1);
        iv1 = view.findViewById(R.id.imageView);
        al = new ArrayList<>();
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Dead-Snail-In-A-Beer.png");
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Bats-Communicate-Directly.png");
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Gyoza-The-Pug.png");
        Picasso.with(getContext()).load(al.get(0)).into(iv1);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int num = rnd.nextInt(al.size());
                Picasso.with(getContext()).load(al.get(num)).into(iv1);
            }
        });
        return view;
    }
}