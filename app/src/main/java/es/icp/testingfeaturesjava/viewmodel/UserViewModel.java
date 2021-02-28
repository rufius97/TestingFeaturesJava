package es.icp.testingfeaturesjava.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.icp.testingfeaturesjava.util.User;

public class UserViewModel extends ViewModel {

    private List<User> userList;

    public UserViewModel() {
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
