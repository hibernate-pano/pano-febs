package kit.pano.febs.web.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品订单日志
 * </p>
 *
 * @author Pano
 * @since 2019-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "LitemallOrderLog对象", description = "商品订单日志")
public class LitemallOrderLog extends Model<LitemallOrderLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作人角色ID")
    private Long operatorRoleId;

    @ApiModelProperty(value = "操作人角色")
    private String operatorRole;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "新增时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标识0未删除1已删除")
    private Integer deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
