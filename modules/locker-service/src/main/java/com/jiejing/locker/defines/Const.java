package com.jiejing.locker.defines;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface Const {

    enum OptType {
        CX("存箱"), QX("取箱");
        private String value;

        OptType(String value) {
            this.value = value;
        }
    }

    enum Status {
        ENABLE("启用"), DISENABLE("禁用"), ERROR("异常");
        private String value;

        Status(String value) {
            this.value = value;
        }
    }

    enum ChargeType {
        TIME_HOUR("时间节点"), TIME_CYCLE("时间段收费");
        private String value;

        ChargeType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum GateLockState {
        OPEN("打开"), CLOSE("禁用"), ERROR("异常");
        private String value;

        GateLockState(String value) {
            this.value = value;
        }
    }

    enum DepositState {
        Y("有存物"), N("无存物"), ERROR("异常"),ZY("占用");;
        private String value;

        DepositState(String value) {
            this.value = value;
        }
    }

    enum BoxState {
        DQ("待取"), YQ("已取"),ZY("占用");
        private String value;

        BoxState(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum OrderState {
        DZF("待支付"), YZF("已支付"), YQX("已取消"), YWC("已完成"), YGB("已关闭");
        private String value;

        OrderState(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
