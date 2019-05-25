package com.software.pm.common.config;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

/**
 * @ClassName Constants
 * @Description 系统常量类
 * @Author liziguang
 * @Date 2019-04-19 下午 12:38
 **/
public class Constants {

    public static final int PAGESIZE = 5;
//    public static final List ROLE = Arrays.asList("dev","qa","pm","po","admin");

    /**
     * 角色
     */
    public static enum Role {
        DEV("dev", "研发人员"),
        QA("qa", "测试人员"),
        PM("pm", "项目经理"),
        PO("po", "产品经理"),
        ADMIN("admin", "管理员");

        private Role(String value, String name) {
            this.value = value;
            this.name = name;
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 性别
     */
    public static enum Gender {
        MAN("m", "男"),
        FEMAN("f", "女");

        private Gender(String value, String name) {
            this.value = value;
            this.name = name;
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 启用禁用状态
     */
    public static enum EnableState {
        DELETE("1", "禁用"),
        ENABLE("0", "启用");

        private EnableState(String value, String name) {
            this.value = value;
            this.name = name;
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 验证状态
     */
    public static enum Verification {
        NOTFIN(null, "未完成"),
        AWAIT("0", "待验证"),
        PASS("1", "已通过"),
        FALL("2", "未通过");

        private Verification(String value, String name) {
            this.value = value;
            this.name = name;
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
}
