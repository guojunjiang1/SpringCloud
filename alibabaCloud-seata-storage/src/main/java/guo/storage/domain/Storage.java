package guo.storage.domain;

import lombok.Data;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 11:44
 */
@Data
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
