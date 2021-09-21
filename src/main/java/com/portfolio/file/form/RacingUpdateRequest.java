package com.portfolio.file.form;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RacingUpdateRequest extends RacingRequest implements Serializable{
    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 1L;
    /**
     * ユーザーID
     */
    @NotNull
    private Integer id;

}
