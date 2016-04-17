package com.ncut.ssm.pojo;

public class HotGirlPic {
    private Integer hotgirlpicid;

    private String hotgirlpicdir;

    private Integer hotgirlgroupnum;

    public Integer getHotgirlpicid() {
        return hotgirlpicid;
    }

    public void setHotgirlpicid(Integer hotgirlpicid) {
        this.hotgirlpicid = hotgirlpicid;
    }

    public String getHotgirlpicdir() {
        return hotgirlpicdir;
    }

    public void setHotgirlpicdir(String hotgirlpicdir) {
        this.hotgirlpicdir = hotgirlpicdir == null ? null : hotgirlpicdir.trim();
    }

    public Integer getHotgirlgroupnum() {
        return hotgirlgroupnum;
    }

    public void setHotgirlgroupnum(Integer hotgirlgroupnum) {
        this.hotgirlgroupnum = hotgirlgroupnum;
    }
}