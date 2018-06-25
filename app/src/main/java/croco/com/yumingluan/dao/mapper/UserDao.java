package croco.com.yumingluan.dao.mapper;

import croco.com.yumingluan.bean.User;

/**
 * Created by Administrator on 2018/1/6 0006.
 */
public class UserDao extends BaseDao {

    private UserMapper userMapper;

    public UserDao(){
        this.userMapper=getSqlSession().getMapper(UserMapper.class);
    }

    public User getUser(int id){
        User user = userMapper.getUser(id);
        System.out.println(user.getName());
        return user;
    }

    public User getUserByNamePasswd(String name,String passwd){

        User user = userMapper.getUserByNamePasswd(name,passwd);
        System.out.println(user);
        return user;
    }
    public User getUserByName(String name){
        User user = userMapper.getUserByName(name);
        System.out.println(user);
        return user;
    }
}
