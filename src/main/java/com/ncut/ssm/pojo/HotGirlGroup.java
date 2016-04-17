package com.ncut.ssm.pojo;

public class HotGirlGroup {
    private Integer hotgirlid;

    private Integer hotgirlgroupnum;

    private String hotgirlgroupname;

    public Integer getHotgirlid() {
        return hotgirlid;
    }

    public void setHotgirlid(Integer hotgirlid) {
        this.hotgirlid = hotgirlid;
    }

    public Integer getHotgirlgroupnum() {
        return hotgirlgroupnum;
    }

    public void setHotgirlgroupnum(Integer hotgirlgroupnum) {
        this.hotgirlgroupnum = hotgirlgroupnum;
    }

    public String getHotgirlgroupname() {
        return hotgirlgroupname;
    }

    public void setHotgirlgroupname(String hotgirlgroupname) {
        this.hotgirlgroupname = hotgirlgroupname == null ? null : hotgirlgroupname.trim();
    }
}