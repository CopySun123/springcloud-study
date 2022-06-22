package com.copysun.camunda.camunda.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @Author copysun
 * @Date: Create in 16:05 2022/6/21
 * @Desc
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductInfoVo {
	@NotBlank(message = "商品名称不允许为空")
	@ApiModelProperty(value="商品名称",dataType="String")
	private String productName;

	@Min(value = 0, message = "商品价格不允许为负数")
	@ApiModelProperty(value="商品价格",dataType="Number")
	private BigDecimal productPrice;

	@ApiModelProperty(value="商品状态",dataType="Number")
	private Integer productStatus;
}
