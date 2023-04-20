package tyut.selab.desktop.moudle.student.userservice.impl;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;
import tyut.selab.desktop.moudle.student.userservice.IUserService;
import java.util.ArrayList;
import java.util.List;
public class UserService implements IUserService {
    private IUserDao userDao;

    @Override
    public List<UserVo> queryUser() {
        List<UserVo> list = new ArrayList<>();
        UserVo userVo = new UserVo();
        for (User user : userDao.queryUser()) {
            list.add(User_UserVo(userVo, user));
        }
        return list;
    }

    @Override
    public UserVo queryUserByStudentNumber(Integer studentNumber) {
        UserVo userVo = new UserVo();
        User user = userDao.queryUserByStudentNumber(studentNumber);
        return User_UserVo(userVo, user);
    }

    @Override
    public UserVo queryUserByStudentName(String name) {
        UserVo userVo = new UserVo();
        User user = userDao.queryUserByStudentName(name);
        return User_UserVo(userVo, user);
    }

    @Override
    public int insertUser(UserRegisterVo user) {
        User use = new User();
        use.setStudentNumber(user.getStudentNumber());
        use.setName(user.getName());
        use.setAccountNumber(user.getAccountNumber());
        use.setGender(user.getGender());
        use.setPost(user.getPost());
        use.setPassword(String.valueOf(user.getPassword()));
        use.setPhone(user.getPhone());
        return judge(userDao.insertUser(use));
    }

    @Override
    public int updateUserPassword(String password, UserVo user) {
        User use = new User();
        use = UserVo_User(user, use);
        return judge(userDao.updateUser(password, use));
    }

    @Override
    public int updateUser(UserVo oldUser, UserVo newUser) {
        User oldUse = new User();
        oldUse = UserVo_User(oldUser, oldUse);
        User newUse = new User();
        newUse = UserVo_User(newUser, newUse);
        return judge(userDao.updateUser(oldUse, newUse));
    }

    @Override
    public int deleteUser(int studentNumber) {
        return judge(userDao.deleteUser(studentNumber));
    }

    @Override
    public List<Role> queryAllRole() {
        List<Role> list = new ArrayList<>();
        for (Role role : userDao.queryAllRole()) {
            list.add(role);
        }
        return list;
    }

    @Override
    public int insertRole(Role role) {
        return judge(userDao.insertRole(role));
    }

    @Override
    public int deleteRole(Role role) {
        return judge(userDao.deleteRole(role));
    }

    public static UserVo User_UserVo(UserVo userVo, User user) {
        userVo.setStudentNumber(user.getStudentNumber());
        userVo.setName(user.getName());
        userVo.setAccountNumber(user.getAccountNumber());
        userVo.setGender(user.getGender());
        userVo.setPhone(user.getPhone());
        userVo.setPost(user.getPost());
        userVo.setDuty(String.valueOf(user.getRole()));
        return userVo;
    }

    public static int judge(int judge) {
        if (judge > 0) {
            return 1;
        } else
            return -1;
    }

    public static User UserVo_User(UserVo userVo, User user) {
        Role role = new Role();
        user.setStudentNumber(userVo.getStudentNumber());
        user.setName(userVo.getName());
        user.setAccountNumber(userVo.getAccountNumber());
        user.setGender(userVo.getGender());
        user.setPost(userVo.getPost());
        user.setPhone(userVo.getPhone());
        role.setDuty(userVo.getDuty());
        user.setRole(role);
        return user;
    }
}