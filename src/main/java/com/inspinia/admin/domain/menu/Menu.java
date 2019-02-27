package com.inspinia.admin.domain.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {

    /** 菜单ID */
    @NotNull(message = "主键不能为空",groups = {Menu.class})
    private Long id;

    /** 父菜单ID */
    @NotNull(message = "父菜单ID不能为空")
    private Long pid;

    /** 菜单名称 */ @NotNull(message = "菜单名称不能为空")
    private String name;

    /** 父菜单名称 */
    private String parentName;

    /** 菜单图标 */
    private String icon;

    /** 请求路径 */
    private String url;

    /** 授权路径规则 */
    private String authUrl;

    /** HTTP请求类型：1-GET,2-POST,3-PUT,4-DELETE,5-HEAD,6-OPTIONS,7-TRACE,8-PATCH */
    private int httpMethod;

    /** 参数 */
    private String param;

    /** 菜单类型:1后台菜单,2前台按钮 */
    private int type;

    /** 菜单类型;1:有界面可访问菜单,2:无界面可访问菜单,0:只作为菜单,3只作为分组标题 */
    private int menuType;

    /** 菜单状态:0隐藏,1显示 */
    private int status;

    /** 排序 */
    private Long listOrder;

    /** 备注 */
    private String remark;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date isDelete;

    /** 子菜单 */
    private List<Menu> children = new ArrayList<Menu>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public int getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(int httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getListOrder() {
        return listOrder;
    }

    public void setListOrder(Long listOrder) {
        this.listOrder = listOrder;
    }

    public Date getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Date isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("menuId", getId())
                .append("pid", getPid())
                .append("name", getName())
                .append("icon", getIcon())
                .append("url", getUrl())
                .append("authUrl", getAuthUrl())
                .append("httpMethod", getHttpMethod())
                .append("param", getParam())
                .append("type", getType())
                .append("menuType", getMenuType())
                .append("status", getStatus())
                .append("listOrder", getListOrder())
                .append("remark", getRemark())
                .append("gmtCreate", getGmtCreate())
                .append("gmtModified", getGmtModified())
                .toString();
    }
}
