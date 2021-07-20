package individualFinance.saveLoad;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private static Users usersInst;
    private static List<User> users = new ArrayList<>();
    boolean saved = false;

    private Users(){
    }

    public static Users getInstance(){
        if(usersInst == null) usersInst = new Users();
        return usersInst;
    }


    public void addUser(User user){
        users.add(user);
    }

   /* public void changePassword(User user, String newPassword){
        user.setPassword(newPassword);
    }*/

    public List<User> getUsers() {
        return users;
    }

    public User getUser(User user) {
        for (User data: users) {
            if(data.getLogin().equals(user.getLogin()) && data.getPassword().equals(user.getPassword()))
                return data;
        }
        return null;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void load(){
        SaveLoad.load(this);
        saved = false;
    }

    public void save() {
        SaveLoad.save(this);
        saved = true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (User data: users) {
            builder.append(data.toString());
            builder.append("\n \n \n");
        }
        return new String(builder);
    }

    public void clearUser(){
        for (User user : Users.getInstance().getUsers()) {
            if(user.isSave())
               user.getAccounts().clear();
               user.getArticles().clear();
               user.getCurrencies().clear();
               user.getTransfers().clear();
               user.getTransactions().clear();
        }
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
