package com.study.velueObject;/**
 * @ClassName UnitMessage
 * @Author zhaoTj
 * @Date 2021/6/6 10:01 下午
 * @Version 1.0
 */

/**
 *@ClassName UnitMessage
 *@Description TODO
 *@Author beihai
 *@Date 2021/6/6 10:01 下午
 *@Version 1.0
 */
public class UnitMessage {
    // 楼宇编码
    private String buildingCode;
    // 单元数量
    private Integer unitCount;

    public UnitMessage() {
    }

    public UnitMessage(String buildingCode, Integer unitCount) {
        this.buildingCode = buildingCode;
        this.unitCount = unitCount;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    @Override
    public String toString() {
        return "UnitMessage{" +
                "buildingCode='" + buildingCode + '\'' +
                ", unitCount=" + unitCount +
                '}';
    }
}
