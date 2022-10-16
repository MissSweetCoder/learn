package com.ziroom.算法.moka;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年12月16日 10:11:00
 */
public class DepartmentTest {
    public static List<Department> allSub = Lists.newArrayList();
    public static List<Department>  getSub(int index , List<Department> allDepartment){
        getSub(index,allDepartment,allSub);
        return allSub;
    }

    private static void getSub(int index, List<Department> allDepartment, List<Department> allSub) {
        List<Department> thisSub = allDepartment.stream().filter(department -> index == department.getPid()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(thisSub)){
            return;
        }
        allSub.addAll(thisSub);
        thisSub.stream().forEach(sub -> getSub(sub.getId(),allDepartment,allSub));
    }
}
