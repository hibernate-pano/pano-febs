package kit.pano.febs.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import kit.pano.febs.system.domain.po.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);

    List<String> findUserIdsByRoleId(String[] roleIds);
}
