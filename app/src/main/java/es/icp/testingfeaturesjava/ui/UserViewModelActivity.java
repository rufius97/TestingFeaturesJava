package es.icp.testingfeaturesjava.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import es.icp.testingfeaturesjava.R;
import es.icp.testingfeaturesjava.util.User;
import es.icp.testingfeaturesjava.viewmodel.SumarViewModel;
import es.icp.testingfeaturesjava.viewmodel.UserViewModel;

public class UserViewModelActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEdad;
    private Button   btSalvar;
    private Button   btVerUser;
    private TextView tvUser;
    private TextView tvUserViewModel;

    private List<User>    userList;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_model);

        setUpView();
    }

    private void setUpView() {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userList = new ArrayList<>();

        tvUser          = findViewById(R.id.tvUser);
        tvUserViewModel = findViewById(R.id.tvUserViewModel);

        etNombre = findViewById(R.id.etNombre);
        etEdad   = findViewById(R.id.etEdad);

        btSalvar = findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setEdad(etEdad.getText().toString());
                user.setNombre(etNombre.getText().toString());
                userList.add(user);

                userViewModel.addUser(user);
            }
        });
        btVerUser = findViewById(R.id.btVer);
        btVerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "";
                for (int i = 0; i < userList.size(); i++) {
                    texto += userList.get(i).getNombre() + " " + userList.get(i).getEdad() + "\n";
                }
                tvUser.setText(texto);
                texto = "";
                for(User user: userViewModel.getUserList()){
                    texto += user.getNombre() + " " + user.getEdad()+"\n";
                }
                tvUserViewModel.setText(texto);
            }
        });
    }
}
