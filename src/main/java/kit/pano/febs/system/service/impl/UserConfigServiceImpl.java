package kit.pano.febs.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kit.pano.febs.common.service.CacheService;
import kit.pano.febs.system.dao.UserConfigMapper;
import kit.pano.febs.system.domain.po.UserConfig;
import kit.pano.febs.system.service.UserConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pano
 */
@Service("userConfigService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserConfigServiceImpl extends ServiceImpl<UserConfigMapper, UserConfig> implements UserConfigService {

    @Resource
    private CacheService cacheService;

    @Override
    public UserConfig findByUserId(String userId) {
        return baseMapper.selectById(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void initDefaultUserConfig(String userId) {
        UserConfig userConfig = new UserConfig();
        userConfig.setUserId(Long.valueOf(userId));
        userConfig.setColor(UserConfig.DEFAULT_COLOR);
        userConfig.setFixHeader(UserConfig.DEFAULT_FIX_HEADER);
        userConfig.setFixSiderbar(UserConfig.DEFAULT_FIX_SIDERBAR);
        userConfig.setLayout(UserConfig.DEFAULT_LAYOUT);
        userConfig.setTheme(UserConfig.DEFAULT_THEME);
        userConfig.setMultiPage(UserConfig.DEFAULT_MULTIPAGE);
        baseMapper.insert(userConfig);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByUserId(String... userIds) {
        List<String> list = Arrays.asList(userIds);
        baseMapper.deleteBatchIds(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserConfig userConfig) throws Exception {
        baseMapper.updateById(userConfig);
        cacheService.saveUserConfigs(String.valueOf(userConfig.getUserId()));
    }
}
