package com.sinosoft.cpyy.util;


import java.util.UUID;

/**
 * 创建时间：2018/三月/31
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：FileServerUUIDUtil
 * 描述：UUID生成
 */
public class FileServerUUIDUtil {

    /**
     * UUID含义是通用唯一识别码 (Universally Unique Identifier)，
     * 这是一个软件建构的标准，也是被开源软件基金会 (Open Software Foundation, OSF)
     * 的组织在分布式计算环境 (Distributed Computing Environment, DCE) 领域的一部份。
     * <p>
     * UUID 的目的是让分布式系统中的所有元素，都能有唯一的辨识资讯，而不需要透过中央控制端来做辨识资讯的指定。
     * <p>
     * 如此一来，每个人都可以建立不与其它人冲突的 UUID。在这样的情况下，就不需考虑数据库建立时的名称重复问题。
     * <p>
     * 目前最广泛应用的 UUID，即是微软的 Microsoft's Globally Unique Identifiers (GUIDs)，而其他重要的应用，
     * 则有 Linux ext2/ext3 档案系统、LUKS 加密分割区、GNOME、KDE、Mac OS X 等等
     *
     * @return 返回UUID
     */
    public static String getUUID() {
        String id = UUID.randomUUID().toString();
        id = id.replace("-", "");
        return id;
    }

    private FileServerUUIDUtil() {
    }
}
